;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use DPath)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm3 0
)

(local
	local0
)

(instance rm3 of Rm
	(properties
		picture 300
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(super init:)
		(aCaveMan init:)
		(aDiner init:)
		(anEgg init:)
		(aPicture init:)
		(aTiger init:)
		(aVacumn init:)
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
		(aWord10 init:)
		(aWord11 init:)
		(aWord12 init:)
		(aWord13 init:)
		(aWord14 init:)
		(aWord15 init:)
		(aWord16 init:)
		(aWord17 init:)
		(aWord18 init:)
		(aWord19 init:)
		(aWord20 init:)
		(aWord21 init:)
		(rock init:)
		(theTop init:)
		(cloud init:)
		(mountainCap1 init:)
		(mountainCap2 init:)
		(theCar init:)
		(aBird init:)
		(gLongSong2 number: 130 setLoop: -1 play: 10 fade: 127 10 30 0)
		(gCurRoom setScript: rockScript)
	)

	(method (doit)
		(super doit:)
		(if (and global120 (not local0) (not (gCurRoom script:)))
			(= local0 1)
			(self setScript: (ScriptID 0 4)) ; runScript
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (dispose)
		(mySound dispose:)
		(my2Sound dispose:)
		(birdSound dispose:)
		(DisposeScript 964)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 fade: 0 10 30 1)
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
				(= ticks 45)
			)
			(1
				(gGame handsOff:)
				(theView view: 365 setLoop: 0 setCel: 1 posn: 73 173 init:)
				(mySound number: 1044 setLoop: 1 play:)
				(= ticks 25)
			)
			(2
				(gGame handsOff:)
				(theProp view: 365 setLoop: 1 setCel: 1 posn: 164 173 init:)
				(= ticks 43)
			)
			(3
				(theView view: 365 setLoop: 2 setCel: 1 posn: 174 173)
				(= ticks 54)
			)
			(4
				(theProp view: 365 setLoop: 3 setCel: 1 posn: 124 183)
				(= ticks 25)
			)
			(5
				(theView hide:)
				(= ticks 38)
			)
			(6
				(= ticks 4)
			)
			(7
				(theView view: 365 setLoop: 0 setCel: 1 posn: 217 183 show:)
				(= ticks 37)
			)
			(8
				(theProp view: 365 setLoop: 4 setCel: 1 posn: 152 185)
				(= ticks 28)
			)
			(9
				(theView view: 365 setLoop: 5 setCel: 1 posn: 49 195)
				(= ticks 55)
			)
			(10
				(theView view: 365 setLoop: 6 setCel: 1 posn: 150 194)
				(= ticks 55)
			)
			(11
				(= ticks 10)
			)
			(12
				(theProp view: 365 setLoop: 3 setCel: 1 posn: 263 194)
				(= ticks 50)
			)
			(13
				(theView hide: dispose:)
				(= ticks 31)
			)
			(14
				(theProp hide: dispose:)
				(rock setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theCarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theCar view: 335 setLoop: 0 setCel: 0)
				(= ticks 6)
			)
			(1
				(theCar setCycle: CT 5 1 self)
			)
			(2
				(mySound number: 946 setLoop: 1 play:)
				(theCar setCycle: CT 15 1 self)
			)
			(3
				(mySound number: 955 setLoop: -1 play:)
				(theCar
					setLoop: 1
					setCel: 0
					ignoreActors:
					setCycle: CT 6 1 self
				)
			)
			(4
				(mySound number: 956 setLoop: 1 play:)
				(my2Sound number: 957 setLoop: 1 play:)
				(theCar setCycle: CT 15 1 self)
			)
			(5
				(mySound number: 919 setLoop: 1 play:)
				(theCar setLoop: 2 setCel: 0 setCycle: CT 7 1 self)
			)
			(6
				(my2Sound number: 930 setLoop: 1 play:)
				(theCar setCycle: CT 15 1 self)
			)
			(7
				(mySound number: 955 setLoop: -1 play:)
				(theCar setLoop: 3 setCel: 0 setCycle: End self)
			)
			(8
				(mySound stop:)
				(theCar view: 301 setLoop: 0 setCel: 7 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aBirdScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (myBird loop:) 1) (== (myBird cel:) 3))
			(birdSound play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(myBird
					setLoop: 0
					setCel: 1
					init:
					setMotion: MoveTo 271 103 self
				)
			)
			(1
				(= ticks 50)
			)
			(2
				(mySound number: 956 setLoop: 1 play:)
				(myBird setCycle: CT 3 1 self)
			)
			(3
				(= ticks 2)
			)
			(4
				(myBird setCycle: CT 4 1 self)
			)
			(5
				(myBird setCel: 1 setMotion: MoveTo 302 100 self)
			)
			(6
				(= ticks 50)
			)
			(7
				(myBird
					setLoop: 1
					setCel: 0
					posn: 302 64
					moveSpeed: 3
					setCycle: Fwd
					setMotion: MoveTo 64 62 self
				)
			)
			(8
				(mySound number: 946 setLoop: 1 play:)
				(myBird setLoop: 2 setCel: 0 posn: 41 69 setCycle: End self)
			)
			(9
				(mySound number: 988 setLoop: 1 play:)
				(myBird
					setLoop: 4
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 69 60 self
				)
			)
			(10
				(myBird setLoop: 3 setCel: 0 setCycle: Fwd)
				(= ticks 25)
			)
			(11
				(myBird
					setLoop: 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 41 69 self
				)
			)
			(12
				(myBird setLoop: 2 setCel: 0 setCycle: End self)
			)
			(13
				(mySound number: 946 setLoop: 1 play:)
				(myBird setLoop: 2 setCel: 0 setCycle: End self)
			)
			(14
				(mySound number: 988 setLoop: 1 play:)
				(myBird
					setLoop: 4
					setCel: 0
					ignoreActors:
					setCycle: Fwd
					setMotion: MoveTo 69 123 self
				)
			)
			(15
				(myBird setLoop: 3 setCel: 0 setCycle: Fwd)
				(= ticks 50)
			)
			(16
				(myBird setCel: 0 setCycle: End self)
			)
			(17
				(mySound number: 978 setLoop: -1 play:)
				(myBird setLoop: 4 setCel: 0 setCycle: Fwd)
				(= ticks 6)
			)
			(18
				(myBird
					setLoop: 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 9 123 self
				)
			)
			(19
				(mySound stop:)
				(myBird setLoop: 0 setCel: 0 posn: 302 100 dispose:)
				(= cycles 2)
			)
			(20
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aVacumnScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(vacDino init: setCycle: End self)
			)
			(1
				(mySound number: 955 setLoop: 1 play:)
				(vacDino setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(mySound number: 955 setLoop: 1 play:)
				(vacDino setCel: 0 setCycle: End self)
			)
			(3
				(mySound number: 955 setLoop: 1 play:)
				(vacDino setCel: 0 setCycle: End self)
			)
			(4
				(mySound number: 1149 setLoop: 1 play:)
				(vacDino setLoop: 2 setCel: 2 setCycle: CT 3 1 self)
			)
			(5
				(vacDino setCycle: CT 7 1 self)
			)
			(6
				(mySound number: 1159 setLoop: 1 play:)
				(vacDino setCycle: CT 13 1 self)
			)
			(7
				(vacDino setCycle: CT 15 1 self)
			)
			(8
				(vacDino setLoop: 3 setCel: 0 setCycle: CT 2 1 self)
			)
			(9
				(vacDino setCycle: CT 10 1 self)
			)
			(10
				(mySound number: 982 setLoop: 1 play:)
				(vacDino setCycle: CT 14 1 self)
			)
			(11
				(vacDino setLoop: 4 setCel: 0 setCycle: Fwd)
				(= ticks 135)
			)
			(12
				(vacDino setLoop: 5 setCel: 0 setCycle: End self)
			)
			(13
				(vacDino setLoop: 0 setCel: 0 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aPictureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(myPicture init: setCycle: End self)
			)
			(1
				(myPicture setLoop: 1 setCel: 0 setCycle: CT 3 1 self)
			)
			(2
				(mySound number: 987 setLoop: 1 play:)
				(myPicture setCycle: CT 9 1 self)
			)
			(3
				(myPicture setLoop: 1 setCel: 0 setCycle: CT 3 1 self)
			)
			(4
				(mySound number: 987 setLoop: 1 play:)
				(myPicture setCycle: CT 9 1 self)
			)
			(5
				(myPicture setLoop: 1 setCel: 0 setCycle: CT 3 1 self)
			)
			(6
				(mySound number: 987 setLoop: 1 play:)
				(myPicture setCycle: CT 9 1 self)
			)
			(7
				(myPicture setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8
				(= ticks 90)
			)
			(9
				(myPicture view: 326 setLoop: 0 setCel: 0)
				(= ticks 3)
			)
			(10
				(mySound number: 986 setLoop: -1 play:)
				(myPicture setCycle: End self)
			)
			(11
				(myPicture setLoop: 1 setCel: 0 setCycle: End self)
			)
			(12
				(mySound number: 914 setLoop: 1 play:)
				(= ticks 90)
			)
			(13
				(myPicture setLoop: 2 setCel: 0 setCycle: End self)
			)
			(14
				(myPicture view: 325 setLoop: 0 setCel: 0 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mountainCap1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theCar posn: 233 158)
				(= ticks 10)
			)
			(1
				(theCar posn: 242 158)
				(= ticks 10)
			)
			(2
				(theCar posn: 250 158)
				(mySound number: 950 setLoop: 1 play:)
				(mountainCap1
					view: 300
					setLoop: 0
					setCel: 0
					posn: 279 93
					setCycle: End self
				)
			)
			(3
				(mySound number: 977 setLoop: -1 play:)
				(bat1
					init:
					setLoop: 1
					setPri: 10
					setCycle: Fwd
					setMotion:
						DPath
						269
						90
						244
						88
						223
						76
						200
						68
						186
						65
						167
						59
						166
						49
						178
						39
						186
						31
						201
						27
						221
						0
						221
						-20
						self
				)
			)
			(4
				(mySound number: 946 setLoop: 1 play:)
				(my2Sound stop:)
				(bat1 setCycle: 0 setCel: 0 posn: 269 90 hide: dispose:)
				(mountainCap1 setCycle: Beg self)
			)
			(5
				(theCar posn: 242 158)
				(= ticks 10)
			)
			(6
				(theCar posn: 233 158)
				(= ticks 10)
			)
			(7
				(gGame handsOn:)
				(theCar posn: 224 158 stopUpd:)
				(mountainCap1 view: 301 setLoop: 0 setCel: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance mountainCap2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mountainCap2
					view: 330
					setLoop: 1
					setCel: 0
					setPri: 6
					setCycle: CT 1 1 self
				)
			)
			(1
				(mySound number: 1013 setLoop: 1 play:)
				(mountainCap2 setCycle: CT 6 1 self)
			)
			(2
				(mySound number: 976 setLoop: 1 play:)
				(echo
					init:
					setLoop: 2
					moveSpeed: 3
					ignoreActors:
					ignoreControl:
					setCycle: End
					setMotion: MoveTo 166 93
				)
				(mountainCap2 setCycle: CT 11 1)
				(= ticks 50)
			)
			(3
				(echo2
					setCel: 0
					setLoop: 2
					moveSpeed: 4
					ignoreActors:
					ignoreControl:
					init:
					setCycle: End
					setMotion: MoveTo 166 93
				)
				(= ticks 50)
			)
			(4
				(echo3
					setCel: 0
					setLoop: 2
					moveSpeed: 5
					ignoreActors:
					ignoreControl:
					init:
					setCycle: End
					setMotion: MoveTo 166 93
				)
				(= ticks 75)
			)
			(5
				(mySound number: 946 setLoop: 1 play:)
				(echo posn: 82 90 setCel: 0 hide: dispose:)
				(echo2 posn: 82 90 setCel: 0 hide: dispose:)
				(echo3 posn: 82 90 setCel: 0 hide: dispose:)
				(mountainCap2 setLoop: 3 setCel: 0 setCycle: Fwd)
				(= ticks 25)
			)
			(6
				(mySound stop:)
				(mountainCap2 setCycle: 0)
				(= ticks 3)
			)
			(7
				(mountainCap2 setLoop: 0 setCel: 10 setCycle: CT 12 1 self)
			)
			(8
				(mountainCap2 setLoop: 0 setCel: 10 setCycle: CT 15 1 self)
			)
			(9
				(gGame handsOn:)
				(mountainCap2 view: 301 setLoop: 0 setCel: 6 setPri: 6 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance aTigerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(tiger init: setCycle: End self)
			)
			(1
				(tiger setLoop: 1 setCel: 2 setCycle: CT 4 1 self)
			)
			(2
				(mySound number: 1170 setLoop: 1 play:)
				(tiger setCycle: End self)
			)
			(3
				(mySound number: 1171 setLoop: 1 play:)
				(tiger setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(tiger setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(5
				(mySound number: 1170 setLoop: 1 play:)
				(tiger setCycle: End self)
			)
			(6
				(mySound number: 1171 setLoop: 1 play:)
				(tiger setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(tiger setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(8
				(mySound number: 1170 setLoop: 1 play:)
				(tiger setCycle: End self)
			)
			(9
				(mySound number: 1171 setLoop: 1 play:)
				(tiger setLoop: 2 setCel: 0 setCycle: End self)
			)
			(10
				(mySound stop:)
				(= ticks 18)
			)
			(11
				(tiger setLoop: 3 setCel: 0 setCycle: End self)
			)
			(12
				(tiger setLoop: 0 setCel: 0 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theTopScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theTop
					view: 355
					setLoop: 0
					setCel: 0
					posn: 161 88
					setCycle: CT 1 1 self
				)
			)
			(1
				(mySound number: 1013 setLoop: 1 play:)
				(theTop setCycle: End self)
			)
			(2
				(= ticks 6)
			)
			(3
				(mySound number: 911 setLoop: 1 play:)
				(prop1 init: setCycle: End)
				(= ticks 12)
			)
			(4
				(theTop hide:)
				(mySound number: 911 setLoop: 1 play:)
				(prop2 init: setCycle: End)
				(= ticks 12)
			)
			(5
				(mySound number: 911 setLoop: 1 play:)
				(prop3 init: setCycle: End)
				(= ticks 12)
			)
			(6
				(prop3 hide:)
				(mySound number: 911 setLoop: 1 play:)
				(prop4 init: setCycle: End)
				(= ticks 12)
			)
			(7
				(theTop hide:)
				(mySound number: 911 setLoop: 1 play:)
				(prop1 init: setCycle: End)
				(prop4 hide:)
				(= ticks 12)
			)
			(8
				(mySound number: 911 setLoop: 1 play:)
				(prop6 init: setCycle: End)
				(= ticks 12)
			)
			(9
				(mySound number: 911 setLoop: 1 play:)
				(prop5 init: setCycle: End)
				(= ticks 12)
			)
			(10
				(mySound number: 911 setLoop: 1 play:)
				(prop7 init: setCycle: End)
				(= ticks 12)
			)
			(11
				(mySound number: 911 setLoop: 1 play:)
				(prop7 hide:)
				(prop8 init: setCycle: End)
				(= ticks 12)
			)
			(12
				(mySound number: 911 setLoop: 1 play:)
				(prop8 hide:)
				(prop2 setCel: 0 setCycle: End)
				(= ticks 12)
			)
			(13
				(mySound number: 911 setLoop: 1 play:)
				(prop1 setCel: 0 setCycle: End)
				(= ticks 12)
			)
			(14
				(mySound number: 911 setLoop: 1 play:)
				(prop4 setCel: 0 show: setCycle: End)
				(= ticks 12)
			)
			(15
				(mySound number: 911 setLoop: 1 play:)
				(prop3 setCel: 0 show: setCycle: End)
				(prop4 hide:)
				(= ticks 12)
			)
			(16
				(mySound number: 911 setLoop: 1 play:)
				(prop3 hide:)
				(prop6 setCel: 0 setCycle: End)
				(= ticks 12)
			)
			(17
				(mySound number: 911 setLoop: 1 play:)
				(prop5 setCel: 0 setCycle: End)
				(= ticks 12)
			)
			(18
				(mySound number: 911 setLoop: 1 play:)
				(prop7 setCel: 0 show: setCycle: End)
				(= ticks 12)
			)
			(19
				(prop7 hide:)
				(mySound number: 911 setLoop: 1 play:)
				(prop8 setCel: 0 show: setCycle: End)
				(= ticks 12)
			)
			(20
				(mySound number: 911 setLoop: 1 play:)
				(prop8 hide:)
				(prop1 setCel: 0 hide: dispose:)
				(prop2 setCel: 0 hide: dispose:)
				(prop3 setCel: 0 hide: dispose:)
				(prop4 setCel: 0 hide: dispose:)
				(prop5 setCel: 0 hide: dispose:)
				(prop6 setCel: 0 hide: dispose:)
				(prop7 setCel: 0 hide: dispose:)
				(prop8 setCel: 0 hide: dispose:)
				(= ticks 6)
			)
			(21
				(theTop show: setCycle: Beg self)
			)
			(22
				(mySound number: 912 setLoop: 1 play: self)
			)
			(23
				(theTop view: 301 setLoop: 0 setCel: 11 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance anEggScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theEgg init: setCycle: End self)
			)
			(1
				(theEgg setLoop: 1 setCel: 0 posn: 279 160 setCycle: End self)
			)
			(2
				(theEgg setCel: 0 setCycle: End self)
			)
			(3
				(theEgg setCel: 0 setCycle: End self)
			)
			(4
				(theEgg setLoop: 2 setCel: 0)
				(my2Sound number: 984 setLoop: -1 play:)
				(= ticks 6)
			)
			(5
				(theEgg setCycle: CT 6 1 self)
			)
			(6
				(theEgg setCycle: CT 2 -1 self)
			)
			(7
				(theEgg setCycle: CT 6 1 self)
			)
			(8
				(theEgg setCycle: CT 2 -1 self)
			)
			(9
				(theEgg setCycle: CT 6 1 self)
			)
			(10
				(my2Sound stop:)
				(= ticks 2)
			)
			(11
				(mySound number: 985 setLoop: 1 play:)
				(theEgg setCycle: CT 8 1 self)
			)
			(12
				(mySound number: 977 setLoop: 1 play:)
				(theEgg setCycle: CT 10 1 self)
			)
			(13
				(= ticks 100)
			)
			(14
				(mySound number: 984 setLoop: -1 play:)
				(theEgg setLoop: 3 setCel: 0 setCycle: CT 4 1 self)
			)
			(15
				(theEgg setCycle: CT 0 -1 self)
			)
			(16
				(theEgg setCycle: CT 4 1 self)
			)
			(17
				(theEgg setCycle: CT 0 -1 self)
			)
			(18
				(theEgg setCycle: CT 4 1 self)
			)
			(19
				(mySound number: 985 setLoop: 1 play:)
				(theEgg setCycle: CT 6 1 self)
			)
			(20
				(mySound number: 977 setLoop: 1 play:)
				(theEgg setCycle: CT 8 1 self)
			)
			(21
				(= ticks 100)
			)
			(22
				(mySound number: 984 setLoop: -1 play:)
				(theEgg setLoop: 4 setCel: 0 setCycle: CT 4 1 self)
			)
			(23
				(theEgg setCycle: CT 0 -1 self)
			)
			(24
				(theEgg setCycle: CT 4 1 self)
			)
			(25
				(theEgg setCycle: CT 0 -1 self)
			)
			(26
				(theEgg setCycle: CT 4 1 self)
			)
			(27
				(mySound number: 985 setLoop: 1 play:)
				(theEgg setCycle: CT 6 1 self)
			)
			(28
				(mySound number: 920 setLoop: 1 play:)
				(theEgg setCel: 7)
				(= ticks 3)
			)
			(29
				(my2Sound number: 986 setLoop: 1 play:)
				(theEgg setCycle: CT 12 1 self)
			)
			(30
				(theEgg setLoop: 5 setCel: 0 setCycle: CT 3 1 self)
			)
			(31
				(= ticks 100)
			)
			(32
				(theEgg setLoop: 6 setCel: 0 posn: 273 140 setCycle: End self)
			)
			(33
				(theEgg setLoop: 0 setCel: 0 posn: 274 139 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aDinerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(diningDino init: setCycle: CT 6 1 self)
			)
			(1
				(= ticks 50)
			)
			(2
				(mySound number: 1027 setLoop: 1 play:)
				(dTongue init: setPri: 15 ignoreActors: setCycle: CT 4 1 self)
			)
			(3
				(mySound number: 1027 setLoop: 1 play:)
				(dTongue setCycle: CT 9 1 self)
			)
			(4
				(dTongue setCel: 0)
				(= ticks 6)
			)
			(5
				(dTongue hide: dispose:)
				(= ticks 50)
			)
			(6
				(mySound number: 911 setLoop: 1 play:)
				(diningDino setCycle: CT 15 1 self)
			)
			(7
				(mySound number: 983 setLoop: 1 play:)
				(diningDino setLoop: 1 setCel: 0 setCycle: End self)
			)
			(8
				(diningDino setLoop: 2 setCel: 0 setCycle: End self)
			)
			(9
				(diningDino setLoop: 3 setCel: 0 setCycle: End self)
			)
			(10
				(diningDino setLoop: 0 setCel: 0 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aCaveManScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(caveMan init: setCycle: End self)
			)
			(1
				(mySound number: 980 setLoop: -1 play:)
				(caveMan setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 90)
			)
			(2
				(mySound stop:)
				(caveMan setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(= ticks 20)
			)
			(4
				(mySound number: 980 setLoop: -1 play:)
				(caveMan setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 90)
			)
			(5
				(mySound stop:)
				(caveMan setLoop: 2 setCel: 0 setCycle: End self)
			)
			(6
				(= ticks 20)
			)
			(7
				(mySound number: 980 setLoop: -1 play:)
				(caveMan setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 45)
			)
			(8
				(mySound number: 944 setLoop: 1 play:)
				(caveMan setLoop: 3 setCel: 0 setCycle: End self)
			)
			(9
				(caveMan setLoop: 4 setCel: 0)
				(= ticks 50)
			)
			(10
				(caveMan setCycle: CT 1 1 self)
			)
			(11
				(mySound number: 956 setLoop: 1 play:)
				(caveMan setCycle: CT 4 1 self)
			)
			(12
				(= ticks 50)
			)
			(13
				(caveMan setLoop: 5 setCel: 0 setCycle: End self)
			)
			(14
				(caveMan setLoop: 0 setCel: 0 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cloudScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(PalVary pvINIT 310 1)
				(= ticks 60)
			)
			(1
				(mySound number: 979 setLoop: 1 play:)
				(cloud
					view: 305
					setLoop: 0
					setCel: 0
					setPri: 8
					setCycle: End self
				)
			)
			(2
				(cloud setLoop: 1 setCel: 0 setCycle: CT 5 1 self)
				(Load rsSOUND 926)
			)
			(3
				(mySound number: 926 play: setLoop: 1)
				(cloud setCycle: CT 7 1 self)
			)
			(4
				(cloud setCycle: CT 8 1 self)
			)
			(5
				(cloud setLoop: 1 setCel: 5 setCycle: CT 7 1 self)
				(mySound number: 926 setLoop: 1 play:)
			)
			(6
				(cloud setCycle: CT 8 1 self)
			)
			(7
				(mySound number: 926 setLoop: 1 play:)
				(cloud setCycle: CT 7 1 self)
			)
			(8
				(mySound number: 926 setLoop: 1 play:)
				(cloud setCycle: CT 5 1 self)
			)
			(9
				(cloud setLoop: 0 setCel: 0)
				(PalVary pvREVERSE 1)
				(= ticks 60)
			)
			(10
				(cloud view: 301 setLoop: 0 setCel: 1 setPri: 6 stopUpd:)
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 164
		nsLeft 26
		nsBottom 171
		nsRight 56
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1123 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 0 posn: 41 172 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 164
		nsLeft 63
		nsBottom 171
		nsRight 94
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1069 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 1 posn: 78 172 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 164
		nsLeft 97
		nsBottom 171
		nsRight 113
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1070 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 2 posn: 105 172 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 164
		nsLeft 118
		nsBottom 171
		nsRight 138
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 3 posn: 127 172 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 164
		nsLeft 141
		nsBottom 171
		nsRight 201
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1071 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 4 posn: 170 172 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 164
		nsLeft 203
		nsBottom 171
		nsRight 228
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1055 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 5 posn: 216 172 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 164
		nsLeft 231
		nsBottom 171
		nsRight 258
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1123 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 6 posn: 244 172 init:)
	)
)

(instance aWord7 of InterFeature
	(properties
		nsTop 164
		nsLeft 264
		nsBottom 171
		nsRight 295
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1069 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 1 posn: 280 172 init:)
	)
)

(instance aWord8 of InterFeature
	(properties
		nsTop 176
		nsLeft 38
		nsBottom 182
		nsRight 76
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1072 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 7 posn: 57 183 init:)
	)
)

(instance aWord9 of InterFeature
	(properties
		nsTop 176
		nsLeft 78
		nsBottom 182
		nsRight 98
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 3 posn: 88 183 init:)
	)
)

(instance aWord10 of InterFeature
	(properties
		nsTop 176
		nsLeft 102
		nsBottom 182
		nsRight 162
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1071 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 4 posn: 131 183 init:)
	)
)

(instance aWord11 of InterFeature
	(properties
		nsTop 176
		nsLeft 169
		nsBottom 182
		nsRight 201
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1123 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 0 posn: 185 183 init:)
	)
)

(instance aWord12 of InterFeature
	(properties
		nsTop 176
		nsLeft 204
		nsBottom 182
		nsRight 237
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1069 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 1 posn: 222 183 init:)
	)
)

(instance aWord13 of InterFeature
	(properties
		nsTop 176
		nsLeft 240
		nsBottom 182
		nsRight 258
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1070 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 2 posn: 249 183 init:)
	)
)

(instance aWord14 of InterFeature
	(properties
		nsTop 176
		nsLeft 256
		nsBottom 182
		nsRight 282
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 3 posn: 271 183 init:)
	)
)

(instance aWord15 of InterFeature
	(properties
		nsTop 187
		nsLeft 19
		nsBottom 200
		nsRight 78
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1071 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 4 posn: 50 194 init:)
	)
)

(instance aWord16 of InterFeature
	(properties
		nsTop 187
		nsLeft 85
		nsBottom 200
		nsRight 106
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1055 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 5 posn: 96 194 init:)
	)
)

(instance aWord17 of InterFeature
	(properties
		nsTop 187
		nsLeft 110
		nsBottom 200
		nsRight 139
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1123 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 6 posn: 124 194 init:)
	)
)

(instance aWord18 of InterFeature
	(properties
		nsTop 187
		nsLeft 142
		nsBottom 200
		nsRight 173
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1069 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 1 posn: 160 194 init:)
	)
)

(instance aWord19 of InterFeature
	(properties
		nsTop 187
		nsLeft 179
		nsBottom 200
		nsRight 213
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1072 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 7 posn: 196 194 init:)
	)
)

(instance aWord20 of InterFeature
	(properties
		nsTop 187
		nsLeft 217
		nsBottom 200
		nsRight 237
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 3 posn: 227 194 init:)
	)
)

(instance aWord21 of InterFeature
	(properties
		nsTop 187
		nsLeft 240
		nsBottom 200
		nsRight 299
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1071 setLoop: 1 play: rm3)
		(theView view: 370 setLoop: 4 posn: 270 194 init:)
	)
)

(instance anEgg of InterFeature
	(properties
		nsTop 124
		nsLeft 246
		nsBottom 158
		nsRight 299
	)

	(method (doVerb)
		(gCurRoom setScript: anEggScript)
	)
)

(instance aPicture of InterFeature
	(properties
		nsTop 100
		nsLeft 129
		nsBottom 125
		nsRight 200
	)

	(method (doVerb)
		(gCurRoom setScript: aPictureScript)
	)
)

(instance aCaveMan of InterFeature
	(properties
		nsTop 106
		nsLeft 28
		nsBottom 129
		nsRight 82
	)

	(method (doVerb)
		(gCurRoom setScript: aCaveManScript)
	)
)

(instance aDiner of InterFeature
	(properties
		nsTop 129
		nsLeft 49
		nsBottom 156
		nsRight 77
	)

	(method (doVerb)
		(gCurRoom setScript: aDinerScript)
	)
)

(instance aTiger of InterFeature
	(properties
		nsTop 125
		nsLeft 119
		nsBottom 147
		nsRight 201
	)

	(method (doVerb)
		(gCurRoom setScript: aTigerScript)
	)
)

(instance aVacumn of InterFeature
	(properties
		nsTop 96
		nsLeft 250
		nsBottom 124
		nsRight 297
	)

	(method (doVerb)
		(gCurRoom setScript: aVacumnScript)
	)
)

(instance aBird of InterFeature
	(properties
		nsLeft 33
		nsBottom 71
		nsRight 288
	)

	(method (doVerb)
		(gCurRoom setScript: aBirdScript)
	)
)

(instance rock of InterView
	(properties
		x 19
		y 172
		view 360
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
		priority 14
		signal 16
	)
)

(instance theProp of Prop
	(properties
		cel 1
		priority 14
		signal 16
	)
)

(instance cloud of InterProp
	(properties
		x 99
		y 72
		view 301
		cel 1
		priority 6
		signal 16401
	)

	(method (doVerb)
		(gCurRoom setScript: cloudScript)
	)
)

(instance theTop of InterProp
	(properties
		x 161
		y 88
		view 301
		cel 11
		signal 4097
	)

	(method (doVerb)
		(gCurRoom setScript: theTopScript)
	)
)

(instance vacDino of Prop
	(properties
		x 277
		y 102
		view 350
		priority 10
		signal 17
	)
)

(instance tiger of Prop
	(properties
		x 158
		y 160
		view 345
		signal 1
	)
)

(instance caveMan of Prop
	(properties
		x 49
		y 100
		view 310
		priority 10
		signal 17
	)
)

(instance myPicture of Prop
	(properties
		x 161
		y 162
		view 325
		signal 1
	)
)

(instance diningDino of Prop
	(properties
		x 51
		y 164
		view 315
		signal 1
	)
)

(instance dTongue of Prop
	(properties
		x 52
		y 131
		view 315
		loop 4
	)
)

(instance theEgg of Prop
	(properties
		x 274
		y 139
		view 320
		signal 1
	)
)

(instance prop1 of Prop
	(properties
		x 69
		y 164
		view 355
		loop 1
		priority 8
		signal 17
	)
)

(instance prop2 of Prop
	(properties
		x 261
		y 165
		view 355
		loop 2
		priority 8
		signal 17
	)
)

(instance prop3 of Prop
	(properties
		x 39
		y 133
		view 355
		loop 3
		priority 8
		signal 17
	)
)

(instance prop4 of Prop
	(properties
		x 284
		y 133
		view 355
		loop 4
		priority 8
		signal 17
	)
)

(instance prop5 of Prop
	(properties
		x 47
		y 162
		view 355
		loop 1
		priority 8
		signal 17
	)
)

(instance prop6 of Prop
	(properties
		x 254
		y 162
		view 355
		loop 2
		priority 8
		signal 17
	)
)

(instance prop7 of Prop
	(properties
		x 23
		y 131
		view 355
		loop 3
		priority 8
		signal 17
	)
)

(instance prop8 of Prop
	(properties
		x 302
		y 131
		view 355
		loop 4
		priority 8
		signal 17
	)
)

(instance mountainCap1 of InterProp
	(properties
		x 278
		y 94
		view 301
		signal 20481
	)

	(method (doVerb)
		(gCurRoom setScript: mountainCap1Script)
	)
)

(instance mountainCap2 of InterProp
	(properties
		x 50
		y 109
		view 301
		cel 6
		signal 20481
	)

	(method (doVerb)
		(gCurRoom setScript: mountainCap2Script)
	)
)

(instance echo of Actor
	(properties
		x 82
		y 90
		view 330
		loop 1
		signal 16385
	)
)

(instance echo2 of Actor
	(properties
		x 82
		y 90
		view 330
		loop 1
		signal 16385
	)
)

(instance echo3 of Actor
	(properties
		x 82
		y 90
		view 330
		loop 1
		signal 16385
	)
)

(instance theCar of InterActor
	(properties
		x 224
		y 158
		view 301
		cel 7
		signal 20481
	)

	(method (doVerb)
		(gCurRoom setScript: theCarScript)
	)
)

(instance myBird of Actor
	(properties
		x 302
		y 100
		view 340
		priority 11
		signal 16400
	)
)

(instance bat1 of Actor
	(properties
		x 269
		y 90
		view 300
		loop 1
		cel 1
		signal 24576
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

(instance birdSound of Sound
	(properties
		number 978
	)
)

