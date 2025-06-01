;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use CycleBet)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm2 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance rm2 of Rm
	(properties
		picture 200
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 939)
		(theBag init:)
		(cansMan init:)
		(pop1 init:)
		(pop2 init:)
		(pop3 init:)
		(charlie init:)
		(bottle init:)
		(drawer init:)
		(bubbles init:)
		(door init:)
		(plate init:)
		(slater init:)
		(rock init:)
		(aWord0 init:)
		(aWord1 init:)
		(aWord2 init:)
		(aWord3 init:)
		(aWord4 init:)
		(aWord5 init:)
		(aWord6 init:)
		(aWord7 init:)
		(aWord8 init:)
		(aWord9 init:)
		(sleeper init:)
		(faucet init:)
		(drawer1 init:)
		(tv init:)
		(gLongSong number: 113 setLoop: -1 play: 10 fade: 127 10 30 0)
		(gCurRoom setScript: rockScript)
	)

	(method (doit)
		(super doit:)
		(if (and global120 (not local6) (not (gCurRoom script:)))
			(= local6 1)
			(self setScript: (ScriptID 0 4)) ; runScript
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (dispose)
		(mySound dispose:)
		(my2Sound dispose:)
		(DisposeScript 939)
		(DisposeScript 874)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade: 0 10 30 1)
		(super newRoom: newRoomNumber)
	)
)

(instance rockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rock setCel: 1)
				(= ticks 40)
			)
			(1
				(gGame handsOff:)
				(theView view: 270 setLoop: 0 setCel: 1 posn: 78 181 init:)
				(mySound number: 1043 setLoop: 1 play:)
				(= ticks 13)
			)
			(2
				(gGame handsOff:)
				(theProp view: 270 setLoop: 1 setCel: 1 posn: 145 181 init:)
				(= ticks 37)
			)
			(3
				(theView view: 270 setLoop: 2 setCel: 1 posn: 189 181 init:)
				(= ticks 8)
			)
			(4
				(= ticks 31)
			)
			(5
				(theProp view: 270 setLoop: 3 setCel: 1 posn: 249 181 init:)
				(= ticks 35)
			)
			(6
				(theView hide: dispose:)
				(= ticks 29)
			)
			(7
				(theProp hide: dispose:)
				(rock setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tvScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(my2Sound number: 904 setLoop: 1 play:)
				(mySound number: 916 setLoop: 1 play:)
				(tvScreen init: setCycle: Fwd)
				(= ticks 50)
			)
			(1
				(switch (= local7 (Random 1 3))
					(1
						(mySound number: 975 setLoop: 1 play:)
						(tvScreen
							setLoop: local7
							setCel: 0
							setCycle: CT 3 1 self
						)
					)
					(2
						(mySound number: 916 setLoop: 1 play:)
						(tvScreen
							setLoop: local7
							setCel: 0
							setCycle: CT 6 1 self
						)
					)
					(3
						(mySound number: 1018 setLoop: -1 play:)
						(tvScreen
							setLoop: local7
							setCel: 0
							setCycle: CT 1 1 self
						)
					)
				)
			)
			(2
				(switch local7
					(1
						(my2Sound number: 909 setLoop: 1 play:)
						(tvScreen setLoop: local7 setCycle: CT 5 1 self)
					)
					(2
						(= ticks 50)
					)
					(3
						(tvScreen setCycle: CycleBet 0 1 -1)
						(= ticks 150)
					)
				)
			)
			(3
				(switch local7
					(1
						(mySound stop:)
						(tvScreen setCycle: CT 10 1 self)
					)
					(2
						(mySound number: 947 setLoop: 1 play:)
						(tvScreen setCycle: CT 10 1 self)
					)
					(3
						(tvScreen setCycle: CT 6 1 self)
					)
				)
			)
			(4
				(switch local7
					(1
						(mySound number: 1036 setLoop: 1 play:)
						(tvScreen setCycle: CT 15 1 self)
					)
					(2
						(= ticks 75)
					)
					(3
						(mySound number: 1002 setLoop: 1 play: self)
					)
				)
			)
			(5
				(switch local7
					(1
						(self cue:)
					)
					(2
						(mySound number: 916 setLoop: 1 play:)
						(tvScreen setCycle: CT 15 1 self)
					)
					(3
						(mySound number: 929 setLoop: 1 play:)
						(tvScreen setCycle: CT 12 1 self)
					)
				)
			)
			(6
				(mySound number: 904 setLoop: 1 play:)
				(theScreen
					setLoop: 4
					setCel: 0
					init:
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(7
				(= ticks 12)
			)
			(8
				(tvScreen setLoop: 0 setCel: 0 posn: 176 64 hide: dispose:)
				(theScreen setCel: 0 hide: dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sleeperScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sleeper view: 260 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(sleeper setCycle: End self)
				(mySound number: 945 setLoop: 1 play:)
			)
			(2
				(mySound number: 981 setLoop: 1 play:)
				(sleeper setLoop: 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(3
				(sleeper setLoop: 1 setCycle: CT 9 1 self)
			)
			(4
				(mySound number: 981 setLoop: 1 play:)
				(sleeper setLoop: 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(5
				(sleeper setLoop: 1 setCycle: CT 9 1 self)
			)
			(6
				(mySound number: 981 setLoop: 1 play:)
				(sleeper setLoop: 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(7
				(sleeper setLoop: 1 setCycle: CT 9 1 self)
			)
			(8
				(mySound number: 945 setLoop: 1 play:)
				(sleeper setLoop: 2 setCel: 0 setCycle: End self)
			)
			(9
				(mySound stop:)
				(sleeper view: 265 setLoop: 0 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(slater
					view: 215
					setLoop: 0
					setCel: 0
					posn: 91 119
					setCycle: End self
				)
			)
			(1
				(slater setLoop: 1 setCel: 0 setPri: 6 setCycle: CT 3 1 self)
			)
			(2
				(slaterArm init:)
				(slater setCel: 4)
				(= ticks 3)
			)
			(3
				(mySound number: 961 setLoop: -1 play:)
				(slaterArm show: posn: 92 123 ignoreActors: setCycle: Fwd)
				(= ticks 50)
			)
			(4
				(mySound stop:)
				(slaterArm setCycle: 0 hide: dispose:)
				(slater setLoop: 3 setCel: 0 setCycle: CT 4 1 self)
			)
			(5
				(= ticks 20)
			)
			(6
				(slater setCycle: CT 6 1 self)
			)
			(7
				(slater setLoop: 4 setCel: 0)
				(= ticks 6)
			)
			(8
				(slater view: 216 setLoop: 0 setCel: 0 setCycle: CT 3 1 self)
			)
			(9
				(slater setCycle: CT 5 1 self)
				(mySound number: 908 setLoop: 1 play:)
			)
			(10
				(mySound number: 907 setLoop: 1 play:)
				(slater setLoop: 1 setCel: 0 setPri: 6 setCycle: Fwd)
				(= ticks 120)
			)
			(11
				(mySound number: 988 setLoop: 1 play:)
				(slater setLoop: 2 setCel: 0 setPri: 6 setCycle: End self)
			)
			(12
				(slater setLoop: 3 setCel: 0 setPri: 6 setCycle: End self)
			)
			(13
				(mySound stop:)
				(slater view: 265 setLoop: 2 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance plateScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local5
					(= local5 0)
					(plate posn: 232 57)
					(= local4 1)
				else
					(plate posn: 89 54)
					(= local5 1)
					(= local4 0)
				)
				(plate
					view: 235
					setPri: 14
					setLoop: local4
					setCel: 0
					setCycle: CT 1 1 self
				)
			)
			(1
				(plate setCycle: CT 3 1 self)
				(my2Sound number: 991 setLoop: 1 play:)
			)
			(2
				(plate setCycle: CT 5 1 self)
			)
			(3
				(mySound number: 102 setLoop: 1 play:)
				(plate setCycle: CT 9 1 self)
			)
			(4
				(my2Sound stop:)
				(plate view: 265 setLoop: 1 setCel: 7 posn: 148 65 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theBagScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(my2Sound number: 937 setLoop: 1 play:)
				(theDino init: setCycle: CT 8 1 self)
				(mySound number: 912 setLoop: -1 play:)
			)
			(1
				(my2Sound number: 940 setLoop: 1 play:)
				(theDino setPri: 2 setCycle: CT 11 1 self)
			)
			(2
				(theDino setPri: 10 setCycle: CT 14 1 self)
			)
			(3
				(theDino
					setPri: 8
					posn: 92 119
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(mySound stop:)
				(gGame handsOn:)
				(theDino
					setLoop: 0
					setCel: 0
					posn: 99 114
					setPri: 11
					hide:
					dispose:
				)
				(self dispose:)
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 111 setLoop: -1 play:)
				(door
					view: 245
					setLoop: 0
					setCel: 0
					posn: 238 102
					setCycle: CT 1 1 self
				)
			)
			(1
				(mySound number: 968 setLoop: 1 play:)
				(my2Sound number: 972 setLoop: -1 play:)
				(self cue:)
			)
			(2
				(door setPri: 4 setCel: 2 setCycle: End self)
			)
			(3
				(door setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(door setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(my2Sound number: 990 setLoop: 1 play:)
				(door setLoop: 3 setCel: 0)
				(= ticks 60)
			)
			(6
				(door setCycle: End self)
			)
			(7
				(mySound number: 963 setLoop: 1 play:)
				(door
					view: 265
					posn: 254 95
					setLoop: 1
					setCel: 5
					setPri: 5
					stopUpd:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bubblesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local1)
					(bubbles view: 250 setLoop: 0 setCel: 0 setCycle: End self)
					(= local1 1)
					(mySound number: 964 setLoop: 1 play:)
				else
					(self cue:)
				)
			)
			(1
				(if (not local0)
					(bubbles setLoop: 1 setCel: 0 setCycle: CT 1 1 self)
				else
					(self cue:)
				)
			)
			(2
				(mySound number: 1168 setLoop: 1 play:)
				(if (not local0)
					(bubbles setCycle: CT 10 1 self)
				else
					(self cue:)
				)
			)
			(3
				(if (not local0)
					(= ticks 120)
				else
					(self cue:)
				)
			)
			(4
				(if (not local0)
					(bubbles setCycle: CT 15 1 self)
				else
					(self cue:)
				)
			)
			(5
				(if (and local0 local1)
					(bubbles view: 250 setLoop: 0 setCel: 7 setCycle: Beg self)
					(mySound number: 964 setLoop: 1 play:)
				else
					(mySound number: 1157 setLoop: 1 play:)
					(bubbles setLoop: 2 setCel: 0 setCycle: End self)
				)
			)
			(6
				(if (and local0 local1)
					(self cue:)
				else
					(bubbles setLoop: 3 setCel: 0 setCycle: End self)
				)
			)
			(7
				(mySound stop:)
				(if (and local0 local1)
					(= local1 0)
					(= local0 0)
					(bubbles view: 265 setLoop: 1 setCel: 4 stopUpd:)
				else
					(bubbles stopUpd:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance drawerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local3
					(drawer1 setPri: 10)
					(= local2 drawer1)
				else
					(= local2 drawer)
				)
				(local2
					view: 240
					setLoop: 0
					setCel: 0
					setPri: 10
					setCycle: CT 1 1 self
				)
			)
			(1
				(local2 setCycle: End self)
				(mySound number: 968 setLoop: 1 play:)
			)
			(2
				(mySound number: 1155 setLoop: 1 play:)
				(local2 setLoop: 1 setCycle: Fwd)
				(= cycles 1)
			)
			(3
				(= seconds 3)
			)
			(4
				(= local3 0)
				(= ticks 6)
			)
			(5
				(local2 setLoop: 2 setCel: 0 setCycle: End self)
				(mySound number: 926 setLoop: 1 play:)
				(local2 setPri: 9)
			)
			(6
				(local2 view: 265 setLoop: 1 setCel: 6 setPri: 9 stopUpd:)
				(drawer1 setPri: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bottleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 10)
			)
			(1
				(gLongSong stop:)
				(mySound number: 965 setLoop: 1 play:)
				(bottle view: 230 setLoop: 0 setCel: 0 setCycle: CT 10 1 self)
			)
			(2
				(= ticks 12)
			)
			(3
				(gLongSong play:)
				(bottle setCycle: CT 14 1 self)
			)
			(4
				(bottle view: 265 setLoop: 1 setCel: 3 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance charlieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(charlie view: 205 setLoop: 0 setCel: 0 setCycle: CT 3 1 self)
			)
			(1
				(mySound number: 962 setLoop: 1 play:)
				(charlie setCycle: CT 14 1 self)
			)
			(2
				(charlie view: 265 setLoop: 0 setCel: 2 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pop1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pop1 view: 220 setLoop: 0 setCel: 0 setCycle: CT 3 1 self)
			)
			(1
				(mySound number: 969 setLoop: 1 play:)
				(pop1 setCycle: CT 8 1 self)
			)
			(2
				(mySound stop:)
				(pop1 setCycle: CT 11 1 self)
			)
			(3
				(pop1 view: 265 setLoop: 1 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pop2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pop2 view: 225 setLoop: 0 setCel: 0 setCycle: CT 4 1 self)
			)
			(1
				(mySound number: 970 setLoop: 1 play:)
				(pop2 setCycle: CT 10 1 self)
			)
			(2
				(mySound stop:)
				(pop2 setCycle: CT 12 1 self)
			)
			(3
				(pop2 view: 265 setLoop: 1 setCel: 1 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pop3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 971)
				(gGame handsOff:)
				(pop3 view: 255 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 971 setLoop: 1 play:)
				(pop3 setCycle: CT 9 1 self)
			)
			(2
				(mySound stop:)
				(pop3 setCycle: CT 10 1 self)
			)
			(3
				(pop3 view: 265 setLoop: 1 setCel: 2 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cansManScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 112 setLoop: -1 play:)
				(cansMan view: 200 setLoop: 0 setCel: 0 setCycle: CT 3 1 self)
			)
			(1
				(cansMan setCycle: CT 8 1 self)
				(mySound number: 928 setLoop: 1 play:)
			)
			(2
				(cansMan setCycle: CT 9 1 self)
			)
			(3
				(mySound number: 967 setLoop: -1 play:)
				(cansMan
					setLoop: 4
					setCel: 0
					posn: 231 140
					setCycle: Walk
					setMotion: MoveTo 165 138 self
				)
			)
			(4
				(cansMan setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(cansMan
					setLoop: 3
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 240 139 self
				)
			)
			(6
				(cansMan setLoop: 2 setCel: 0 posn: 240 139 setCycle: End self)
			)
			(7
				(cansMan view: 200 setLoop: 0 setCel: 9 setCycle: CT 7 -1 self)
			)
			(8
				(mySound number: 928 setLoop: 1 play:)
				(cansMan setCycle: Beg self)
			)
			(9
				(mySound stop:)
				(cansMan view: 265 setLoop: 0 setCel: 1 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 173
		nsLeft 37
		nsBottom 181
		nsRight 60
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 0 posn: 48 181 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 173
		nsLeft 62
		nsBottom 181
		nsRight 91
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1062 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 1 posn: 76 181 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 173
		nsLeft 95
		nsBottom 181
		nsRight 128
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1063 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 2 posn: 110 181 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 173
		nsLeft 130
		nsBottom 181
		nsRight 145
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1058 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 3 posn: 137 181 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 173
		nsLeft 147
		nsBottom 181
		nsRight 162
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1064 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 4 posn: 154 181 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 173
		nsLeft 165
		nsBottom 181
		nsRight 176
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1065 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 5 posn: 170 181 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 173
		nsLeft 180
		nsBottom 181
		nsRight 211
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1066 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 6 posn: 194 181 init:)
	)
)

(instance aWord7 of InterFeature
	(properties
		nsTop 173
		nsLeft 213
		nsBottom 181
		nsRight 232
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1067 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 7 posn: 222 181 init:)
	)
)

(instance aWord8 of InterFeature
	(properties
		nsTop 173
		nsLeft 236
		nsBottom 181
		nsRight 257
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 8 posn: 245 181 init:)
	)
)

(instance aWord9 of InterFeature
	(properties
		nsTop 173
		nsLeft 259
		nsBottom 181
		nsRight 284
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1068 setLoop: 1 play: rm2)
		(theView view: 275 setLoop: 9 posn: 271 181 init:)
	)
)

(instance theBag of InterFeature
	(properties
		nsTop 94
		nsLeft 84
		nsBottom 121
		nsRight 127
	)

	(method (doVerb)
		(gCurRoom setScript: theBagScript)
	)
)

(instance faucet of InterFeature
	(properties
		nsTop 40
		nsLeft 90
		nsBottom 54
		nsRight 129
	)

	(method (doVerb)
		(if local1
			(= local0 1)
			(gCurRoom setScript: bubblesScript)
		)
	)
)

(instance tv of InterFeature
	(properties
		nsTop 36
		nsLeft 164
		nsBottom 60
		nsRight 200
	)

	(method (doVerb)
		(gCurRoom setScript: tvScript)
	)
)

(instance rock of InterView
	(properties
		x 29
		y 180
		view 280
		loop 3
		priority 15
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: rockScript)
	)
)

(instance theView of Prop
	(properties
		cel 1
		priority 15
		signal 16
	)
)

(instance theProp of Prop
	(properties
		cel 1
		priority 15
		signal 16
	)
)

(instance tvScreen of Prop
	(properties
		x 176
		y 64
		view 271
		priority 1
		signal 20497
	)
)

(instance theScreen of Prop
	(properties
		x 174
		y 58
		view 271
		loop 4
		priority 2
		signal 20497
	)
)

(instance sleeper of InterProp
	(properties
		x 74
		y 175
		view 265
		signal 20481
	)

	(method (doVerb)
		(sleeper setScript: sleeperScript)
	)
)

(instance bubbles of InterProp
	(properties
		x 108
		y 70
		view 265
		loop 1
		cel 4
		priority 2
		signal 20497
	)

	(method (doVerb)
		(bubbles setScript: bubblesScript)
	)
)

(instance drawer of InterProp
	(properties
		x 194
		y 102
		view 265
		loop 1
		cel 6
		priority 9
		signal 4113
	)

	(method (doVerb)
		(drawer setScript: drawerScript)
	)
)

(instance drawer1 of InterProp
	(properties
		x 194
		y 117
		view 265
		loop 1
		cel 6
		signal 4097
	)

	(method (doVerb)
		(= local3 1)
		(drawer1 setScript: drawerScript)
	)
)

(instance bottle of InterProp
	(properties
		x 69
		y 63
		view 265
		loop 1
		cel 3
		signal 1
	)

	(method (doVerb)
		(bottle setScript: bottleScript)
	)
)

(instance charlie of InterProp
	(properties
		x 158
		y 122
		view 265
		cel 2
		priority 10
		signal 17
	)

	(method (doVerb)
		(charlie setScript: charlieScript)
	)
)

(instance pop1 of InterProp
	(properties
		x 214
		y 62
		view 265
		loop 1
		signal 1
	)

	(method (doVerb)
		(pop1 setScript: pop1Script)
	)
)

(instance pop2 of InterProp
	(properties
		x 233
		y 64
		view 265
		loop 1
		cel 1
		signal 1
	)

	(method (doVerb)
		(pop2 setScript: pop2Script)
	)
)

(instance pop3 of InterProp
	(properties
		x 250
		y 66
		view 265
		loop 1
		cel 2
		signal 1
	)

	(method (doVerb)
		(pop3 setScript: pop3Script)
	)
)

(instance door of InterProp
	(properties
		x 254
		y 95
		view 265
		loop 1
		cel 5
		priority 5
		signal 17
	)

	(method (doVerb)
		(door setScript: doorScript)
	)
)

(instance plate of InterProp
	(properties
		x 148
		y 65
		view 265
		loop 1
		cel 7
		signal 1
	)

	(method (doVerb)
		(plate setScript: plateScript)
	)
)

(instance slater of InterProp
	(properties
		x 91
		y 119
		view 265
		loop 2
		priority 6
		signal 20497
	)

	(method (doVerb)
		(slater setScript: slaterScript)
	)
)

(instance slaterArm of InterProp
	(properties
		x 84
		y 119
		view 215
		loop 2
	)
)

(instance theDino of Actor
	(properties
		x 99
		y 114
		view 210
		priority 11
		signal 16400
	)
)

(instance cansMan of InterActor
	(properties
		x 240
		y 139
		view 265
		cel 1
		signal 4097
	)

	(method (doVerb)
		(cansMan setScript: cansManScript)
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

