import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.viewStyle}>
      <Text style={styles.viewStyle}>Box screen</Text>
      
    </View>
  );
}

const styles = StyleSheet.create({
  viewStyle: {
    borderTopWidth: 3,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-around',
    borderColor: 'blue',
    height: 400,
  },
  textStyle: {
    fontSize: 20,
    borderWidth: 5,
    borderColor: 'red',
    padding: 30,
    margin: 30
  }
});
