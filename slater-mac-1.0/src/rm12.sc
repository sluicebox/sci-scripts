;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use OccasionalCycle)
(use CycleBet)
(use Feature)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm12 0
)

(local
	local0
	local1
	local2
	local3
	[local4 2]
	local6
	[local7 6] = [83 52 112 177 203 248]
	[local13 7] = [90 100 101 88 66 114 0]
)

(instance rm12 of Rm
	(properties
		picture 1200
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
	)

	(method (init)
		(= local3 0)
		(super init:)
		(gLongSong number: 150 setLoop: -1 play: 10 fade: 127 10 30 0)
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
		(lampFeat init:)
		(rock init:)
		(slater init: stopUpd:)
		(charlie init: stopUpd:)
		(slaterFeature init:)
		(charlieFeature init:)
		(hoseSnake init: stopUpd:)
		(hoseSnakeFea init:)
		(rockApart init: stopUpd:)
		(mallet init: stopUpd:)
		(dogHouse init: stopUpd:)
		(shovel init: stopUpd:)
		(bucket init: stopUpd:)
		(dumpTruck init: stopUpd:)
		(BBQ init: stopUpd:)
		(BBQarms init: stopUpd:)
		(crumblingWall init: stopUpd:)
		(wallFeat init:)
		(wallFeat2 init:)
		(sprinkler init: stopUpd:)
		(snakeWall init: stopUpd:)
		(snakeWall2 init: stopUpd:)
		(gCurRoom setScript: rockScript)
	)

	(method (doit)
		(super doit:)
		(if (and global120 (not local0) (not (gCurRoom script:)))
			(= local0 1)
			(= global120 0)
			(= global106 1)
			(gCurRoom newRoom: 801)
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (dispose)
		(if (lampScript client:)
			(PalVary pvUNINIT)
		)
		(gMouseDownHandler delete: lampScript)
		(mySound dispose:)
		(my2Sound dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade: 0 10 30 1)
		(super newRoom: newRoomNumber)
	)
)

(instance blinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eyeBlink init:)
				(blinkCode doit:)
				(= ticks 10)
			)
			(1
				(eyeBlink dispose:)
				(= state -1)
				(= ticks (Random 10 150))
			)
		)
	)
)

(instance lampScript of Script
	(properties)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(cond
			((> gMouseY 150)
				(super handleEvent: event)
			)
			((== state 2)
				(event claimed: 1)
				(blinkScript dispose:)
				(eyeBlink dispose:)
				(self cue:)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMouseDownHandler addToFront: lampScript)
				(= ticks 75)
			)
			(1
				(gLongSong fade: 0 10 10 1)
				(mySound number: 1163 play: 0 setLoop: 1 fade: 127 10 10)
				(PalVary pvINIT 1201 2)
				(= seconds 3)
			)
			(2
				(self setScript: blinkScript)
				(gGame handsOn:)
			)
			(3
				(gGame handsOff:)
				(= cycles 50)
			)
			(4
				(mySound fade: 0 10 10 1)
				(PalVary pvREVERSE 2)
				(= seconds 3)
			)
			(5
				(gLongSong play: 127)
				(gGame handsOn:)
				(gMouseDownHandler delete: lampScript)
				(self dispose:)
			)
		)
	)
)

(instance sFrightened of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 1163 setLoop: 1 play: self)
				(= ticks 25)
			)
			(1
				(my2Sound number: 991 setLoop: 1 play: self)
				(slater view: 1230 loop: 0 setCel: 1 posn: 135 126)
			)
			(2)
			(3
				(mySound number: 1163 setLoop: 1 play:)
				(= ticks 25)
			)
			(4
				(slater setCel: 1 setCycle: CT 5 1 self)
			)
			(5
				(my2Sound number: 1036 setLoop: 1 play:)
				(slater setCel: 5 setCycle: CT 8 1 self)
			)
			(6
				(my2Sound number: 1003 setLoop: 1 play:)
				(slater setCel: 8 setCycle: End self)
			)
			(7
				(my2Sound number: 1030 setLoop: 1 play:)
				(slater setLoop: 1 setCel: 0 setCycle: End self)
			)
			(8
				(my2Sound number: 1030 setLoop: 1 play:)
				(slater setCel: 0 setCycle: End self)
			)
			(9
				(my2Sound number: 1030 play:)
				(slater setCel: 0 setCycle: End self)
			)
			(10
				(slater setCycle: CycleBet 0 1 -1)
				(= ticks 50)
			)
			(11
				(slater setMotion: MoveTo (slater x:) (+ (slater y:) 37) self)
				(mySound number: 1163 setLoop: 1 play:)
			)
			(12
				(= ticks 75)
			)
			(13
				(slater
					setLoop: 2
					setCel: 1
					setCycle: 0
					setMotion: MoveTo (slater x:) (- (slater y:) 33) self
				)
			)
			(14
				(= ticks 100)
			)
			(15
				(my2Sound number: 951 setLoop: 1 play:)
				(slater
					setLoop: 2
					setCel: 1
					y: (- (slater y:) 4)
					setCycle: End self
				)
			)
			(16
				(slater view: 1200 setLoop: 1 setCel: 1 posn: 132 81 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSuckThumb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(mySound number: 1163 setLoop: 1 play:)
				(= ticks 50)
			)
			(2
				(charlie
					view: 1250
					posn: 177 88
					loop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(my3Sound number: 991 setLoop: 1 play:)
			)
			(3
				(my2Sound number: 928 setLoop: 1 play:)
				(charlie loop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(my2Sound number: 1038 setLoop: -1 play:)
				(charlie cycleSpeed: 6 setCycle: CycleBet 0 1 -1)
				(= ticks 200)
			)
			(5
				(my2Sound number: 928 setLoop: 1 play:)
				(charlie loop: 0 setCel: 4 setCycle: Beg self)
			)
			(6
				(my2Sound stop:)
				(charlie view: 1200 loop: 0 setCel: 1 posn: 198 77 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTheyAwake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mySound number: 1163 setLoop: 1 play: self)
				(= ticks 25)
			)
			(1
				(slater setCycle: End)
				(charlie setCycle: End)
			)
			(2
				(slater stopUpd:)
				(charlie stopUpd:)
				(= local1 1)
				(self dispose:)
			)
		)
	)
)

(instance sSlither of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(mySound number: 942 setLoop: 1 play:)
				(hoseSnake view: 1205 loop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(my2Sound number: 1041 setLoop: 1 play: self)
				(hoseSnake loop: 1 setCel: 0 setCycle: CycleBet 0 4 -1)
			)
			(3
				(mySound number: 942 setLoop: 1 play:)
				(hoseSnake loop: 0 setCel: 7 setCycle: Beg self)
			)
			(4
				(mySound stop:)
				(hoseSnake view: 1205 loop: 0 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHitRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 111 play:)
				(= cycles 1)
			)
			(1
				(mySound number: 928 setLoop: 1 play:)
				(mallet view: 1210 loop: 1 cel: 0 forceUpd: setCycle: End self)
			)
			(2
				(mallet loop: 2 cel: 0 setMotion: JumpTo 90 162 self)
			)
			(3
				(mallet
					setPri: (- (rockApart priority:) 1)
					setCycle: CT 6 1 self
				)
			)
			(4
				(rockApart hide:)
				(my2Sound number: 947 setLoop: 1 play:)
				(mallet cel: 6 setCycle: End self)
			)
			(5
				(mySound number: 985 setLoop: 1 play:)
				(mallet
					loop: 1
					cel: 5
					setPri: -1
					setMotion: JumpTo 270 147 mallet
					setCycle: Beg
				)
				(rockApart
					show:
					view: 1210
					loop: 3
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(6
				(my2Sound number: 941 setLoop: 1 play:)
				(rockApart cel: 5 setCycle: CT 12 1 self)
			)
			(7
				(= ticks 100)
			)
			(8
				(mySound number: 991 setLoop: 1 play:)
				(rockApart cel: 12 setCycle: CT 14 1 self)
			)
			(9
				(my2Sound number: 963 setLoop: 1 play:)
				(rockApart cel: 14 setCycle: End self)
			)
			(10
				(rockApart view: 1210 loop: 0 cel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDogHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(mySound number: 1164 setLoop: 1 play:)
				(dogHouse view: 1215 loop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(dogHouse setCycle: CycleBet 1 3 -1)
				(= ticks 200)
			)
			(3
				(dogHouse setCel: 3 setCycle: Beg self)
			)
			(4
				(mySound stop:)
				(dogHouse view: 1215 loop: 0 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPeekOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(my2Sound number: 928 setLoop: 1 play:)
				(dinoFence view: 1220 init: loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(my2Sound stop:)
				(= ticks 100)
			)
			(3
				(mySound number: 928 setLoop: 1 play:)
				(dinoFence setCel: 2 setCycle: Beg self)
				(= ticks 50)
			)
			(4
				(dinoFence view: 1220 loop: 0 setCel: 0 dispose:)
			)
			(5
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPeekOver2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(my2Sound number: 928 setLoop: 1 play:)
				(dinoFence2 view: 1220 init: loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(my2Sound stop:)
				(= ticks 100)
			)
			(3
				(mySound number: 928 setLoop: 1 play:)
				(dinoFence2 setCel: 2 setCycle: Beg self)
				(= ticks 50)
			)
			(4
				(dinoFence2 view: 1220 loop: 1 setCel: 0 dispose:)
			)
			(5
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShovelInBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mySound number: 994 setLoop: 1 play:)
				(shovel
					view: 1225
					loop: 0
					setCel: 0
					setPri: 8
					setCycle: CT 6 1 self
				)
			)
			(1
				(my2Sound number: 941 setLoop: 1 play:)
				(shovel setCel: 6 setPri: 5 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sShovel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 130 play:)
				(= cycles 1)
			)
			(1
				(self setScript: sShovelInBucket self)
			)
			(2
				(= ticks 10)
			)
			(3
				(self setScript: sShovelInBucket self)
			)
			(4
				(= ticks 10)
			)
			(5
				(self setScript: sShovelInBucket self)
			)
			(6
				(bucket
					setLoop: 1
					setCel: 0
					setPri: 7
					setMotion: JumpTo 86 78 self
				)
			)
			(7
				(mySound number: 920 setLoop: 1 play:)
				(bucket setCycle: End self)
			)
			(8
				(my2Sound number: 909 setLoop: 1 play:)
				(tower1 init: stopUpd:)
				(bucket
					setLoop: 1
					setMotion: MoveTo (bucket x:) (- (bucket y:) 10) self
				)
			)
			(9
				(bucket setCel: 4 setCycle: Beg self)
			)
			(10
				(bucket setLoop: 1 setCel: 0 setMotion: JumpTo 62 89 self)
			)
			(11
				(shovel setPri: 8)
				(self setScript: sShovelInBucket self)
			)
			(12
				(= ticks 10)
			)
			(13
				(self setScript: sShovelInBucket self)
			)
			(14
				(= ticks 10)
			)
			(15
				(self setScript: sShovelInBucket self)
			)
			(16
				(shovel setPri: 5)
				(bucket setLoop: 1 setCel: 0 setMotion: JumpTo 89 74 self)
			)
			(17
				(mySound number: 920 setLoop: 1 play:)
				(bucket setCycle: End self)
			)
			(18
				(tower2 init: stopUpd:)
				(bucket
					setLoop: 1
					setPri: 7
					setMotion: MoveTo (bucket x:) (- (bucket y:) 15) self
				)
				(= cycles 2)
			)
			(19
				(my2Sound number: 909 setLoop: 1 play:)
			)
			(20
				(bucket setCel: 4 setPri: -1 setCycle: Beg self)
			)
			(21
				(bucket setLoop: 1 setCel: 0 setMotion: JumpTo 62 89 self)
			)
			(22
				(shovel setPri: 8)
				(self setScript: sShovelInBucket self)
			)
			(23
				(= ticks 10)
			)
			(24
				(self setScript: sShovelInBucket self)
			)
			(25
				(= ticks 10)
			)
			(26
				(self setScript: sShovelInBucket self)
			)
			(27
				(shovel setPri: 5)
				(bucket
					setLoop: 1
					setCel: 0
					setPri: 7
					setMotion: JumpTo 89 65 self
				)
			)
			(28
				(mySound number: 920 setLoop: 1 play:)
				(bucket setCycle: End self)
			)
			(29
				(tower3 init: setPri: 5 stopUpd:)
				(bucket
					setLoop: 1
					setPri: 7
					setMotion: MoveTo (bucket x:) (- (bucket y:) 15) self
				)
				(= cycles 2)
			)
			(30
				(my2Sound number: 909 setLoop: 1 play:)
			)
			(31
				(bucket setCycle: Beg self)
			)
			(32
				(bucket setMotion: JumpTo 62 89 self)
			)
			(33
				(bucket setPri: -1)
				(my2Sound number: 1033 setLoop: 1 play:)
				(castleFlag init: setCycle: Fwd)
				(= ticks 30)
			)
			(34
				(mySound number: 919 setLoop: -1 play:)
				(rubble init: setCycle: Beg self)
			)
			(35
				(castleFlag dispose:)
				(tower1 dispose:)
				(tower2 dispose:)
				(tower3 dispose:)
				(rubble setCycle: End self)
			)
			(36
				(mySound stop:)
				(rubble dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTruckDumps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dumpTruck setLoop: 0 setCel: 0 setMotion: MoveTo 207 146 self)
				(my2Sound number: 1162 setLoop: -1 play:)
			)
			(1
				(my2Sound stop:)
				(dumpTruck
					view: 1235
					loop: 0
					setCel: 0
					setPri: 11
					setCycle: End self
				)
			)
			(2
				(my2Sound number: 963 setLoop: 1 play:)
				(dumpDino setCel: 0 init: setCycle: CT 5 1 self)
			)
			(3
				(mySound number: 946 setLoop: 1 play:)
				(dumpTruck loop: 0 setCel: 4 setCycle: Beg self)
			)
			(4
				(mySound number: 955 setLoop: 1 play:)
				(dumpTruck setLoop: 0 setMotion: MoveTo 168 157)
				(= ticks 20)
			)
			(5
				(dumpDino setCel: 5 setPri: 12 setCycle: End self)
			)
			(6
				(my2Sound number: 991 setLoop: 1 play: self)
				(dumpDino setPri: 8 dispose:)
			)
			(7
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNecking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(neckingDino init: setCel: 0 stopUpd:)
				(= cycles 1)
			)
			(2
				(mySound number: 986 setLoop: 1 play:)
				(crumblingWall view: 1240 loop: 0 setCel: 0 setCycle: End self)
				(= ticks 25)
			)
			(3
				(my2Sound number: 927 setLoop: 1 play: self)
			)
			(4
				(mySound stop:)
			)
			(5
				(my2Sound number: 927 setLoop: 1 play: self)
			)
			(6
				(neckingDino setCycle: End self)
			)
			(7
				(neckingDino setCycle: OccasionalCycle self -1 100 200)
				(= cycles 1)
			)
			(8
				(= local2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putWallUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 986 play:)
				(crumblingWall setCel: 4 setCycle: Beg self)
			)
			(1
				(mySound stop:)
				(neckingDino dispose:)
				(crumblingWall view: 1240 loop: 0 setCel: 0 stopUpd:)
				(= local2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sYawning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(BBQ view: 1245 loop: 0 setCel: 0 setCycle: CT 1 1 self)
				(BBQarms view: 1245 loop: 1 setCel: 0 setCycle: CT 1 1 self)
			)
			(2)
			(3
				(my3Sound number: 1158 setLoop: 1 play:)
				(BBQarms setCycle: End self)
				(BBQ setCycle: End self)
			)
			(4)
			(5
				(BBQ loop: 2 setCel: 0 setCycle: End self)
			)
			(6
				(my2Sound number: 956 play: self)
			)
			(7
				(BBQ setCel: 0 setCycle: End self)
			)
			(8
				(my2Sound number: 956 play:)
				(mySound number: 954 play:)
				(BBQarms setCel: 6 setCycle: Beg self)
				(BBQ loop: 0 setCel: 5 setCycle: Beg self)
			)
			(9)
			(10
				(my2Sound number: 963 play:)
				(BBQarms view: 1245 loop: 1 setCel: 0 stopUpd:)
				(BBQ view: 1245 loop: 0 setCel: 0 stopUpd:)
				(= cycles 1)
			)
			(11
				(BBQ loop: 3 setCel: 0 cycleSpeed: 6 setCycle: End self)
				(mySound number: 1165 setLoop: 1 play:)
			)
			(12
				(BBQ setCycle: Beg self)
				(if (== local6 2)
					(self cue:)
				else
					(-= state 2)
					(++ local6)
					(self cue:)
				)
			)
			(13
				(BBQ setCycle: 0 loop: 0 setCel: 0 stopUpd:)
				(= local6 0)
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSnakeWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(mySound number: 1036 setLoop: 1 play:)
				(if register
					(snakeWall2
						view: 1260
						loop: 1
						setCel: 0
						setCycle: CT 4 1 self
					)
				else
					(snakeWall
						view: 1260
						loop: 0
						setCel: 0
						setCycle: CT 4 1 self
					)
				)
			)
			(2
				(my2Sound number: 952 setLoop: 1 play: self)
			)
			(3
				(mySound number: 951 setLoop: 1 play:)
				(if register
					(snakeWall2 setCycle: End self)
				else
					(snakeWall setCycle: End self)
				)
			)
			(4
				(my2Sound number: 1020 setLoop: 1 play:)
				(if register
					(snakeWall2 loop: 3 setCel: 0 setCycle: CT 8 1 self)
				else
					(snakeWall loop: 2 setCel: 0 setCycle: CT 8 1 self)
				)
			)
			(5
				(my2Sound stop:)
				(if register
					(snakeWall2 setCel: 8 setCycle: CT 13 1 self)
				else
					(snakeWall setCel: 8 setCycle: CT 13 1 self)
				)
			)
			(6
				(if register
					(snakeWall2 setCycle: End self)
				else
					(snakeWall setCycle: End self)
				)
				(mySound number: 991 setLoop: 1 play:)
			)
			(7
				(if register
					(snakeWall2 loop: 5 setCel: 0 setCycle: End self)
				else
					(snakeWall loop: 4 setCel: 0 setCycle: End self)
				)
			)
			(8
				(mySound number: 924 setLoop: 1 play:)
				(if register
					(snakeWall2 view: 1260 loop: 1 setCel: 0 stopUpd:)
				else
					(snakeWall view: 1260 loop: 0 setCel: 0 stopUpd:)
				)
				(= cycles 2)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sprinklerOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 916 loop: -1 play: 127)
				(sprinkler setLoop: 1 setCycle: Fwd)
				(water init: setCycle: Fwd)
				(= ticks 25)
			)
			(1
				(slater
					view: 1280
					loop: 0
					setCel: 0
					x: 139
					y: 80
					setCycle: CT 3 1 self
				)
			)
			(2
				(slater setCycle: End self)
				(my2Sound number: 974 play: 70 setLoop: 1)
			)
			(3
				(= ticks 75)
			)
			(4
				(water dispose:)
				(sprinkler setCel: 0 setLoop: 3 setCycle: 0 stopUpd:)
				(mySound stop:)
				(= ticks 10)
			)
			(5
				(slater setCycle: Beg self)
				(my2Sound number: 930 play: 70 setLoop: 1)
			)
			(6
				(slater view: 1200 x: 132 y: 81 setLoop: 1 setCel: 1 stopUpd:)
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
				(theView view: 1265 setLoop: 0 setCel: 1 posn: 106 176 init:)
				(mySound number: 1053 setLoop: 1 play:)
				(= ticks 41)
			)
			(2
				(gGame handsOff:)
				(theProp view: 1265 setLoop: 1 setCel: 1 posn: 165 186 init:)
				(= ticks 73)
			)
			(3
				(theView view: 1265 setLoop: 2 setCel: 1 posn: 97 188 init:)
				(= ticks 80)
			)
			(4
				(gGame handsOff:)
				(theProp view: 1265 setLoop: 3 setCel: 1 posn: 198 188 init:)
				(= ticks 89)
			)
			(5
				(theView hide: dispose:)
				(= ticks 40)
			)
			(6
				(theProp hide: dispose:)
				(rock setCel: 0 stopUpd:)
				(= ticks 39)
			)
			(7
				(if (not local1)
					(self setScript: sTheyAwake self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 166
		nsLeft 45
		nsBottom 178
		nsRight 83
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1123 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 0 posn: 66 176 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 166
		nsLeft 83
		nsBottom 178
		nsRight 115
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1132 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 1 posn: 98 176 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 166
		nsLeft 115
		nsBottom 178
		nsRight 163
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1120 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 2 posn: 139 176 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 166
		nsLeft 163
		nsBottom 178
		nsRight 178
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1127 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 3 posn: 169 176 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 166
		nsLeft 178
		nsBottom 178
		nsRight 207
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1102 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 4 posn: 192 176 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 166
		nsLeft 207
		nsBottom 178
		nsRight 246
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1133 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 5 posn: 225 176 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 166
		nsLeft 246
		nsBottom 178
		nsRight 283
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1121 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 6 posn: 262 176 init:)
	)
)

(instance aWord7 of InterFeature
	(properties
		nsTop 179
		nsLeft 43
		nsBottom 188
		nsRight 71
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1128 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 7 posn: 58 188 init:)
	)
)

(instance aWord8 of InterFeature
	(properties
		nsTop 179
		nsLeft 71
		nsBottom 188
		nsRight 125
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1060 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 8 posn: 97 188 init:)
	)
)

(instance aWord9 of InterFeature
	(properties
		nsTop 179
		nsLeft 125
		nsBottom 188
		nsRight 144
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1134 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 9 posn: 134 188 init:)
	)
)

(instance aWord10 of InterFeature
	(properties
		nsTop 179
		nsLeft 144
		nsBottom 188
		nsRight 178
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1122 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 10 posn: 158 188 init:)
	)
)

(instance aWord11 of InterFeature
	(properties
		nsTop 179
		nsLeft 178
		nsBottom 188
		nsRight 209
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1129 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 11 posn: 192 188 init:)
	)
)

(instance aWord12 of InterFeature
	(properties
		nsTop 179
		nsLeft 209
		nsBottom 188
		nsRight 242
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1126 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 12 posn: 224 188 init:)
	)
)

(instance aWord13 of InterFeature
	(properties
		nsTop 179
		nsLeft 242
		nsBottom 188
		nsRight 280
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1135 setLoop: 1 play: rm12)
		(theView view: 1270 setLoop: 13 posn: 259 188 init:)
	)
)

(instance lampFeat of InterFeature
	(properties
		x 165
		y 73
		nsTop 56
		nsLeft 157
		nsBottom 90
		nsRight 173
	)

	(method (doVerb)
		(if (not (gCurRoom script:))
			(gCurRoom setScript: lampScript)
		)
	)
)

(instance wallFeat of InterFeature
	(properties
		x 107
		y 7
		nsTop 1
		nsLeft 1
		nsBottom 20
		nsRight 127
	)

	(method (doVerb)
		(gCurRoom setScript: sPeekOver)
	)
)

(instance wallFeat2 of InterFeature
	(properties
		x 227
		y 8
		nsLeft 211
		nsBottom 20
		nsRight 319
	)

	(method (doVerb)
		(gCurRoom setScript: sPeekOver2)
	)
)

(instance slaterFeature of InterFeature
	(properties
		x 134
		y 93
		nsTop 69
		nsLeft 114
		nsBottom 118
		nsRight 154
	)

	(method (doVerb)
		(gCurRoom setScript: sFrightened)
	)
)

(instance charlieFeature of InterFeature
	(properties
		x 209
		y 93
		nsTop 71
		nsLeft 179
		nsBottom 116
		nsRight 229
	)

	(method (doVerb)
		(gCurRoom setScript: sSuckThumb)
	)
)

(instance rock of InterView
	(properties
		x 40
		y 175
		view 1275
		loop 3
		priority 15
		signal 17
	)

	(method (doVerb)
		(if (gCurRoom script:)
			((gCurRoom script:) setScript: rockScript)
		else
			(gCurRoom setScript: rockScript)
		)
	)
)

(instance slater of InterActor
	(properties
		x 132
		y 81
		view 1200
		loop 1
		priority 4
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sFrightened)
	)
)

(instance charlie of InterProp
	(properties
		x 198
		y 77
		view 1200
		priority 2
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sSuckThumb)
	)
)

(instance sprinkler of InterProp
	(properties
		x 84
		y 122
		view 1280
		loop 3
	)

	(method (doVerb)
		(gCurRoom setScript: sprinklerOn)
	)
)

(instance water of Prop
	(properties
		x 41
		y 40
		view 1280
		loop 2
		priority 14
		signal 16400
	)
)

(instance hoseSnake of InterProp
	(properties
		x 32
		y 110
		view 1205
		signal 16384
	)

	(method (doVerb)
		(gCurRoom setScript: sSlither)
	)
)

(instance hoseSnakeFea of Feature
	(properties
		nsTop 102
		nsLeft 68
		nsBottom 126
		nsRight 99
	)

	(method (doVerb)
		(gCurRoom setScript: sSlither)
	)
)

(instance rockApart of InterProp
	(properties
		x 91
		y 163
		view 1210
		signal 16384
	)

	(method (doVerb)
		(gCurRoom setScript: sHitRock)
	)
)

(instance mallet of InterActor
	(properties
		x 270
		y 147
		view 1210
		loop 1
		signal 16384
	)

	(method (cue)
		(super cue:)
		(self view: 1210 loop: 1 cel: 0 forceUpd: stopUpd:)
	)

	(method (doVerb)
		(gCurRoom setScript: sHitRock)
	)
)

(instance dogHouse of InterProp
	(properties
		x 108
		y 48
		view 1215
		priority 2
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sDogHouse)
	)
)

(instance dinoFence of InterProp
	(properties
		x 104
		y 14
		view 1220
		priority 2
		signal 16400
	)
)

(instance dinoFence2 of InterProp
	(properties
		x 242
		y 15
		view 1220
		loop 1
		priority 2
		signal 16400
	)
)

(instance shovel of InterProp
	(properties
		x 61
		y 85
		view 1225
		priority 5
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sShovel)
	)
)

(instance bucket of InterActor
	(properties
		x 62
		y 89
		view 1225
		loop 1
		signal 16384
	)

	(method (doVerb)
		(gCurRoom setScript: sShovel)
	)
)

(instance tower1 of View
	(properties
		x 87
		y 83
		view 1225
		loop 2
		signal 16384
	)
)

(instance tower2 of View
	(properties
		x 88
		y 74
		view 1225
		loop 2
		signal 16384
	)
)

(instance tower3 of View
	(properties
		x 89
		y 68
		view 1225
		loop 2
		signal 16384
	)
)

(instance eyeBlink of View
	(properties
		view 1201
		signal 16384
	)
)

(instance castleFlag of Prop
	(properties
		x 69
		y 82
		view 1225
		loop 3
		cel 1
		signal 16384
	)
)

(instance dumpTruck of InterActor
	(properties
		x 168
		y 157
		view 1235
		priority 9
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sTruckDumps)
	)
)

(instance dumpDino of Prop
	(properties
		x 207
		y 146
		view 1235
		loop 1
		cel 10
		priority 8
		signal 16400
	)
)

(instance crumblingWall of InterProp
	(properties
		x 129
		y 37
		view 1240
		priority 4
		signal 16400
	)

	(method (doVerb)
		(if local2
			(gCurRoom setScript: putWallUp)
		else
			(gCurRoom setScript: sNecking)
		)
	)
)

(instance neckingDino of Prop
	(properties
		x 156
		y 29
		view 1240
		loop 1
		signal 16384
	)
)

(instance BBQ of InterProp
	(properties
		x 257
		y 48
		view 1245
		priority 2
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sYawning)
	)
)

(instance BBQarms of Prop
	(properties
		x 262
		y 48
		view 1245
		loop 1
		priority 2
		signal 16400
	)
)

(instance rubble of Prop
	(properties
		x 73
		y 87
		view 1225
		loop 4
		cel 4
		priority 14
		signal 16400
	)
)

(instance snakeWall of InterProp
	(properties
		x 80
		y 65
		view 1260
		priority 2
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sSnakeWall 0 0)
	)
)

(instance snakeWall2 of InterProp
	(properties
		x 222
		y 59
		view 1260
		loop 1
		priority 2
		signal 16400
	)

	(method (doVerb)
		(gCurRoom setScript: sSnakeWall 0 1)
	)
)

(instance theView of Prop
	(properties
		view 170
		cel 1
		priority 15
		signal 16400
	)
)

(instance theProp of Prop
	(properties
		view 165
		cel 1
		priority 15
		signal 16400
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

(instance blinkCode of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (Random 0 5))
		(eyeBlink posn: [local7 temp0] [local13 temp0])
	)
)

