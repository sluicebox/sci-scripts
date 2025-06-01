;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use CycleBet)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm5 0
)

(local
	local0
	local1
)

(instance rm5 of Rm
	(properties
		picture 500
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(super init:)
		(gGame handsOn:)
		(rock init:)
		(yipeeBush init:)
		(whoopieBush init:)
		(sneezer init: setOnMeCheck: 1 2048)
		(wingedDino init: setPri: 5 stopUpd:)
		(slater init:)
		(charlie init:)
		(charlieEyes init:)
		(rocky init:)
		(hive init:)
		(theFlower init:)
		(bushGuy init:)
		(drummer init:)
		(hula init:)
		(snake init:)
		(vineBugA init:)
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
		(gLongSong2 number: 150 setLoop: -1 play: 10 fade: 127 10 30 0)
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
				(= ticks 40)
			)
			(1
				(gGame handsOff:)
				(rock setCel: 1)
				(theView view: 580 setLoop: 0 setCel: 1 posn: 100 175 init:)
				(= ticks 25)
			)
			(2
				(mySound number: 1046 setLoop: 1 play:)
				(= ticks 30)
			)
			(3
				(gGame handsOff:)
				(theProp view: 580 setLoop: 1 setCel: 1 posn: 213 175 init:)
				(= ticks 50)
			)
			(4
				(theView hide:)
				(= ticks 39)
			)
			(5
				(theView view: 580 setLoop: 2 setCel: 1 posn: 70 188 show:)
				(= ticks 41)
			)
			(6
				(theProp view: 580 setLoop: 3 setCel: 1 posn: 146 188)
				(= ticks 90)
			)
			(7
				(theView hide:)
				(= ticks 5)
			)
			(8
				(theView view: 580 setLoop: 4 setCel: 1 posn: 208 188 show:)
				(= ticks 29)
			)
			(9
				(oddView view: 580 setLoop: 5 setCel: 1 posn: 261 188 init:)
				(= ticks 24)
			)
			(10
				(theProp hide: dispose:)
				(= ticks 17)
			)
			(11
				(theView hide: dispose:)
				(= ticks 14)
			)
			(12
				(oddView hide: dispose:)
				(rock setCel: 0 stopUpd:)
				(= ticks 60)
			)
			(13
				(if (not local1)
					(gCurRoom setScript: slaterScript)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance snakeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(snake setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 928 setLoop: 1 play:)
				(snake setCycle: End self)
			)
			(2
				(= ticks 50)
			)
			(3
				(mySound number: 904 play: setLoop: 1)
				(snake setLoop: 1 setCel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(4
				(mySound number: 904 play: setLoop: 1)
				(snake setCel: 0 setCycle: End self)
			)
			(5
				(= ticks 25)
			)
			(6
				(mySound number: 926 play: setLoop: 1)
				(snake setLoop: 2 setCel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(7
				(mySound play:)
				(snake setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8
				(mySound number: 928 play: setLoop: 1)
				(snake setLoop: 0 setCel: 8 setCycle: Beg self)
			)
			(9
				(mySound stop:)
				(snake stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rockyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rocky setCycle: End self)
			)
			(1
				(mySound number: 907 setLoop: -1 play:)
				(my2Sound number: 908 setLoop: -1 play:)
				(rocky setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 120)
			)
			(2
				(mySound stop:)
				(my2Sound stop:)
				(= ticks 1)
			)
			(3
				(mySound number: 988 setLoop: 1 play: self)
				(rocky setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(= ticks 15)
			)
			(5
				(rocky setLoop: 3 setCel: 0 setCycle: End self)
			)
			(6
				(rocky setLoop: 0 setCel: 1)
				(= cycles 2)
			)
			(7
				(rocky stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aSkaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(skater init: setPri: 10 cycleSpeed: 8 setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 933 setLoop: 1 play:)
				(skater setCycle: End self)
			)
			(2
				(skater setLoop: 1 setCel: 0 setCycle: CT 8 1 self)
			)
			(3
				(skater setPri: 7 setCycle: CT 9 1 self)
			)
			(4
				(skater setLoop: 0 setCel: 0 stopUpd:)
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance vineBugScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(vineBug setLoop: 0 setCel: 0 init: setCycle: CT 6 1 self)
			)
			(1
				(mySound number: 1027 setLoop: 1 play:)
				(vineBug setCycle: CT 11 1 self)
			)
			(2
				(vineBugA hide:)
				(vineBug setCycle: CT 15 1 self)
			)
			(3
				(mySound number: 937 setLoop: 1 play:)
				(vineBug setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(mySound number: 937 play: setLoop: 1)
				(vineBug setLoop: 2 setCel: 0 setPri: 8 setCycle: End self)
			)
			(5
				(vineBugA show: stopUpd:)
				(vineBug setLoop: 3 setCel: 0 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theFlowerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theFlower
					view: 515
					setLoop: 0
					setCel: 0
					ignoreActors:
					setCycle: CT 3 1 self
				)
			)
			(1
				(mySound number: 903 setLoop: -1 play:)
				(theFlower setCycle: CT 15 1 self)
			)
			(2
				(theFlower setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(theFlower setLoop: 2 setCel: 0 setCycle: CT 3 1 self)
			)
			(4
				(my2Sound number: 908 setLoop: 1 play:)
				(theFlower setCycle: CT 5 1 self)
			)
			(5
				(mySound number: 907 setLoop: 1 play:)
				(theFlower setCycle: End self)
			)
			(6
				(theFlower setLoop: 3 setCel: 0 setCycle: CT 4 1 self)
			)
			(7
				(mySound number: 988 setLoop: 1 play:)
				(theFlower setCycle: CT 12 1 self)
			)
			(8
				(theFlower view: 591 setLoop: 0 setCel: 0 stopUpd:)
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
				(my2Sound number: 903 loop: 1 play:)
				(Load rsVIEW 500)
				(charlie view: 505 setLoop: 0 setCel: 0)
				(slater
					view: 500
					setLoop: 0
					setCel: 0
					setPri: 12
					cycleSpeed: 6
					setCycle: CT 6 1 self
				)
			)
			(1
				(hive dispose:)
				(charlieEyes cycleSpeed: 0 setCycle: End self)
				(charlieMouth init:)
			)
			(2
				(charlieEyes setCycle: Beg)
				(mySound number: 960 setLoop: 1 play:)
				(charlieEyes dispose:)
				(charlieMouth dispose:)
				(charlie setLoop: 3 setCel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(3
				(charlie dispose:)
				(slater setCycle: CycleBet 7 8 2 self)
			)
			(4
				(slater setCycle: CT 9 1 self)
			)
			(5
				(branch init:)
				(mySound number: 904 setLoop: 1 play:)
				(slater
					view: 500
					setLoop: 1
					setCel: 0
					posn: 171 99
					setCycle: End self
				)
			)
			(6
				(mySound number: 945 setLoop: 1 play:)
				(slater
					view: 501
					setLoop: 0
					setCel: 0
					cycleSpeed: (+ (slater cycleSpeed:) 1)
					setCycle: End self
				)
			)
			(7
				(slater
					setLoop: 1
					setCel: 0
					posn: 193 97
					cycleSpeed: (- (slater cycleSpeed:) 1)
					setCycle: CT 1 1 self
				)
			)
			(8
				(slater setCycle: End self)
				(my3Sound number: 915 setLoop: 1 play:)
			)
			(9
				(my2Sound stop:)
				(= ticks 180)
			)
			(10
				(my2Sound number: 903 setLoop: -1 play:)
				(slater
					view: 503
					setLoop: 0
					setCel: 0
					posn: 193 97
					setCycle: CT 1 1 self
				)
			)
			(11
				(mySound number: 919 setLoop: 1 play:)
				(slater setCycle: End self)
			)
			(12
				(mySound number: 1166 setLoop: 1 play:)
				(slater
					view: 503
					setLoop: 1
					setCel: 0
					posn: 192 98
					setCycle: End self
				)
			)
			(13
				(slater setCycle: Beg self)
			)
			(14
				(mySound play:)
				(slater setLoop: 2 setCel: 0 posn: 132 98 setCycle: End self)
			)
			(15
				(slater
					view: 502
					setLoop: 0
					setCel: 0
					posn: 167 106
					setCycle: CT 2 1 self
				)
				(my2Sound number: 903 setLoop: -1 play:)
			)
			(16
				(slater posn: 170 145 setCycle: End self)
				(mySound number: 960 setLoop: -1 play:)
			)
			(17
				(slater hide:)
				(= ticks 60)
			)
			(18
				(= local1 1)
				(mySound stop:)
				(my2Sound stop:)
				(aRock init:)
				(winged init:)
				(aTiger init:)
				(aVine init:)
				(aHole init:)
				(aSkater init:)
				(slater dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wingedDinoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 918 setLoop: -1 play:)
				(wingedDino
					view: 510
					setLoop: 0
					setCel: 0
					cycleSpeed: 0
					moveSpeed: 0
					setPri: 5
				)
				(= cycles 5)
			)
			(1
				(wingedDino setCycle: Fwd setMotion: MoveTo 230 63 self)
			)
			(2
				(= ticks 50)
			)
			(3
				(wingedDino setLoop: 0 setCel: 7 posn: 230 120 dispose:)
				(wings
					init:
					setPri: 5
					cycleSpeed: 0
					moveSpeed: 0
					ignoreActors:
					setCycle: Fwd
				)
				(wingedClothes
					init:
					ignoreActors:
					ignoreHorizon:
					setPri: 5
					setCycle: CT 1 1 self
				)
				(my2Sound number: 904 setLoop: 1 play:)
			)
			(4
				(wingedClothes setCycle: CT 2 1 self)
			)
			(5
				(= ticks 50)
			)
			(6
				(my2Sound number: 922 setLoop: 1 play:)
				(wingedClothes setPri: 5 setCycle: CT 7 1 self)
			)
			(7
				(mySound play: loop: -1)
				(= ticks 50)
			)
			(8
				(wingedClothes setCycle: CT 8 1)
				(= ticks 25)
			)
			(9
				(wingedClothes setCycle: CT 12 1 self)
			)
			(10
				(= ticks 25)
			)
			(11
				(my2Sound number: 905 setLoop: 1 play:)
				(wingedClothes setCycle: CT 13 1 self)
			)
			(12
				(= ticks 25)
			)
			(13
				(wingedClothes setCel: 14)
				(= ticks 6)
			)
			(14
				(wings setPri: 5 setCycle: Fwd posn: 231 75)
				(wingedClothes cycleSpeed: 0 moveSpeed: 0 posn: 230 75)
				(= ticks 4)
			)
			(15
				(wings setPri: 5 setCycle: Fwd posn: 231 90)
				(wingedClothes cycleSpeed: 0 moveSpeed: 0 posn: 230 90)
				(= ticks 4)
			)
			(16
				(wings setPri: 5 setCycle: Fwd posn: 231 105)
				(wingedClothes cycleSpeed: 0 moveSpeed: 0 posn: 230 105)
				(= ticks 1)
			)
			(17
				(wings hide: setPri: 5 setCel: 0 posn: 231 62)
				(wingedClothes hide: setCel: 0 posn: 230 62)
				(wingedDino view: 591 setCel: 7 posn: 230 120 init: stopUpd:)
				(vineBugA forceUpd: stopUpd:)
				(whoopieDino forceUpd: stopUpd:)
				(wingedClothes dispose:)
				(wings dispose:)
				(= cycles 16)
			)
			(18
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance drummerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 955 setLoop: 1 play:)
				(drummer view: 530 setLoop: 1 setCel: 0 setPri: 6)
				(= ticks 6)
			)
			(1
				(drummer setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(drummer setLoop: 2 setCel: 0 setCycle: CT 5 1 self)
			)
			(3
				(mySound number: 959 setLoop: 1 play:)
				(drummer setCycle: End self)
			)
			(4
				(drummer setCycle: CT 7 -1 self)
			)
			(5
				(drummer setCycle: End self)
			)
			(6
				(drummer setCycle: CT 7 -1 self)
			)
			(7
				(drummer setLoop: 3 setCel: 0 setCycle: End self)
			)
			(8
				(mySound number: 955 setLoop: 1 play:)
				(drummer setLoop: 1 setCel: 2 setCycle: Beg self)
			)
			(9
				(drummer
					view: 591
					setLoop: 0
					setCel: 3
					posn: 48 100
					setPri: 6
					stopUpd:
				)
				(= ticks 25)
			)
			(10
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bushGuyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bushGuy view: 520 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 928 setLoop: 1 play:)
				(bushGuy setCycle: End self)
			)
			(2
				(bushGuy setLoop: 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(3
				(mySound number: 927 setLoop: 1 play:)
				(bushGuy setCycle: End self)
			)
			(4
				(bushGuy
					setLoop: 0
					setCel: (bushGuy lastCel:)
					setCycle: CT 10 -1 self
				)
			)
			(5
				(bushGuy setCycle: Beg self)
				(mySound number: 928 setLoop: 1 play:)
			)
			(6
				(mySound stop:)
				(gGame handsOn:)
				(bushGuy view: 591 setLoop: 0 setCel: 4 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance tigerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 945 setLoop: 1 play:)
				(tiger init: setPri: 7 cycleSpeed: 8 setCycle: End self)
			)
			(1
				(= ticks 25)
			)
			(2
				(tiger setLoop: 1 setCel: 0)
				(tigerEyes cycleSpeed: 8 init:)
				(tigerEyes setCycle: CT 2 1 self)
			)
			(3
				(= ticks 25)
			)
			(4
				(tigerEyes setCycle: CT 6 1 self)
			)
			(5
				(= ticks 25)
			)
			(6
				(tigerEyes setCycle: CT 12 1 self)
			)
			(7
				(= ticks 25)
			)
			(8
				(tigerEyes setCycle: End self)
			)
			(9
				(tigerEyes setCel: 0)
				(= ticks 50)
			)
			(10
				(mySound number: 936 setLoop: 1 play: self)
				(tigerEyes dispose:)
				(tiger setLoop: 2 setCel: 0 setCycle: CT 4 1 self)
			)
			(11)
			(12
				(my2Sound number: 945 setLoop: 1 play:)
				(tiger setCycle: End self)
			)
			(13
				(tiger setLoop: 3 setCel: 0 setCycle: CT 1 1 self)
				(= ticks 75)
			)
			(14)
			(15
				(tiger setCycle: CT 5 1 self)
			)
			(16
				(my2Sound number: 957 setLoop: 1 play: self)
			)
			(17
				(= ticks 50)
			)
			(18
				(my2Sound number: 920 setLoop: 1 play:)
				(tiger setCycle: End self)
			)
			(19
				(tiger view: 536 setLoop: 0 setCel: 0)
				(= ticks 75)
			)
			(20
				(tiger setCycle: End self)
				(mySound number: 1006 setLoop: 1 play:)
			)
			(21
				(my2Sound number: 986 setLoop: 1 play:)
				(tiger view: 535 setLoop: 0 setCel: 0 dispose:)
				(= ticks 3)
			)
			(22
				(mySound dispose:)
				(= cycles 2)
			)
			(23
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bubbleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 934 setLoop: 1 play:)
				(bubbles posn: 253 67 init: setCycle: CT 6 1 self)
			)
			(1
				(mySound stop:)
				(bubbles setCycle: End self)
			)
			(2
				(bubbles setLoop: 1 setCel: 0 posn: 256 70 setCycle: End self)
			)
			(3
				(bubbles setLoop: 2 setCel: 0 posn: 261 71 setCycle: Fwd)
				(mySound number: 932 setLoop: 1 play: self)
			)
			(4
				(mySound number: 932 setLoop: 1 play: self)
			)
			(5
				(head init:)
				(= ticks 5)
			)
			(6
				(bubbles hide:)
				(head dispose:)
				(mySound number: 1152 setLoop: 1 play:)
				(pop init: setCycle: CT 4 1 self)
			)
			(7
				(pop posn: 248 74 setCycle: CT 6 1 self)
			)
			(8
				(mySound number: 915 setLoop: 1 play:)
				(pop setCel: 0 dispose:)
				(bubbles setLoop: 0 setCel: 0 posn: 253 67 show: dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hulaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 1151 setLoop: 1 play:)
				(hula setLoop: 0 setCel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(1
				(hula setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(hula setCel: 0 setCycle: End self)
			)
			(3
				(hula setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(hula setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(hula setCel: 0 setCycle: End self)
			)
			(6
				(hula setCel: 0 setCycle: End self)
			)
			(7
				(hula setLoop: 4 setCel: 0 setCycle: End self)
			)
			(8
				(hula setLoop: 0 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance whoopie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if global143
					(my2Sound number: 1172 loop: 1 play:)
				)
				(mySound number: 938 loop: 1 play:)
				(whoopieDino init: setPri: 0 setCycle: End self)
			)
			(1
				(whoopieDino dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance yipee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if global143
					(my2Sound number: 1172 loop: 1 play:)
				)
				(mySound number: 940 loop: 1 play:)
				(yipeeDino setCel: 0 init: setCycle: End self)
			)
			(1
				(yipeeDino dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 167
		nsLeft 54
		nsBottom 174
		nsRight 98
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1056 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 0 posn: 74 175 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 167
		nsLeft 106
		nsBottom 174
		nsRight 151
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1056 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 1 posn: 128 175 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 167
		nsLeft 157
		nsBottom 174
		nsRight 179
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1148 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 2 posn: 168 175 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 167
		nsLeft 182
		nsBottom 174
		nsRight 205
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1076 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 3 posn: 192 176 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 167
		nsLeft 207
		nsBottom 174
		nsRight 233
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1077 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 4 posn: 220 176 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 167
		nsLeft 237
		nsBottom 174
		nsRight 264
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1078 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 5 posn: 253 176 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 181
		nsLeft 37
		nsBottom 187
		nsRight 63
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1079 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 6 posn: 49 188 init:)
	)
)

(instance aWord7 of InterFeature
	(properties
		nsTop 181
		nsLeft 65
		nsBottom 187
		nsRight 104
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1054 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 7 posn: 85 188 init:)
	)
)

(instance aWord8 of InterFeature
	(properties
		nsTop 181
		nsLeft 115
		nsBottom 187
		nsRight 123
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1080 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 8 posn: 116 188 init:)
	)
)

(instance aWord9 of InterFeature
	(properties
		nsTop 181
		nsLeft 127
		nsBottom 187
		nsRight 152
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1081 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 9 posn: 139 188 init:)
	)
)

(instance aWord10 of InterFeature
	(properties
		nsTop 181
		nsLeft 156
		nsBottom 187
		nsRight 184
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1082 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 10 posn: 168 188 init:)
	)
)

(instance aWord11 of InterFeature
	(properties
		nsTop 181
		nsLeft 185
		nsBottom 187
		nsRight 207
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 11 posn: 196 188 init:)
	)
)

(instance aWord12 of InterFeature
	(properties
		nsTop 181
		nsLeft 210
		nsBottom 187
		nsRight 235
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1078 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 12 posn: 221 188 init:)
	)
)

(instance aWord13 of InterFeature
	(properties
		nsTop 181
		nsLeft 237
		nsBottom 187
		nsRight 252
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1058 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 13 posn: 243 188 init:)
	)
)

(instance aWord14 of InterFeature
	(properties
		nsTop 181
		nsLeft 254
		nsBottom 187
		nsRight 279
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1083 setLoop: 1 play: rm5)
		(theView view: 585 setLoop: 14 posn: 265 188 init:)
	)
)

(instance sneezer of InterFeature
	(properties
		x 100
		y 100
	)

	(method (doVerb)
		(mySound number: 982 play: setLoop: 1)
	)
)

(instance yipeeBush of InterFeature
	(properties
		x 45
		y 53
		nsTop 43
		nsLeft 33
		nsBottom 63
		nsRight 57
	)

	(method (doVerb)
		(gCurRoom setScript: yipee)
	)
)

(instance whoopieBush of InterFeature
	(properties
		x 224
		y 47
		nsTop 36
		nsLeft 206
		nsBottom 58
		nsRight 242
	)

	(method (doVerb)
		(gCurRoom setScript: whoopie)
	)
)

(instance winged of InterFeature
	(properties
		nsTop 89
		nsLeft 207
		nsBottom 118
		nsRight 230
	)

	(method (doVerb)
		(gCurRoom setScript: wingedDinoScript)
	)
)

(instance aHole of InterFeature
	(properties
		nsTop 126
		nsLeft 224
		nsBottom 134
		nsRight 240
	)

	(method (doVerb)
		(gCurRoom setScript: bubbleScript)
	)
)

(instance aTiger of InterFeature
	(properties
		nsTop 1
		nsLeft 33
		nsBottom 49
		nsRight 207
	)

	(method (doVerb)
		(gCurRoom setScript: tigerScript)
	)
)

(instance aSkater of InterFeature
	(properties
		nsTop 74
		nsLeft 89
		nsBottom 98
		nsRight 137
	)

	(method (doVerb)
		(gCurRoom setScript: aSkaterScript)
	)
)

(instance aVine of InterFeature
	(properties
		nsTop 7
		nsLeft 216
		nsBottom 26
		nsRight 241
	)

	(method (doVerb)
		(gCurRoom setScript: vineBugScript)
	)
)

(instance aRock of InterFeature
	(properties
		nsTop 95
		nsLeft 135
		nsBottom 132
		nsRight 194
	)

	(method (doVerb)
		(gCurRoom setScript: rockyScript)
	)
)

(instance theView of Prop
	(properties
		view 585
		cel 1
		priority 14
		signal 16
	)
)

(instance theProp of Prop
	(properties
		view 585
		cel 1
		priority 14
		signal 16
	)
)

(instance oddView of Prop
	(properties
		view 585
		cel 1
		priority 14
		signal 16
	)
)

(instance vineBugA of View
	(properties
		x 257
		y 45
		view 550
		loop 3
		priority 5
		signal 20497
	)
)

(instance rock of InterView
	(properties
		x 33
		y 176
		view 590
		loop 3
		priority 14
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: rockScript)
	)
)

(instance whoopieDino of Prop
	(properties
		x 224
		y 46
		view 540
	)
)

(instance yipeeDino of Prop
	(properties
		x 38
		y 49
		view 545
		signal 16401
	)
)

(instance charlieEyes of Prop
	(properties
		x 77
		y 78
		view 505
		loop 1
		priority 14
		signal 16401
	)
)

(instance charlieMouth of Prop
	(properties
		x 77
		y 82
		view 505
		loop 2
		priority 10
		signal 16401
	)
)

(instance snake of InterProp
	(properties
		x 261
		y 103
		view 555
		priority 13
		signal 16401
	)

	(method (doVerb)
		(gCurRoom setScript: snakeScript)
	)
)

(instance rocky of InterProp
	(properties
		x 201
		y 145
		view 560
		cel 1
		priority 11
		signal 16401
	)

	(method (doVerb)
		(gCurRoom setScript: rockyScript)
	)
)

(instance skater of Prop
	(properties
		x 72
		y 127
		view 525
		priority 8
		signal 16401
	)
)

(instance vineBug of Prop
	(properties
		x 257
		y 85
		view 550
		loop 3
		priority 9
		signal 20497
	)
)

(instance theFlower of Prop
	(properties
		x 155
		y 167
		view 591
		priority 12
		signal 16401
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: theFlower)
		(gKeyDownHandler addToEnd: theFlower)
	)

	(method (dispose)
		(gMouseDownHandler delete: theFlower)
		(gKeyDownHandler delete: theFlower)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(== (User canInput:) 1)
				(not (== (OnControl CONTROL (event x:) (event y:)) 8))
				(self onMe: event)
				(not (gCast contains: slater))
			)
			(gCurRoom setScript: theFlowerScript)
		else
			(super handleEvent: event)
		)
	)
)

(instance bushGuy of InterProp
	(properties
		x 62
		y 162
		view 591
		cel 4
		priority 14
		signal 16401
	)

	(method (doVerb)
		(if (not (gCast contains: slater))
			(gCurRoom setScript: bushGuyScript)
		)
	)
)

(instance drummer of InterProp
	(properties
		x 48
		y 100
		view 591
		cel 3
		priority 6
		signal 4113
	)

	(method (doVerb)
		(if (not (gCast contains: slater))
			(gCurRoom setScript: drummerScript)
		)
	)
)

(instance tiger of Prop
	(properties
		x 134
		view 535
		priority 7
		signal 17
	)
)

(instance bubbles of Prop
	(properties
		x 233
		y 131
		view 565
		priority 12
		signal 16401
	)
)

(instance head of Prop
	(properties
		x 233
		y 62
		view 565
		loop 4
	)
)

(instance pop of Prop
	(properties
		x 257
		y 86
		view 565
		loop 3
		priority 12
		signal 16
	)
)

(instance hula of InterProp
	(properties
		x 153
		y 97
		view 570
		priority 9
		signal 4113
		cycleSpeed 12
	)

	(method (doVerb)
		(gCurRoom setScript: hulaScript)
	)
)

(instance tigerEyes of Prop
	(properties
		x 131
		y 24
		view 535
		loop 4
		priority 11
		signal 16400
	)
)

(instance branch of Prop
	(properties
		x 216
		y 15
		view 591
		cel 6
		priority 5
		signal 16401
	)
)

(instance hive of Prop
	(properties
		x 217
		y 11
		view 591
		cel 5
		priority 6
		signal 16401
	)
)

(instance slater of InterProp
	(properties
		x 171
		y 98
		view 592
		cel 1
		priority 12
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: slaterScript)
	)
)

(instance charlie of InterProp
	(properties
		x 41
		y 132
		view 592
		priority 12
		signal 4113
	)

	(method (doVerb)
		(gCurRoom setScript: slaterScript)
	)
)

(instance wingedDino of InterActor
	(properties
		x 230
		y 120
		view 591
		cel 7
		priority 5
		signal 20481
	)

	(method (doVerb)
		(if (not (gCast contains: slater))
			(gCurRoom setScript: wingedDinoScript)
		)
	)
)

(instance wingedClothes of Actor
	(properties
		x 230
		y 62
		view 510
		loop 1
		priority 8
		signal 16400
	)
)

(instance wings of Actor
	(properties
		x 231
		y 62
		view 510
		loop 2
		signal 20497
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

(instance my3Sound of Sound
	(properties)
)

