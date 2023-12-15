import { StatusBar } from 'expo-status-bar';
import React, {useState} from 'react';
import ImageComponent from './Components/ImageComponent';
import { StyleSheet, Text, TextInput, View, Button } from 'react-native';

export default function App() {
  const [text, setText] = useState('');
  return (
    <View style={styles.container}>                  
      <ImageComponent 
      title='Arctic Fox' 
      url='https://media.istockphoto.com/id/517464158/photo/an-arctic-fox-in-snow-looking-at-the-camera.jpg?s=1024x1024&w=is&k=20&c=XDfQ0y15d-avJSZURi3knEs-nhaqnrb3cAqsuH5Q_z0='>      
      </ImageComponent>
      <TextInput
      placeholder='Type here' 
      onChangeText={newText=> setText(newText)}     
      defaultValue = {text}
      onFocus= { () => {setText('')}}
      ></TextInput>
      <Text>{text}</Text>
      <Button title='Clear'
      onPress={() => setText('')}/>      
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',    
  },
});
