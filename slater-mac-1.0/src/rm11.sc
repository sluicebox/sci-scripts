;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use CycleBet)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm11 0
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
	local8
	local9
)

(instance rm11 of Rm
	(properties
		picture 1100
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(super init:)
		(= local1 0)
		(= local9 1)
		(gLongSong2 number: 150 setLoop: -1 play: 10 fade: 127 10 30 0)
		(Load rsSCRIPT 991)
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
		(suctionBushes init: stopUpd:)
		(suctionBushes2 init: stopUpd:)
		(slater init: stopUpd:)
		(door1 init: stopUpd:)
		(door2 init: stopUpd:)
		(cloud init: stopUpd:)
		(cloud2 init: stopUpd:)
		(cloud3 init: stopUpd:)
		(rockEyes init: stopUpd:)
		(charlie init: stopUpd:)
		(balloonPineapple init: stopUpd:)
		(dinoPilot init: stopUpd:)
		(rocketShip init: stopUpd:)
		(turtles init: stopUpd:)
		(baseballDino init: stopUpd:)
		(capFea init:)
		(rockFea init:)
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
		(DisposeScript 991)
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
				(rock setCel: 1)
				(= ticks 12)
			)
			(2
				(gGame handsOff:)
				(theView view: 1155 setLoop: 0 setCel: 1 posn: 89 176 init:)
				(mySound number: 1052 setLoop: 1 play:)
				(= ticks 21)
			)
			(3
				(theProp view: 1155 setLoop: 1 setCel: 1 posn: 169 176 init:)
				(= ticks 22)
			)
			(4
				(thirdProp view: 1155 setLoop: 2 setCel: 1 posn: 244 176 init:)
				(= ticks 25)
			)
			(5
				(theView hide:)
				(= ticks 25)
			)
			(6
				(theProp view: 1155 setLoop: 3 setCel: 1 posn: 122 187)
				(= ticks 74)
			)
			(7
				(thirdProp hide:)
				(= ticks 19)
			)
			(8
				(theView view: 1155 setLoop: 4 setCel: 1 posn: 204 187 show:)
				(= ticks 69)
			)
			(9
				(thirdProp view: 1155 setLoop: 5 setCel: 1 posn: 242 187 show:)
				(= ticks 6)
			)
			(10
				(theProp hide: dispose:)
				(= ticks 44)
			)
			(11
				(theView hide: dispose:)
				(= ticks 56)
			)
			(12
				(thirdProp hide: dispose:)
				(rock setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSuctionBushes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(mySound number: 928 setLoop: 1 play:)
				(suctionBushes
					view: 1100
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 73 104 self
				)
				(suctionBushes2
					view: 1100
					setLoop: 1
					setCel: 0
					setMotion: MoveTo 50 104 self
				)
			)
			(2 0)
			(3
				(mySound stop:)
				(suctionBushes setCycle: Fwd)
				(suctionBushes2 setCycle: Fwd)
				(= ticks 100)
			)
			(4
				(suctionBushes setLoop: 2 setCel: 0 setCycle: CT 2 1 self)
				(suctionBushes2 setLoop: 3 setCel: 0 setCycle: CT 2 1 self)
			)
			(5
				(mySound number: 926 setLoop: 1 play:)
				0
			)
			(6
				(= ticks 75)
			)
			(7
				(mySound number: 934 play:)
				(suctionBushes setCel: 2 setCycle: CT 5 1 self)
				(suctionBushes2 setCel: 2 setCycle: CT 5 1 self)
			)
			(8 0)
			(9
				(mySound number: 934 play: self)
				(suctionBushes setCel: 2 setCycle: CT 5 1 self)
				(suctionBushes2 setCel: 2 setCycle: CT 5 1 self)
			)
			(10 0)
			(11 0)
			(12
				(suctionBushes setCel: 2)
				(suctionBushes2 setCel: 2)
				(= ticks 50)
			)
			(13
				(mySound number: 934 play:)
				(suctionBushes setCel: 2 setCycle: CT 5 1 self)
				(suctionBushes2 setCel: 2 setCycle: CT 5 1 self)
			)
			(14 0)
			(15
				(= ticks 100)
			)
			(16
				(mySound number: 911 setVol: 127 play:)
				(suctionBushes setCel: 6)
				(suctionBushes2 setCel: 6)
				(= ticks 12)
			)
			(17
				(suctionBushes setCel: 1 setCycle: CT 0 -1 self)
				(suctionBushes2 setCel: 1 setCycle: CT 0 -1 self)
			)
			(18 0)
			(19
				(suctionBushes setLoop: 0 setCel: 0 setCycle: Fwd)
				(suctionBushes2 setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 100)
			)
			(20
				(mySound number: 928 setLoop: 1 play:)
				(suctionBushes
					setLoop: 0
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 73 121 self
				)
				(suctionBushes2
					setLoop: 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 50 121 self
				)
			)
			(21 0)
			(22
				(mySound stop:)
				(suctionBushes
					view: 1101
					loop: 0
					setCel: 1
					setCycle: 0
					stopUpd:
				)
				(suctionBushes2
					view: 1101
					loop: 0
					setCel: 0
					setCycle: 0
					stopUpd:
				)
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSlaterFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(slater view: 1105 setLoop: 2 setCel: 0 setCycle: Fwd)
				(= ticks 100)
			)
			(2
				(slater
					loop: 0
					setCel: 0
					cycleSpeed: 15
					moveSpeed: 15
					setCycle: CT 1 1 self
				)
			)
			(3
				(mySound number: 994 setLoop: 1 play:)
				(slater setCycle: CT 3 1 self)
			)
			(4
				(my2Sound number: 1002 setLoop: 1 play: self)
			)
			(5
				(slater setLoop: 3 setCel: 0 setCycle: Fwd)
				(= ticks 100)
			)
			(6
				(mySound number: 994 setLoop: 1 play:)
				(slater setLoop: 0 setCel: 4 setCycle: CT 6 1 self)
			)
			(7
				(charlie view: 1105 loop: 1 setCel: 0)
				(slater setCel: 6 setPri: 0 setCycle: CT 11 1 self)
			)
			(8
				(mySound number: 991 setLoop: 1 play:)
				(slater setCycle: CT 14 1 self)
			)
			(9
				(my2Sound number: 991 setLoop: 1 play:)
				(slater setCycle: End self)
			)
			(10
				(slater dispose:)
				(= ticks 50)
			)
			(11
				(charlie view: 1125 loop: 0 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDinoRockRight of Script
	(properties)

	(method (doit)
		(if
			(and
				(== (dinoRock loop:) 0)
				(< 10 (dinoRock cel:) 15)
				(!= (dinoRock cel:) local5)
				(< (sDinoRockRight state:) 5)
			)
			(= local5 (dinoRock cel:))
			(mySound number: 956 loop: 1 play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 1)
				(= cycles 1)
			)
			(1
				(door1 view: 1110 setLoop: 4 setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(mySound number: 934 setLoop: 1 play:)
				(dinoRock
					view: 1110
					loop: 0
					setCel: 0
					posn: 208 158
					init:
					setCycle: CT 9 1 self
				)
			)
			(3
				(mySound stop:)
				(door1 setCycle: CT 3 1)
				(my2Sound number: 904 setLoop: 1 play:)
				(= ticks 50)
			)
			(4
				(dinoRock setCycle: CT 12 1 setMotion: MoveTo 216 161 self)
			)
			(5
				(door1 view: 1101 setLoop: 2 setCel: 0 setCycle: 0 stopUpd:)
				(= ticks 25)
			)
			(6
				(= ticks 25)
			)
			(7
				(dinoRock setCel: 13 setCycle: CT 14 1 self)
			)
			(8
				(my2Sound number: 987 setLoop: 1 play:)
				(dinoRock setCycle: CT 15 1 self)
			)
			(9
				(= ticks 15)
			)
			(10
				(dinoRock setCel: 13 setCycle: CT 14 1 self)
			)
			(11
				(my2Sound number: 987 setLoop: 1 play:)
				(dinoRock setCycle: CT 15 1 self)
			)
			(12
				(= ticks 15)
			)
			(13
				(dinoRock setCel: 13 setCycle: CT 14 1 self)
			)
			(14
				(my2Sound number: 987 setLoop: 1 play:)
				(dinoRock setCycle: CT 15 1 self)
			)
			(15
				(= ticks 50)
			)
			(16
				(mySound number: 1154 setLoop: 1 play: self)
			)
			(17
				(door2 init: setCycle: CT 2 1 self)
			)
			(18
				(= ticks 15)
			)
			(19
				(dinoRock loop: 2 setCel: 0 posn: 209 160 setCycle: CT 4 1 self)
			)
			(20
				(my2Sound number: 934 setLoop: 1 play:)
				(dinoRock setCycle: End self)
			)
			(21
				(door2 setCel: 3)
				(= ticks 6)
			)
			(22
				(door2 setCel: 1 stopUpd:)
				(= ticks 6)
			)
			(23
				(mySound number: 924 setLoop: 1 play:)
				(my2Sound stop:)
				(gGame handsOn:)
				(dinoRock dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sDinoRockLeft of Script
	(properties)

	(method (doit)
		(if
			(and
				(== (dinoRock loop:) 1)
				(< 10 (dinoRock cel:) 15)
				(!= (dinoRock cel:) local5)
				(< (sDinoRockLeft state:) 5)
			)
			(= local5 (dinoRock cel:))
			(mySound number: 956 loop: 1 play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 0)
				(= cycles 1)
			)
			(1
				(door2 setCycle: CT 2 1 self)
			)
			(2
				(mySound number: 934 setLoop: 1 play:)
				(dinoRock
					view: 1110
					loop: 1
					setCel: 0
					posn: 226 159
					init:
					setCycle: CT 9 1 self
				)
			)
			(3
				(mySound stop:)
				(door2 setCycle: CT 3 1)
				(my2Sound number: 904 setLoop: 1 play:)
				(= ticks 50)
			)
			(4
				(dinoRock setCycle: CT 12 1 setMotion: MoveTo 216 161 self)
			)
			(5
				(door2 view: 1101 setLoop: 2 setCel: 1 setCycle: 0 stopUpd:)
				(= ticks 25)
			)
			(6
				(= ticks 25)
			)
			(7
				(dinoRock setCel: 13 setCycle: CT 14 1 self)
			)
			(8
				(my2Sound number: 987 setLoop: 1 play:)
				(dinoRock setCycle: CT 15 1 self)
			)
			(9
				(= ticks 15)
			)
			(10
				(dinoRock setCel: 13 setCycle: CT 14 1 self)
			)
			(11
				(my2Sound number: 987 setLoop: 1 play:)
				(dinoRock setCycle: CT 15 1 self)
			)
			(12
				(= ticks 15)
			)
			(13
				(dinoRock setCel: 13 setCycle: CT 14 1 self)
			)
			(14
				(my2Sound number: 987 setLoop: 1 play:)
				(dinoRock setCycle: CT 15 1 self)
			)
			(15
				(= ticks 50)
			)
			(16
				(mySound number: 1154 setLoop: 1 play: self)
			)
			(17
				(door1 init: setCycle: CT 2 1 self)
			)
			(18
				(= ticks 15)
			)
			(19
				(dinoRock loop: 3 setCel: 0 posn: 224 159 setCycle: CT 4 1 self)
			)
			(20
				(my2Sound number: 934 setLoop: 1 play:)
				(dinoRock setCycle: End self)
			)
			(21
				(door2 setCel: 3)
				(= ticks 6)
			)
			(22
				(door1 view: 1101 setCel: 0 stopUpd:)
				(= ticks 6)
			)
			(23
				(mySound number: 924 setLoop: 1 play:)
				(my2Sound stop:)
				(gGame handsOn:)
				(dinoRock dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sCloud of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(local2 view: 1115 setLoop: 0 setCel: 0 setCycle: CT 3 1 self)
			)
			(2
				(switch local2
					(cloud
						(= local6 210)
						(= local7 34)
						(= local8 55)
					)
					(cloud2
						(= local6 278)
						(= local7 68)
						(= local8 84)
					)
					(cloud3
						(= local6 59)
						(= local7 48)
						(= local8 65)
					)
				)
				(mySound number: 934 setLoop: 1 play:)
				(local2 setCycle: End self)
			)
			(3
				(mySound number: 1037 setLoop: 1 play:)
				(local2 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(local2 view: 1101 setLoop: 0 setCel: 3 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRockEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(rockEyes view: 1120 loop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(2
				(mySound number: 1013 setLoop: 1 play:)
				(rockEyes setCycle: End self)
			)
			(3
				(rockEyes loop: 1 setCel: 0)
				(= ticks 50)
			)
			(4
				(rockEyes setCycle: CT 2 1)
				(my2Sound number: 991 setLoop: 1 play: self)
			)
			(5
				(= ticks 50)
			)
			(6
				(rockEyes setCel: 2 setCycle: CT 4 1)
				(my2Sound number: 991 setLoop: 1 play: self)
			)
			(7
				(= ticks 50)
			)
			(8
				(my2Sound number: 991 setLoop: 1 play:)
				(rockEyes setCel: 4 setCycle: CT 6 1 self)
			)
			(9
				(= ticks 50)
			)
			(10
				(rockEyes setCel: 7)
				(= ticks 50)
			)
			(11
				(mySound number: 951 setLoop: 1 play:)
				(rockEyes loop: 0 setCel: 4 setCycle: Beg self)
			)
			(12
				(rockEyes view: 1101 loop: 0 setCel: 4 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTreeFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(charlie
					view: 1125
					loop: 0
					setCel: 0
					setPri: 0
					setCycle: CT 5 1 self
				)
			)
			(2
				(mySound number: 952 setLoop: 1 play:)
				(charlie setCel: 5 setCycle: End self)
			)
			(3
				(my2Sound number: 941 setLoop: 1 play:)
				(charlie view: 1101 loop: 1 setCel: 0 setPri: 1 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBalloonPineapple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 1003 setLoop: 1 play:)
				(= ticks 2)
			)
			(1
				(balloonPineapple
					view: 1130
					setLoop: 0
					setCel: 0
					setPri: 0
					setCycle: CT 1 1 self
				)
			)
			(2
				(my2Sound number: 944 setLoop: 1 play:)
				(balloonPineapple setCycle: CT 4 1 self)
			)
			(3
				(balloonPineapple
					loop: 1
					setCel: 0
					setMotion: MoveTo 48 78 self
				)
			)
			(4
				(mySound number: 937 setLoop: 1 play:)
				(balloonPineapple
					setLoop: 3
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 48 42 self
				)
			)
			(5
				(= local4 66)
				(balloonPineapple setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 120)
			)
			(6
				(balloonPineapple loop: 2 setCel: 0 setCycle: CT 1 1 self)
			)
			(7
				(my2Sound number: 944 setLoop: 1 play:)
				(balloonPineapple setCycle: End self)
			)
			(8
				(balloonPineapple setMotion: MoveTo 48 78 self)
			)
			(9
				(balloonPineapple loop: 2 setCel: 0 setCycle: CT 1 1 self)
			)
			(10
				(my2Sound number: 944 setLoop: 1 play:)
				(balloonPineapple setCycle: End self)
			)
			(11
				(balloonPineapple setMotion: MoveTo 48 105 self)
			)
			(12
				(balloonPineapple setLoop: 0 setCel: 4 setCycle: Beg self)
			)
			(13
				(mySound number: 941 setLoop: 1 play:)
				(balloonPineapple
					view: 1101
					loop: 1
					setCel: 1
					setCycle: 0
					posn: 48 105
					stopUpd:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDinoFlys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(slater setPri: 3 stopUpd:)
				(= cycles 1)
			)
			(1
				(mySound number: 955 setLoop: -1 play: 127)
				(dinoPilot
					view: 1135
					loop: 0
					setCel: 0
					setPri: 5
					cycleSpeed: 9
					moveSpeed: 3
					setCycle: End self
				)
			)
			(2
				(dinoPilot
					setLoop: 1
					setCel: 0
					posn: 131 89
					setPri: 0
					setCycle: End self
					ignoreActors:
				)
			)
			(3
				(dinoPilot
					setLoop: 3
					setCel: 0
					posn: 66 63
					setCycle: Fwd
					setMotion: MoveTo -40 36 self
				)
			)
			(4
				(mySound fade: 0 10 30 1)
				(= ticks 25)
			)
			(5
				(mySound stop:)
				(= ticks 50)
			)
			(6
				(mySound number: 955 setLoop: -1 play: fade: 127 10 30 0)
				(= ticks 25)
			)
			(7
				(dinoPilot
					setLoop: 4
					moveSpeed: 0
					setPri: 4
					setMotion: MoveTo 340 23 self
				)
			)
			(8
				(mySound fade: 0 10 30 1)
				(= ticks 25)
			)
			(9
				(mySound stop:)
				(= ticks 50)
			)
			(10
				(mySound number: 955 setLoop: -1 play: fade: 127 10 30 0)
				(= ticks 25)
			)
			(11
				(dinoPilot
					posn: 340 23
					setLoop: 3
					moveSpeed: 6
					setPri: 4
					setMotion: MoveTo 319 53 self
				)
			)
			(12
				(dinoPilot
					setLoop: 2
					setCel: 0
					posn: 196 96
					setCycle: CT 1 1 self
				)
			)
			(13
				(mySound number: 988 loop: 1 play:)
				(my2Sound number: 948 loop: 1 play:)
				(dinoPilot setCel: 2 setCycle: CT 7 1 self)
			)
			(14
				(mySound stop:)
				(dinoPilot
					view: 1101
					loop: 0
					setCel: 5
					setPri: 6
					posn: 196 97
					stopUpd:
				)
				(slater setPri: -1 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRocketShipFlys of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if
			(and
				(mod (++ local9) 2)
				(or (== state 2) (== state 3) (== state 1))
			)
			(= temp0 (Random 146 148))
			(= temp1 (Random 107 109))
			(rocketShip posn: temp0 temp1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(rocketShip
					view: 1140
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setStep: 3 10
					setCycle: CT 1 1 self
				)
			)
			(2
				(my2Sound number: 984 setLoop: -1 play:)
				(rocketShip setCycle: CT 2 1 self)
			)
			(3
				(= ticks 150)
			)
			(4
				(my2Sound number: 944 setLoop: -1 play:)
				(rocketShip setCycle: CT 11 1 self)
			)
			(5
				(rocketShip
					setLoop: 0
					setCel: 12
					posn: 153 42
					setStep: 3 15
					setMotion: MoveTo 147 -17 self
					ignoreHorizon:
					ignoreActors:
				)
			)
			(6
				(my2Sound stop:)
				(= ticks 100)
			)
			(7
				(rocketShip setLoop: 1 setCel: 0 posn: 147 0)
				(= ticks 2)
			)
			(8
				(my2Sound number: 1001 setLoop: 1 play:)
				(rocketShip
					setStep: -1
					setCycle: Fwd
					setStep: 3 8
					setMotion: MoveTo 147 89 self
				)
			)
			(9
				(rocketShip
					setLoop: 2
					setCel: 0
					posn: 147 108
					setCycle: CT 1 1 self
				)
			)
			(10
				(my2Sound number: 941 setLoop: 1 play: self)
			)
			(11
				(mySound number: 955 setLoop: 1 play:)
				(rocketShip cycleSpeed: 18 setCycle: CT 8 1 self)
			)
			(12
				(mySound stop:)
				(my2Sound stop:)
				(rocketShip
					view: 1101
					setLoop: 0
					setCel: 6
					posn: 147 108
					setCycle: 0
					cycleSpeed: 6
					moveSpeed: 6
					stopUpd:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurtles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(turtles view: 1145 loop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(2
				(mySound number: 994 setLoop: 1 play:)
				(turtles setCycle: CT 5 1 self)
			)
			(3
				(turtles setCycle: CT 7 1)
				(my2Sound number: 941 setLoop: 1 play: self)
			)
			(4
				(= ticks 25)
			)
			(5
				(turtles setCycle: CT 11 1 self)
			)
			(6
				(my2Sound number: 1027 setLoop: 1 play:)
				(= ticks 50)
			)
			(7
				(turtles setCycle: CT 12 1 self)
			)
			(8
				(mySound number: 1035 setLoop: -1 play:)
				(turtles setCycle: End self)
			)
			(9
				(turtles loop: 1 setCel: 0 setCycle: CT 1 1 self)
			)
			(10
				(mySound number: 1033 setLoop: 1 play:)
				(turtles setCycle: CycleBet 2 5 3 self)
			)
			(11
				(mySound number: 1027 setLoop: 1 play:)
				(turtles setCycle: CT 7 1 self)
			)
			(12
				(my2Sound number: 1012 setLoop: 1 play:)
				(turtles setCycle: CT 9 1 self)
			)
			(13
				(= ticks 50)
			)
			(14
				(mySound number: 994 setLoop: 1 play:)
				(turtles setCycle: CT 14 1 self)
			)
			(15
				(turtles view: 1101 loop: 1 setCel: 2 stopUpd:)
				(= ticks 6)
			)
			(16
				(mySound number: 941 play: setLoop: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBaseballDino of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (>= (baseball x:) 140))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(baseball x: 56 y: 26 setStep: 9 9 setPri: 15 stopUpd:)
				(= cycles 1)
			)
			(1
				(baseballDino
					view: 1150
					setLoop: 0
					setCel: 0
					setPri: 6
					posn: 177 142
					moveSpeed: 3
					setMotion: MoveTo 177 122 self
				)
			)
			(2
				(mySound number: 991 setLoop: 1 play:)
				(baseballDino setMotion: MoveTo 177 108 self)
			)
			(3
				(baseball setLoop: 1 setCel: 0 setMotion: JumpTo 150 63 init:)
				(baseballDino setCel: 0 setCycle: CT 3 1)
			)
			(4
				(baseball dispose:)
				(baseballDino setCel: 4)
				(= ticks 10)
			)
			(5
				(my2Sound number: 947 setLoop: 1 play: self)
				(baseballDino setCel: 5)
			)
			(6
				(baseballDino setCel: 5 setCycle: End self)
			)
			(7
				(mySound number: 1036 setLoop: 1 play:)
				(baseballDino loop: 0 setCel: 0 setMotion: MoveTo 177 145 self)
			)
			(8
				(baseballDino
					view: 1101
					loop: 1
					setCel: 3
					posn: 177 110
					setPri: 8
					stopUpd:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 166
		nsLeft 38
		nsBottom 178
		nsRight 87
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1124 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 0 posn: 63 176 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 166
		nsLeft 87
		nsBottom 178
		nsRight 99
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1093 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 1 posn: 92 176 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 166
		nsLeft 99
		nsBottom 178
		nsRight 136
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1130 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 2 posn: 117 176 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 166
		nsLeft 136
		nsBottom 178
		nsRight 153
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1088 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 3 posn: 144 176 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 166
		nsLeft 153
		nsBottom 178
		nsRight 201
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1056 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 4 posn: 174 176 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 166
		nsLeft 201
		nsBottom 178
		nsRight 242
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1118 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 5 posn: 220 176 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 166
		nsLeft 242
		nsBottom 178
		nsRight 260
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1125 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 6 posn: 250 176 init:)
	)
)

(instance aWord7 of InterFeature
	(properties
		nsTop 166
		nsLeft 260
		nsBottom 178
		nsRight 293
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1131 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 7 posn: 273 176 init:)
	)
)

(instance aWord8 of InterFeature
	(properties
		nsTop 178
		nsLeft 56
		nsBottom 188
		nsRight 101
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1054 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 8 posn: 79 187 init:)
	)
)

(instance aWord9 of InterFeature
	(properties
		nsTop 178
		nsLeft 101
		nsBottom 188
		nsRight 150
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1119 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 9 posn: 124 187 init:)
	)
)

(instance aWord10 of InterFeature
	(properties
		nsTop 178
		nsLeft 150
		nsBottom 188
		nsRight 186
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1126 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 10 posn: 166 187 init:)
	)
)

(instance aWord11 of InterFeature
	(properties
		nsTop 178
		nsLeft 186
		nsBottom 188
		nsRight 225
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1126 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 10 posn: 204 187 init:)
	)
)

(instance aWord12 of InterFeature
	(properties
		nsTop 178
		nsLeft 225
		nsBottom 188
		nsRight 263
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1126 setLoop: 1 play: rm11)
		(theView view: 1160 setLoop: 10 posn: 242 187 init:)
	)
)

(instance capFea of InterFeature
	(properties
		nsTop 87
		nsLeft 179
		nsBottom 106
		nsRight 211
	)

	(method (doVerb)
		(gCurRoom setScript: sBaseballDino)
	)
)

(instance rockFea of InterFeature
	(properties
		nsTop 138
		nsLeft 191
		nsBottom 153
		nsRight 238
	)

	(method (doVerb)
		(if (== local1 1)
			(gCurRoom setScript: sDinoRockLeft)
		else
			(gCurRoom setScript: sDinoRockRight)
		)
	)
)

(instance rock of InterView
	(properties
		x 32
		y 175
		view 1165
		loop 3
		priority 15
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: rockScript)
	)
)

(instance cloud of InterProp
	(properties
		x 201
		y 37
		view 1101
		cel 3
		signal 16400
	)

	(method (doVerb)
		(= local2 cloud)
		(gCurRoom setScript: sCloud)
	)
)

(instance cloud2 of InterProp
	(properties
		x 269
		y 71
		view 1101
		cel 3
		signal 16400
	)

	(method (doVerb)
		(= local2 cloud2)
		(gCurRoom setScript: sCloud)
	)
)

(instance cloud3 of InterProp
	(properties
		x 50
		y 51
		view 1101
		cel 3
		signal 16400
	)

	(method (doVerb)
		(= local2 cloud3)
		(gCurRoom setScript: sCloud)
	)
)

(instance rockEyes of InterProp
	(properties
		x 75
		y 171
		view 1101
		cel 4
		signal 16384
	)

	(method (doVerb)
		(gCurRoom setScript: sRockEyes)
	)
)

(instance charlie of InterProp
	(properties
		x 79
		y 110
		view 1101
		loop 1
		priority 1
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sTreeFalls)
	)
)

(instance turtles of InterProp
	(properties
		x 264
		y 108
		view 1101
		loop 1
		cel 2
		priority 9
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sTurtles)
	)
)

(instance theView of Prop
	(properties
		view 1101
		cel 1
		priority 15
		signal 16
	)
)

(instance theProp of Prop
	(properties
		view 1101
		cel 1
		priority 15
		signal 16
	)
)

(instance thirdProp of Prop
	(properties
		view 1101
		cel 1
		priority 15
		signal 16
	)
)

(instance door1 of InterProp
	(properties
		x 201
		y 151
		view 1101
		loop 2
		signal 20481
	)

	(method (doVerb)
		(if (== local1 1)
			(gCurRoom setScript: sDinoRockLeft)
		else
			(gCurRoom setScript: sDinoRockRight)
		)
	)
)

(instance door2 of InterProp
	(properties
		x 226
		y 152
		view 1101
		loop 2
		cel 1
		signal 20481
	)

	(method (doVerb)
		(if (== local1 1)
			(gCurRoom setScript: sDinoRockLeft)
		else
			(gCurRoom setScript: sDinoRockRight)
		)
	)
)

(instance balloonPineapple of InterActor
	(properties
		x 48
		y 105
		view 1101
		loop 1
		cel 1
		priority 1
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sBalloonPineapple)
	)
)

(instance baseball of Actor
	(properties
		x 177
		y 109
		view 1150
		loop 1
	)
)

(instance baseballDino of InterActor
	(properties
		x 177
		y 112
		view 1101
		loop 1
		cel 3
		priority 8
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sBaseballDino)
	)
)

(instance dinoPilot of InterActor
	(properties
		x 196
		y 97
		view 1101
		cel 5
		priority 6
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sDinoFlys)
	)
)

(instance rocketShip of InterActor
	(properties
		x 147
		y 108
		view 1101
		cel 6
		priority 6
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sRocketShipFlys)
	)
)

(instance suctionBushes of InterActor
	(properties
		x 73
		y 121
		view 1101
		cel 1
		priority 1
		signal 24592
	)

	(method (doVerb)
		(gCurRoom setScript: sSuctionBushes)
	)
)

(instance suctionBushes2 of InterActor
	(properties
		x 50
		y 121
		view 1101
		priority 1
		signal 24592
	)

	(method (doVerb)
		(gCurRoom setScript: sSuctionBushes)
	)
)

(instance slater of InterActor
	(properties
		x 184
		y 47
		view 1101
		cel 2
		priority 2
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sSlaterFalls)
	)
)

(instance dinoRock of Actor
	(properties
		x 208
		y 158
		view 1110
		signal 16384
	)
)

(instance droplet of Actor ; UNUSED
	(properties
		view 1115
		loop 2
		signal 16400
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

