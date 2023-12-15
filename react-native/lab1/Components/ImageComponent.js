
import { Image, StyleSheet, Text, View } from 'react-native';
import DateTimePicker from '@react-native-community/datetimepicker';

export default function ImageComponent({title, url}) {
  return (
    <View style={styles.viewStyle}>      
      <Image
      style={styles.imageStyle} 
      src={url}>      
      </Image>
      {/* <DateTimePicker value={new Date()} /> */}
      <Text>{title}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  viewStyle: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
       
},
imageStyle: {
    width: 350,
    height: 250,  
    
},
  
});
