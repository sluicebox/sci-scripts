;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use CycleBet)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm10 0
)

(local
	local0
	local1
	local2
)

(instance rm10 of Rm
	(properties
		picture 1000
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(super init:)
		(gLongSong number: 113 setLoop: -1 play: 10 fade: 127 10 30 0)
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
		(rock init:)
		(branch init: stopUpd:)
		(bushWorm init: stopUpd:)
		(charlie init: stopUpd:)
		(cEyes init: stopUpd:)
		(cEyes2 init: x: 82 y: 96 stopUpd:)
		(treeTrunkT init: setPri: 0 stopUpd:)
		(treeTrunkM init: setPri: 0 stopUpd:)
		(treeTrunkB init: setPri: 0 stopUpd:)
		(sky init:)
		(rock_dino init: stopUpd:)
		(turtles init: stopUpd:)
		(spinningVine init: stopUpd:)
		(flower1 init: stopUpd:)
		(flower2 init: stopUpd:)
		(rocksStop init: stopUpd:)
		(bigRockFea init:)
		(slater init: ignoreActors: 1 stopUpd:)
		(pond init: setOnMeCheck: 1 16384)
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
		(gLongSong fade: 0 10 30 1)
		(super newRoom: newRoomNumber)
	)
)

(instance sBushWorm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsVIEW 1010 1000)
				(gLongSong number: 112 play:)
				(= cycles 1)
			)
			(1
				(bushWorm view: 1010 loop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(2
				(mySound number: 928 setLoop: 1 play:)
				(bushWorm setCycle: CT 7 1 self)
			)
			(3
				(mySound number: 940 setLoop: 1 play:)
				(bushWorm setCycle: CT 14 1 self)
			)
			(4
				(mySound number: 928 setLoop: 1 play:)
				(bushWorm setCycle: End self)
			)
			(5
				(bushWorm view: 1000 loop: 0 setCel: 0 stopUpd:)
				(= ticks 25)
			)
			(6
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPiranhaFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(cEyes dispose:)
				(cEyes2 dispose:)
				(charlie
					view: 1020
					loop: 0
					setCel: 0
					posn: 121 140
					setCycle: CT 3 1 self
				)
				(mySound number: 997 play: self setLoop: 1)
			)
			(2)
			(3
				(mySound number: 947 setLoop: 1 play: self)
			)
			(4
				(charlie setCycle: CT 5 1 self)
			)
			(5
				(= ticks 30)
			)
			(6
				(charlie setCel: 8 setCycle: End self)
				(mySound number: 1014 setLoop: 1 play: self)
			)
			(7
				(charlie loop: 1 setCel: 0 cycleSpeed: 8 setCycle: CT 8 1 self)
			)
			(8
				(= ticks 25)
			)
			(9
				(charlie setCel: 8 setCycle: CT 9 1 self)
			)
			(10
				(charlie setCel: 9 setCycle: CT 8 -1 self)
			)
			(11
				(mySound number: 934 setLoop: 1 play:)
				(charlie setCel: 8 setCycle: CT 9 1 self)
			)
			(12
				(my2Sound number: 947 setLoop: 1 play:)
				(charlie setCycle: End self)
			)
			(13
				(mySound number: 996 setLoop: -1 play:)
				(charlie loop: 2 setCel: 0 setCycle: CycleBet 0 2 -1)
				(= ticks 100)
			)
			(14
				(mySound stop:)
				(charlie view: 1021 loop: 0 setCel: 0 setCycle: CT 8 1 self)
			)
			(15
				(mySound number: 1031 setLoop: 1 play:)
				(charlie setCel: 8 setCycle: End self)
			)
			(16
				(my2Sound number: 997 setLoop: 1 play:)
				(charlie loop: 1 setCel: 0)
				(= cycles 1)
			)
			(17
				(charlie view: 1020 loop: 0 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTreeTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gLongSong number:) 130)
					(gLongSong number: 130 play: setLoop: -1)
				)
				(switch register
					(1
						(= local2 treeTrunkT)
					)
					(2
						(= local2 treeTrunkM)
					)
					(3
						(= local2 treeTrunkB)
					)
				)
				(= cycles 1)
			)
			(1
				(local2
					view: 1025
					loop: (if (== register 1) 0 else 1)
					setCel: 0
					setCycle: End self
				)
				(mySound number: 955 setLoop: 1 play:)
			)
			(2
				(mySound stop:)
				(local2 loop: 2 setCel: 0 cycleSpeed: 13 setCycle: Fwd)
				(= ticks 212)
			)
			(3
				(my2Sound number: 955 play: setLoop: 1)
				(local2
					loop: (if (== register 1) 0 else 1)
					setCel: 14
					cycleSpeed: 6
					setCycle: Beg self
				)
			)
			(4
				(my2Sound stop:)
				(local2
					view: 1000
					loop: 0
					setCel: (if (== register 1) 1 else 2)
					stopUpd:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (== state 2) (== (local2 cel:) 1))
			(mySound number: 1034 setLoop: 1 play:)
		)
		(super doit:)
	)
)

(instance sPteroFlys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(ptero
					view: 1030
					setLoop: 0
					posn: 29 40
					cycleSpeed: 7
					init:
					setPri: 6
					setCycle: Fwd
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 200 41 self
				)
			)
			(2
				(ptero setMotion: MoveTo 224 35 self)
			)
			(3
				(branch dispose:)
				(mySound number: 996 setLoop: 1 play:)
				(ptero loop: 1 setCel: 0 posn: 230 24 setCycle: CT 10 1 self)
			)
			(4
				(= ticks 50)
			)
			(5
				(mySound number: 910 setLoop: 1 play:)
				(ptero setCycle: CT 11 1 self)
			)
			(6
				(= cycles 3)
			)
			(7
				(ptero setCycle: End self)
			)
			(8
				(= ticks 100)
			)
			(9
				(mySound number: 910 setLoop: 1 play:)
				(ptero loop: 2 setCel: 0 setCycle: End self)
				(branch init: setCel: 3 stopUpd:)
			)
			(10
				(mySound number: 952 setLoop: 1 play:)
				(ptero
					setLoop: 3
					setCel: 0
					posn: 221 94
					setCycle: Fwd
					setMotion: MoveTo 310 117 self
				)
				(my2Sound number: 929 setLoop: -1 play:)
			)
			(11
				(branch setCel: 2 stopUpd:)
				(my2Sound stop:)
				(ptero dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (== (mySound prevSignal:) -1) (< state 3) (== (ptero cel:) 2))
			(mySound number: 978 setLoop: 1 play:)
		)
		(super doit:)
	)
)

(instance sTinyDinoRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(rock_dino view: 1035 loop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(mySound number: 950 setLoop: 1 play:)
				(rock_dino setCycle: End self)
			)
			(3
				(rock_dino loop: 1 setCel: 0 setCycle: CT 7 1 self)
			)
			(4
				(= ticks 5)
			)
			(5
				(rock_dino setCel: 7 setCycle: CT 8 1 self)
			)
			(6
				(mySound number: 1022 setLoop: 1 play:)
				(rock_dino setCycle: CT 10 1 self)
			)
			(7
				(mySound number: 1022 setLoop: 1 play: self)
				(rock_dino setCycle: CycleBet 7 10 -1)
			)
			(8
				(rock_dino setCycle: End self)
			)
			(9
				(mySound number: 926 setLoop: 1 play:)
				(rock_dino view: 1000 loop: 0 setCel: 3 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurtle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 1003 setLoop: 1 play:)
				(= cycles 1)
			)
			(1
				(turtles view: 1040 loop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(turtles loop: 1 setCel: 0 setCycle: End self)
				(mySound number: 1033 setLoop: 1 play:)
			)
			(3
				(turtles loop: 2 setCel: 0 setCycle: CT 3 1 self)
				(my2Sound number: 1149 setLoop: 1 play:)
			)
			(4
				(turtles setCel: 3 setCycle: CT 0 -1 self)
			)
			(5
				(turtles setCel: 0 setCycle: CT 3 1 self)
				(my2Sound number: 1159 setLoop: 1 play:)
			)
			(6
				(turtles setCel: 3 setCycle: CT 0 -1 self)
			)
			(7
				(turtles setCel: 0 setCycle: CT 3 1 self)
				(my2Sound number: 1160 setLoop: 1 play:)
			)
			(8
				(turtles setCel: 3 setCycle: CT 0 -1 self)
			)
			(9
				(turtles setCel: 0 setCycle: CT 6 1 self)
			)
			(10
				(turtles setCel: 7)
				(mySound number: 982 setLoop: 1 play:)
				(= ticks 25)
			)
			(11
				(my2Sound number: 914 setLoop: 1 play:)
				(turtles setCycle: End self)
			)
			(12
				(turtles view: 1000 loop: 1 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSpinningVine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(my2Sound number: 945 setLoop: 1 play:)
				(= cycles 1)
			)
			(1
				(spinningVine
					view: 1045
					loop: 0
					setCel: 0
					posn: 123 82
					setPri: 1
					setCycle: CT 2 1 self
				)
			)
			(2
				(spinningVine setCycle: End self)
			)
			(3
				(my2Sound number: 934 setLoop: 1 play:)
				(spinningVine loop: 1 setCel: 0 setCycle: CT 10 1 self)
			)
			(4
				(my2Sound number: 924 setLoop: 1 play: self)
			)
			(5
				(= ticks 15)
			)
			(6
				(spinningVine setCycle: End self)
			)
			(7
				(mySound number: 1020 setLoop: 1 play:)
				(spinningVine loop: 2 setCel: 0 setCycle: CT 4 1 self)
			)
			(8
				(treeTrunkT setPri: 0)
				(treeTrunkM setPri: 0)
				(mySound number: 994 play: setLoop: 1)
				(spinningVine setCycle: CT 9 1 self)
			)
			(9
				(mySound number: 994 play: setLoop: 1)
				(spinningVine setCycle: CT 12 1 self)
			)
			(10
				(mySound number: 994 play: setLoop: 1)
				(spinningVine setCycle: End self)
			)
			(11
				(mySound number: 991 play: setLoop: 1)
				(spinningVine loop: 3 setCel: 0 setCycle: CT 2 1 self)
			)
			(12
				(mySound number: 986 setLoop: 1 play:)
				(spinningVine setCycle: End self)
			)
			(13
				(spinningVine loop: 4 setCel: 0 setCycle: End self)
			)
			(14
				(spinningVine
					view: 1000
					loop: 1
					setCel: 1
					posn: 104 72
					stopUpd:
				)
				(= ticks 40)
			)
			(15
				(treeTrunkT setPri: 0)
				(treeTrunkM setPri: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTugOWar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spinningVine view: 1050 loop: 0 setCel: 2 posn: 104 71)
				(= cycles 1)
			)
			(1
				(mySound number: 1003 setLoop: 1 play:)
				(flower2 hide:)
				(flower1 view: 1050 loop: 1 setCel: 0 setCycle: CT 6 1 self)
			)
			(2
				(mySound number: 910 setLoop: 1 play:)
				(spinningVine hide:)
				(flower1 setCycle: CT 9 1 self)
			)
			(3
				(mySound number: 934 setLoop: 1 play:)
				(flower1 setCycle: End self)
			)
			(4
				(flower1 setCel: 14 setCycle: CT 11 -1 self)
			)
			(5
				(flower1 setCel: 11 setCycle: CT 14 1 self)
			)
			(6
				(flower1 setCel: 14 setCycle: CT 11 -1 self)
			)
			(7
				(flower1 setCel: 11 setCycle: CT 14 1 self)
			)
			(8
				(flower1 loop: 2 setCel: 0 setCycle: CT 2 1 self)
			)
			(9
				(mySound number: 947 setLoop: 1 play:)
				(flower1 setCycle: End self)
			)
			(10
				(flower1 view: 1000 loop: 1 setCel: 2 stopUpd:)
				(flower2 show: stopUpd:)
				(spinningVine
					view: 1000
					loop: 1
					setCel: 1
					posn: 104 71
					show:
					stopUpd:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDivingDino of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 1056)
				(= cycles 1)
			)
			(1
				(divingDino view: 1055 loop: 0 setCel: 0 init:)
				(= ticks 50)
			)
			(2
				(divingDino cycleSpeed: 2 setCycle: CT 7 1 self)
			)
			(3
				(divingBoard hide:)
				(cEyes view: 1020 loop: 3 cel: 6 x: 80 y: 90 init:)
				(cEyes2 view: 1020 loop: 4 cel: 6 x: 80 y: 88 init:)
				(divingDino setCycle: CT 11 1 self)
			)
			(4
				(mySound number: 911 setLoop: 1 play:)
				(divingDino setCycle: End self)
				(cEyes setCycle: Beg)
				(cEyes2 setCycle: Beg)
			)
			(5
				(divingDino loop: 1 setCel: 0 setCycle: End self)
				(my2Sound number: 1035 setLoop: 1 play:)
			)
			(6
				(divingDino
					view: 1056
					loop: 0
					setCel: 0
					cycleSpeed: -1
					setCycle: CT 2 1 self
				)
				(cEyes dispose:)
				(cEyes2 dispose:)
				(charlie hide:)
				(divingBoard show:)
			)
			(7
				(mySound number: 992 setLoop: 1 play:)
				(= ticks 25)
			)
			(8
				(divingDino setCel: 2 setCycle: CT 6 1 self)
			)
			(9
				(my2Sound number: 1026 play:)
				(= ticks 25)
			)
			(10
				(divingDino setCel: 6 setCycle: CT 7 1 self)
			)
			(11
				(mySound number: 930 setLoop: 1 play:)
				(divingDino setCycle: CT 9 1 self)
			)
			(12
				(my2Sound number: 997 setLoop: 1 play:)
				(divingDino setCel: 9 setCycle: End self)
			)
			(13
				(divingDino hide: dispose:)
				(LoadMany 0 1056)
				(charlie show: stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRockMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rockMan init:)
				(= cycles 1)
			)
			(1
				(mySound number: 925 setLoop: 1 play:)
				(rockMan loop: 0 setCel: 0 setCycle: CT 6 1 self)
			)
			(2
				(rocksStop hide:)
				(rockMan setCycle: CT 14 1 self)
			)
			(3
				(= ticks 100)
			)
			(4
				(mySound number: 904 setLoop: 1 play:)
				(rockMan setCycle: End self)
			)
			(5
				(rockMan setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(6
				(mySound number: 952 play: setLoop: 1)
				(rockMan setCycle: CT 6 1 self)
			)
			(7
				(my2Sound number: 925 play: setLoop: 1)
				(mySound number: 952 setLoop: 1 play:)
				(rockMan setCycle: CT 8 1 self)
			)
			(8
				(mySound number: 930 play: setLoop: 1)
				(rockMan setCycle: End self)
			)
			(9
				(mySound number: 952 play: setLoop: 1)
				(rockMan dispose:)
				(rocksStop show: stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSlaterDive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(slater view: 1065 loop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(2
				(mySound number: 911 setLoop: 1 play:)
				(slater setCycle: CT 2 1 self)
			)
			(3
				(divingBoard init: stopUpd:)
				(slater setCel: 3 setCycle: CT 6 1 self)
				(cEyes cycleSpeed: 0 setCycle: Beg)
				(cEyes2 cycleSpeed: 0 setCycle: Beg)
			)
			(4
				(mySound number: 997 play:)
				(slater setCycle: CT 10 1 self)
				(cEyes dispose:)
				(cEyes2 dispose:)
			)
			(5
				(slater setCel: 11 posn: 168 126 stopUpd:)
				(= ticks 10)
			)
			(6
				(= ticks 100)
			)
			(7
				(my2Sound number: 997 setLoop: 1 play:)
				(cEyes dispose:)
				(cEyes2 dispose:)
				(charlie setCycle: Beg self)
			)
			(8
				(charlie stopUpd:)
				(slater view: 1000 loop: 2 setCel: 0 stopUpd:)
				(= local1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSlaterFish of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 2)
				(== (mySound prevSignal:) -1)
				(or (== (slater cel:) 2) (== (slater cel:) 8))
			)
			(if (and (== (my2Sound prevSignal:) -1) (== (Random 0 4) 1))
				(my2Sound number: 937 play: setLoop: 1)
			)
			(mySound number: 954 setLoop: 1 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(mySound number: 997 setLoop: 1 play:)
				(slater view: 1065 loop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(slater loop: 2 setCel: 0 setCycle: CycleBet 0 8 -1)
				(= ticks 200)
			)
			(3
				(slater loop: 3 setCel: 0 setCycle: CT 4 1 self)
				(mySound number: 991 setLoop: 1 play:)
			)
			(4
				(slater setCycle: End self)
				(my2Sound number: 997 setLoop: 1 play:)
			)
			(5
				(slater view: 1000 loop: 2 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSlaterBubbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(bubbles
					view: 1005
					loop: 0
					setCel: 0
					init:
					posn: (- (slater x:) 35) (+ (slater y:) 1)
					setCycle: CT 6 1 self
				)
			)
			(2
				(mySound number: 924 setLoop: 1 play:)
				(bubbles setCel: 7)
				(= ticks 10)
			)
			(3
				(my2Sound number: 924 setLoop: 1 play:)
				(bubbles setCel: 8)
				(= ticks 10)
			)
			(4
				(bubbles setCycle: CT 10 1 self)
			)
			(5
				(mySound number: 924 setLoop: 1 play:)
				(bubbles setCel: 11)
				(= ticks 10)
			)
			(6
				(bubbles setCycle: CT 13 1 self)
			)
			(7
				(mySound number: 924 setLoop: 1 play:)
				(bubbles setCel: 14)
				(= ticks 10)
			)
			(8
				(bubbles setCel: 14 setCycle: End self)
			)
			(9
				(bubbles dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rock setCel: 1)
				(= ticks 60)
			)
			(1
				(gGame handsOff:)
				(theView view: 1070 setLoop: 0 setCel: 1 posn: 111 176 init:)
				(mySound number: 1051 setLoop: 1 play:)
				(= ticks 16)
			)
			(2
				(gGame handsOff:)
				(theProp view: 1070 setLoop: 1 setCel: 1 posn: 185 176 init:)
				(= ticks 25)
			)
			(3
				(gGame handsOff:)
				(theView2 view: 1070 setLoop: 2 setCel: 1 posn: 156 188 init:)
				(= ticks 15)
			)
			(4
				(theView hide: dispose:)
				(= ticks 35)
			)
			(5
				(theProp hide: dispose:)
				(= ticks 20)
			)
			(6
				(theProp view: 1070 setLoop: 3 setCel: 1 posn: 202 188 init:)
				(= ticks 50)
			)
			(7
				(theView2 hide: dispose:)
				(= ticks 126)
			)
			(8
				(theProp hide: dispose:)
				(rock setCel: 0 stopUpd:)
				(if local1
					(= cycles 1)
				else
					(self setScript: sSlaterDive self)
				)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 161
		nsLeft 73
		nsBottom 178
		nsRight 117
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1054 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 0 posn: 95 176 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 161
		nsLeft 117
		nsBottom 178
		nsRight 154
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1111 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 1 posn: 135 176 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 161
		nsLeft 154
		nsBottom 178
		nsRight 165
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1093 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 2 posn: 159 176 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 161
		nsLeft 166
		nsBottom 178
		nsRight 189
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1112 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 3 posn: 177 176 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 161
		nsLeft 189
		nsBottom 178
		nsRight 218
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1113 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 4 posn: 202 176 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 164
		nsLeft 218
		nsBottom 178
		nsRight 246
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1114 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 5 posn: 231 176 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 164
		nsLeft 246
		nsBottom 178
		nsRight 261
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1093 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 2 posn: 251 176 init:)
	)
)

(instance aWord7 of InterFeature
	(properties
		nsTop 179
		nsLeft 56
		nsBottom 188
		nsRight 99
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1115 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 6 posn: 78 188 init:)
	)
)

(instance aWord8 of InterFeature
	(properties
		nsTop 179
		nsLeft 99
		nsBottom 188
		nsRight 134
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1116 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 7 posn: 116 188 init:)
	)
)

(instance aWord9 of InterFeature
	(properties
		nsTop 179
		nsLeft 143
		nsBottom 188
		nsRight 157
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1093 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 2 posn: 151 188 init:)
	)
)

(instance aWord10 of InterFeature
	(properties
		nsTop 179
		nsLeft 157
		nsBottom 188
		nsRight 191
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1117 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 8 posn: 175 188 init:)
	)
)

(instance aWord11 of InterFeature
	(properties
		nsTop 179
		nsLeft 191
		nsBottom 188
		nsRight 230
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1115 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 6 posn: 209 188 init:)
	)
)

(instance aWord12 of InterFeature
	(properties
		nsTop 179
		nsLeft 230
		nsBottom 188
		nsRight 266
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1116 setLoop: 1 play: rm10)
		(theView view: 1075 setLoop: 7 posn: 246 188 init:)
	)
)

(instance sky of InterFeature
	(properties
		nsLeft 34
		nsBottom 45
		nsRight 123
	)

	(method (doVerb)
		(gCurRoom setScript: sPteroFlys)
	)
)

(instance branch of View
	(properties
		x 230
		y 24
		view 1000
		loop 2
		cel 2
	)
)

(instance rock of InterView
	(properties
		x 67
		y 175
		view 1080
		loop 3
		priority 15
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: rockScript)
	)
)

(instance cEyes of Prop
	(properties
		x 80
		y 97
		view 1020
		loop 3
		cel 3
		priority 14
		signal 16400
	)
)

(instance cEyes2 of Prop
	(properties
		x 85
		y 96
		view 1020
		loop 4
		cel 3
		priority 14
		signal 16400
	)
)

(instance bushWorm of InterProp
	(properties
		x 152
		y 163
		view 1000
		signal 4096
	)

	(method (doVerb)
		(gCurRoom setScript: sBushWorm)
	)
)

(instance charlie of InterProp
	(properties
		x 122
		y 140
		view 1020
		cel 4
		signal 20480
	)

	(method (doVerb)
		(if local1
			(gCurRoom setScript: sPiranhaFish)
		)
	)
)

(instance treeTrunkT of InterProp
	(properties
		x 272
		y 62
		view 1000
		cel 1
		signal 20480
	)

	(method (doVerb)
		(gCurRoom setScript: sTreeTrunk 0 1)
	)
)

(instance treeTrunkM of InterProp
	(properties
		x 271
		y 84
		view 1000
		cel 2
		signal 20480
	)

	(method (doVerb)
		(gCurRoom setScript: sTreeTrunk 0 2)
	)
)

(instance treeTrunkB of InterProp
	(properties
		x 272
		y 104
		view 1000
		cel 2
		priority 6
		signal 20496
	)

	(method (doVerb)
		(gCurRoom setScript: sTreeTrunk 0 3)
	)
)

(instance rock_dino of InterProp
	(properties
		x 273
		y 163
		view 1000
		cel 3
	)

	(method (doVerb)
		(gCurRoom setScript: sTinyDinoRock)
	)
)

(instance turtles of InterProp
	(properties
		x 168
		y 76
		view 1000
		loop 1
		signal 4096
	)

	(method (doVerb)
		(gCurRoom setScript: sTurtle)
	)
)

(instance spinningVine of InterProp
	(properties
		x 104
		y 71
		view 1000
		loop 1
		cel 1
	)

	(method (doVerb)
		(gCurRoom setScript: sSpinningVine)
	)
)

(instance flower1 of InterProp
	(properties
		x 53
		y 85
		view 1000
		loop 1
		cel 2
		signal 16384
	)

	(method (doVerb)
		(gCurRoom setScript: sTugOWar)
	)
)

(instance flower2 of InterProp
	(properties
		x 53
		y 85
		view 1000
		loop 1
		cel 3
		signal 16384
	)

	(method (doVerb theVerb)
		(flower1 doVerb: theVerb)
	)
)

(instance divingDino of Prop
	(properties
		x 124
		y 148
		view 1055
	)
)

(instance divingBoard of InterView
	(properties
		x 258
		y 126
		view 1000
		loop 1
		cel 4
		signal 16384
	)

	(method (doVerb)
		(gCurRoom setScript: sDivingDino)
	)
)

(instance rockMan of Prop
	(properties
		x 214
		y 88
		view 1060
	)
)

(instance bigRockFea of InterFeature
	(properties
		nsTop 37
		nsLeft 188
		nsBottom 72
		nsRight 225
	)

	(method (doVerb)
		(gCurRoom setScript: sRockMan)
	)
)

(instance rocksStop of InterProp
	(properties
		x 214
		y 88
		view 1000
		loop 1
		cel 6
	)

	(method (doVerb)
		(gCurRoom setScript: sRockMan)
	)
)

(instance slater of InterProp
	(properties
		x 172
		y 147
		view 1065
		signal 4096
	)

	(method (doVerb)
		(gCurRoom setScript: sSlaterBubbles)
	)
)

(instance pond of InterFeature
	(properties)

	(method (doVerb)
		(gCurRoom setScript: sSlaterFish)
	)
)

(instance bubbles of Prop
	(properties
		view 1005
	)
)

(instance theView of Prop
	(properties
		view 1070
		cel 1
		priority 15
		signal 16
	)
)

(instance theView2 of Prop
	(properties
		view 1070
		cel 1
		priority 15
		signal 16
	)
)

(instance theProp of Prop
	(properties
		view 1070
		cel 1
		priority 15
		signal 16
	)
)

(instance ptero of Actor
	(properties
		x 29
		y 40
		view 1030
		signal 16384
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

