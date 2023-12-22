
import { useState } from 'react';
import { Button, StyleSheet, Text, TextInput, View, Switch } from 'react-native';

export default function App() {

  const [bmi, setBmi] = useState();
  const [hVal,sethVal] = useState();
  const [wVal,setwVal] = useState();
  const [category,setCategory] = useState(); 
  const [isEnabled,setIsEnabled] = useState(false);
  const [WeightUnits,setWeightUnits] = useState(false);
  const [HeightUnits,setHeightUnits] = useState(false);

  const toggleSwitch = () => {
    setIsEnabled(prevState => !prevState);    
    setWeightUnits(isEnabled ? 'kg' : 'lbs');    
    setHeightUnits(isEnabled ? 'm' : 'ft');     
  }
  const calculateBMI = () => {    
    if (setIsEnabled) { // metric
      if ((hVal < 2.5 && hVal > 0.3 ) && (wVal < 300 && wVal > 10)) {        
          var b = wVal / (hVal * hVal)   
          
          
      }
      else {
        setCategory('Invalid Values')
      }
    }      
    else if (!setIsEnabled) { // imperial
      console.log(hVal)
          console.log(wVal)
          console.log(b) 
      if ((hVal < 8 && hVal > 0.5 ) && (wVal < 700 && wVal > 7) ){        
          var b = (wVal / ((hVal * hVal) * 703))               
      }
      else {
        setCategory('Invalid Values')
      }
    }
    setBmi(Math.round(b))
    if(b < 18.5) {
      setCategory('Underweight')
    }
    else if (b < 24.9) {
      setCategory('Normal Weight')
    }
    else if (b < 29.9) {
      setCategory('Overweight')
    } 
    else {
      setCategory('Obesity')
    }       

  }    
  
  
  const clear = () => { 
    sethVal()
    setwVal()
    setBmi()
    setCategory('')
  }
  return (
    <View style={styles.container}>
    <View style={styles.topViewStyle}></View>
      <View style={styles.topView}>
      <View style={styles.nestedView}>
        <Text style={styles.textStyle}>Your Height</Text>
          <TextInput
            style={styles.textinput}
            placeholder='Height'
            value={hVal}
            onChangeText={(v) => {
              sethVal(v);
            }}
          >
            
          </TextInput>
       <Text style={{...styles.textStyle, marginStart: 10}}>({HeightUnits})</Text>
        </View>
      
      <View style={styles.nestedView}>
        <Text style={styles.textStyle}>Your Weight</Text>
          <TextInput
            style={styles.textinput}
            placeholder='Weight'
            value={wVal}
             onChangeText={(v) => {
               setwVal(v);
            }}
          ></TextInput>
       <Text style={{...styles.textStyle, marginStart: 10}}>({WeightUnits})</Text>
        </View>
        <View style={styles.nestedView}>
        <Text style={{...styles.textStyle, marginStart: 100, fontSize: 15}}>Metric</Text>        
        <Switch title='toggle units' 
                style={{...styles.textinput, fontSize:31, marginEnd: 10, marginBottom: 50}}
                trackColor={{false: '#767577', true: '#81b0ff'}}
                thumbColor={isEnabled ? '#f5dd4b' : '#f4f3f4'}                
                onValueChange={toggleSwitch}
                value={isEnabled} />
                <Text style={{...styles.textStyle, marginEnd: 50, paddingEnd: 40, fontSize:15}}>Imperial</Text></View>
        <Button title='Compute BMI' onPress={calculateBMI} > </Button>
        <Button title='Clear' onPress={clear} > </Button>
     
      </View>
     
      <View style={styles.bottomView}>
        <Text style={styles.textStyle}> Your BMI is: { bmi } </Text>
        <Text style={styles.textStyle}>{category}</Text>

      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    justifyContent: 'flex-start',
  },
  topView: {
    backgroundColor: '#ff5349',
    justifyContent:'center',
    borderColor: 'black',
    borderWidth:2,
    flex : 1
  },
  bottomView: {
     borderColor: 'black',
    borderWidth:2,
    flex: 1,
    justifyContent: 'center',
    alignItems:'center'
    
  },
  switchView: {
    justifyContent: 'center',
    
    alignItems: 'center',
    flexDirection: 'column',        
  },
  nestedView: {
    margin: 20,
    flexDirection: 'row',
   
  },
  textStyle: {
    fontSize: 30,
    marginEnd: 10
  },
  textinput: {
    flex: 1,
    borderWidth: 2,
    fontSize:30,
    borderColor: 'black'
  }
});
