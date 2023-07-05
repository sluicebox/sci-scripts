;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use DText)
(use Str)
(use Array)
(use Inset)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use StopWalk)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm260 0
	Singent 1
)

(local
	local0
	[local1 6]
	[local7 2]
	local9 = 1
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18 = 6
	local19 = 1
	local20
	local21
	local22
	local23
	local24
	local25
	local26
)

(procedure (localproc_0)
	(gEgo put: 92) ; Roger_ID
	(gEgo put: 27) ; Datacorder
	(gEgo put: 13) ; Buckazoids
	(gEgo put: 110) ; Whisk_Broom
	(gEgo put: 18) ; Cheat_Sheet
	(gEgo put: 28) ; Dead_Fish
	(gEgo put: 59) ; Hotel_Keycard
)

(procedure (localproc_1 param1 param2 param3)
	(Message msgGET 260 param1 0 0 1 (local11 data:))
	(= local10 (IntArray with: 0 0 0 0))
	(Text 0 (local10 data:) (local11 data:) 265 170)
	((= [local1 param2] (DText new:))
		text: (KString 8 (local11 data:)) ; StrDup
		fore: (if (== param2 local9) 255 else 0)
		font: 265
		mode: 1
		x: (- 154 (/ (local10 at: 2) 2))
		y: param3
		setPri: 220
		setSize: 170
		init:
	)
)

(procedure (localproc_2 param1)
	([local1 local9] fore: 0 draw:)
	(cond
		((== param1 1)
			(if (== local9 1)
				(= local9 5)
			else
				(-- local9)
			)
		)
		((== local9 5)
			(= local9 1)
		)
		(else
			(++ local9)
		)
	)
	([local1 local9] fore: 255 draw:)
)

(procedure (localproc_3)
	(for ((= local0 0)) (< local0 6) ((++ local0))
		(if [local1 local0]
			([local1 local0] dispose:)
			(= [local1 local0] 0)
		)
	)
)

(procedure (localproc_4)
	(for ((= local0 0)) (< local0 2) ((++ local0))
		(if [local7 local0]
			([local7 local0] dispose:)
			(= [local7 local0] 0)
		)
	)
)

(procedure (localproc_5 &tmp temp0)
	(= local10 (IntArray with: 0 0 0 0))
	(= temp0
		(switch local9
			(1 45)
			(2 46)
			(3 39)
			(4 48)
			(5 49)
		)
	)
	(Message msgGET 260 temp0 0 0 1 (local11 data:))
	(Text 0 (local10 data:) (local11 data:) 265 114)
	((= [local7 0] (DText new:))
		text: (KString 8 (local11 data:)) ; StrDup
		fore: 0
		font: 265
		x: (- 154 (/ (local10 at: 2) 2))
		y: 17
		setPri: 220
		setSize: 114
		init:
	)
	(Message msgGET 260 temp0 0 0 2 (local11 data:))
	(Text 0 (local10 data:) (local11 data:) 265 114)
	((= [local7 1] (DText new:))
		text: (KString 8 (local11 data:)) ; StrDup
		fore: 0
		font: 265
		x: 99
		y: 25
		setPri: 100
		setSize: 114
		init:
	)
)

(instance rm260 of SQRoom
	(properties
		noun 1
		picture 260
	)

	(method (init)
		(if (== gPrevRoomNum 24) ; whereTo
			(SetFlag 410)
			(SetFlag 54)
		)
		(if (IsFlag 54)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 117 106 117 108 127 108 124 115 114 119 45 125 14 118 14 105 54 105 54 99 7 99 7 135 295 135 294 126 236 119 237 108 257 104 231 99 219 116 190 114 188 106
						yourself:
					)
			)
			(Load rsVIEW 268)
		else
			(localproc_0)
			(gCurRoom
				addObstacle:
					(= local14
						((Polygon new:)
							type: PContainedAccess
							init: 57 127 289 127 289 126 57 126
							yourself:
						)
					)
			)
			(Load
				rsVIEW
				263
				226
				227
				2602
				265
				2603
				2650
				2600
				2671
				268
				264
				2651
				266
				2660
				2661
				267
				2670
			)
		)
		(Load 140 262 2601) ; WAVE
		(super init:)
		(if (!= gPrevRoomNum 270)
			(gGSound1 number: 260 flags: 1 loop: -1 play:)
		)
		(gGame handsOff:)
		(if (IsFlag 54)
			(gEgo normalize: 2 setScale: 0 posn: 20 100 init:)
		else
			(gEgo
				normalize:
				view: 2601
				loop: 0
				cel: 0
				setSpeed: 8
				setScale: 0
				posn: 243 126
				init:
			)
			(nigel init: setCycle: Fwd)
		)
		(tv init:)
		(rug init:)
		(lamp init:)
		(desk init:)
		(hoop init:)
		(pinup init:)
		(table init:)
		(sign1 init:)
		(beer1 init:)
		(beer2 init:)
		(beer3 init:)
		(beer4 init:)
		(teddy init:)
		(noSign init:)
		(duckie init:)
		(poster1 init:)
		(poster2 init:)
		(poster3 init:)
		(twoHeader init:)
		(blowUpDoll init:)
		(rings init:)
		(tvScreen init: setCycle: Fwd setScript: sRandomTvScreen)
		(sporeSign init: setCycle: Fwd)
		(box init: approachVerbs: 4) ; Do
		(door init: approachVerbs: 4) ; Do
		(books init: approachVerbs: 4) ; Do
		(cdroms init: approachVerbs: 4) ; Do
		(stool init: approachVerbs: 4) ; Do
		(singent init: approachVerbs: 4) ; Do
		(doorControls init: approachVerbs: 87 4) ; Keyring, Do
		(computer init: approachVerbs: 4 89) ; Do, Holozine
		(if (not (gEgo has: 27)) ; Datacorder
			(theDatacorder init: approachVerbs: 4) ; Do
		)
		(if (IsFlag 200)
			(littleCdrom init: approachVerbs: 4) ; Do
		)
		(if (not (IsFlag 416))
			(moddie init: approachVerbs: 4) ; Do
		)
		(if (IsFlag 54)
			(pelvisRug init:)
			(littleLaserTitle init: approachVerbs: 4 89 setCycle: Fwd) ; Do, Holozine
			(gCurRoom setScript: sEnterFrom270)
		else
			(gWalkHandler addToFront: self)
			(pelvis init: approachVerbs: 4) ; Do
			(nail init: approachVerbs: 4) ; Do
			(littleLaserTitle init: setCycle: Fwd)
			(gCurRoom setScript: sEnterWithEgoTied)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(= local12 (event x:))
			(= local13 (event y:))
			(cond
				((== (gEgo view:) 268)
					(gEgo setScript: sEgoSits 0 0)
				)
				((IsFlag 410)
					(super handleEvent: event)
				)
				(
					(and
						(> gMouseX (gEgo x:))
						(== (gEgo loop:) 4)
						(or (== (gEgo cel:) 1) (== (gEgo cel:) 3))
					)
					(event claimed: 1)
					(gEgo setScript: sTurnEgo 0 0)
				)
				(
					(and
						(> gMouseX (gEgo x:))
						(or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
					)
					(event claimed: 1)
					(gEgo setMotion: 0 setScript: sTurnEgo 0 0)
				)
				(
					(and
						(< gMouseX (gEgo x:))
						(or (== (gEgo loop:) 0) (== (gEgo loop:) 2))
					)
					(event claimed: 1)
					(gEgo setMotion: 0 setScript: sTurnEgo 0 1)
				)
				(
					(and
						(< gMouseX (gEgo x:))
						(== (gEgo loop:) 4)
						(or (== (gEgo cel:) 0) (== (gEgo cel:) 2))
					)
					(event claimed: 1)
					(gEgo setScript: sTurnEgo 0 1)
				)
				(else
					(return 0)
				)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (notify)
		(gEgo setScript: sRogerFree)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Wall_Hanging
				(gEgo setScript: sLayTheRug)
			)
			(4 ; Do
				(if (IsFlag 80)
					(gMessager say: noun theVerb 3) ; "Unlike before, the room no longer gives off a subsonic vibration."
				else
					(gMessager say: noun theVerb 2) ; "The room seems to be vibrating very slightly. This would probably indicate a damping field in operation somewhere close by."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
		)
		(super dispose:)
	)
)

(instance sEnterFrom270 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(sfx number: 268 play: self)
				(door setCycle: Beg self)
			)
			(2)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPickUpDatacorder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 2604
					loop: 1
					cel: 0
					setSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(1
				(theDatacorder dispose:)
				(gEgo get: 27) ; Datacorder
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize: 7)
				(= cycles 5)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPickUpModdie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 2672
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(1
				(moddie dispose:)
				(gEgo get: 14) ; Burlesque_Moddie_1
				(gMessager say: 56 4 0 0 self) ; "You now possess the moddie."
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 7)
				(= cycles 5)
			)
			(4
				(gGame points: 1 416 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPickUpRug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 2661
					loop: 1
					cel: 0
					setSpeed: 8
					get: 109 ; Wall_Hanging
					setCycle: End self
				)
				(pelvis dispose:)
				(= local26 0)
			)
			(1
				(gEgo normalize: 6)
				((gCurRoom obstacles:) delete: local14)
				(local14 dispose:)
				(gCurRoom
					addObstacle:
						(= local14
							((Polygon new:)
								type: PContainedAccess
								init: 56 135 297 135 297 127 230 127 230 112 253 106 261 105 221 99 222 115 122 115 104 120 56 120
								yourself:
							)
						)
				)
				(= cycles 1)
			)
			(2
				(gGame points: 1 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPickUpKeys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 2671
					loop: 1
					cel: 0
					setSpeed: 8
					get: 64 ; Keyring
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: 7)
				(= cycles 1)
			)
			(2
				(gMessager say: 37 0 0 0 self) ; "Smooth move! You've got his keyring."
			)
			(3
				(gGame points: 1 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitTo270 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 2653
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: CT 9 1 self
				)
			)
			(2
				(sfx number: 268 play:)
				(door setCycle: End)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 3 setMotion: DPath 20 95 37 88 83 88 self)
			)
			(4
				(sfx number: 268 play:)
				(door setCycle: Beg self)
			)
			(5
				(gGame points: 3 509)
				(= cycles 5)
			)
			(6
				(gCurRoom newRoom: 270)
				(self dispose:)
			)
		)
	)
)

(instance sGetCdrom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 51 4 0 local19 self)
			)
			(2
				(++ local19)
				(if local21
					(gEgo
						view: 2680
						loop: 0
						cel: 0
						setSpeed: 8
						setCycle: End self
					)
				else
					(gEgo
						view: 2681
						loop: 0
						cel: 0
						setSpeed: 8
						setCycle: End self
					)
				)
			)
			(3
				(gEgo get: 55) ; Holozine
				(if local21
					(gEgo view: 268 loop: 0)
					(gEgo
						cel: (gEgo lastCel:)
						signal: (| $0800 (gEgo signal:))
					)
				else
					(gEgo normalize: 3)
				)
				(= cycles 1)
			)
			(4
				(gGame points: 3 417 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRandomTvScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= ticks (Random 600 1200))
			)
			(2
				(client loop: 3 cel: 0 setCycle: End self)
			)
			(3
				(client loop: 0 cel: 0 setCycle: RandCycle)
				(= ticks (Random 100 500))
			)
			(4
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(client loop: 2 cel: 0 setCycle: Fwd)
				(self changeState: 1)
			)
		)
	)
)

(instance sEnterWithEgoTied of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= ticks 120)
			)
			(2
				(gMessager say: 53 0 0 0 self) ; "You puny little scumbag. I can't believe anyone would want you. One thing's for sure; you sure ain't gonna be seein' your home sun ever again."
			)
			(3
				(nigel
					view: 226
					loop: 0
					cel: 0
					setStep: 6 3
					setSpeed: 8
					setCycle: StopWalk -1
					setHeading: 270 self
				)
			)
			(4
				(nigel setMotion: DPath 73 127 28 107 26 92 80 82 nigel)
				(gMessager say: 54 0 0 0 self) ; "Now just sit there and be still and be quiet, Little Man. I've got some things to finish, before I finish you."
			)
			(5
				(singent
					view: 227
					loop: 2
					cel: 0
					setStep: 6 3
					setSpeed: 8
					setCycle: StopWalk -1
					setMotion: DPath 39 116 39 100 self
				)
			)
			(6
				(singent view: 263 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(7
				(sfx number: 268 play:)
				(door setCycle: Beg)
				(singent setCycle: End self)
			)
			(8
				(singent
					view: 227
					loop: 4
					cel: 0
					setCycle: StopWalk -1
					setMotion: DPath 39 116 215 138 286 132 self
				)
			)
			(9
				(singent
					view: 263
					loop: 1
					cel: 0
					x: 277
					y: 131
					setCycle: CT 5 1 self
				)
			)
			(10
				(keyring init: approachVerbs: 4) ; Do
				(singent setCycle: End self)
			)
			(11
				(singent
					view: 227
					loop: 4
					cel: 0
					x: 286
					y: 132
					setCycle: StopWalk -1
					setMotion: MoveTo 215 138 self
				)
			)
			(12
				(singent setMotion: MoveTo 127 113 self)
			)
			(13
				(singent
					view: 264
					loop: 0
					cel: 0
					x: 95
					y: 107
					setPri: 114
					setCycle: End self
				)
			)
			(14
				(= ticks 30)
			)
			(15
				(singent loop: 1 cel: 0 setCycle: End self)
			)
			(16
				(= ticks 60)
			)
			(17
				(littleLaserTitle dispose:)
				(singent loop: 0)
				(singent cel: (singent lastCel:))
				(= cycles 1)
			)
			(18
				(receptacle init: approachVerbs: 4) ; Do
				(singent setScript: sSingentActions)
				(= ticks 60)
			)
			(19
				(gEgo setCycle: ForwardCounter 2 self)
			)
			(20
				(= ticks 40)
			)
			(21
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(22
				(= ticks 40)
			)
			(23
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(24
				(= ticks 40)
			)
			(25
				(gEgo loop: 0 cel: 0 setCycle: ForwardCounter 2 self)
			)
			(26
				(gEgo view: 265 loop: 0 cel: 0 setCycle: End self)
			)
			(27
				(gEgo view: 2602 loop: 4 cel: 1 setCycle: StopWalk -1)
				(= cycles 1)
			)
			(28
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurnEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 2603
					loop: (if register 0 else 1)
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 2602
					loop: 4
					cel: (if register 1 else 0)
					setCycle: StopWalk -1
				)
				(= cycles 5)
			)
			(2
				(gGame handsOn:)
				(gEgo setMotion: PolyPath local12 local13)
				(self dispose:)
			)
		)
	)
)

(instance sPullDownKeyring of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 2650
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(1
				(if local17
					(gEgo loop: 3 cel: 0 setCycle: End self)
				else
					(gEgo loop: 1 cel: 0 posn: 241 126 setCycle: End self)
					(keyring
						view: 2650
						loop: 2
						x: 213
						y: 89
						cel: 0
						setCycle: End singent
					)
					(sfx number: 269 play:)
				)
			)
			(2
				(if local17
					(nail dispose:)
					(gEgo get: 72) ; Nail
					(gGame points: 3)
				else
					(gGame points: 5)
					(gEgo
						view: 2602
						loop: 4
						cel: 0
						posn: 190 126
						setCycle: StopWalk -1
					)
				)
				(= cycles 1)
			)
			(3
				(if local17
					(gEgo loop: 0)
					(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(4
				(if local17
					(gEgo view: 2602 loop: 4 cel: 0 setCycle: StopWalk -1)
				)
				(= cycles 1)
			)
			(5
				(if (not local17)
					(= local17 1)
					(self dispose:)
				else
					(gMessager say: 34 0 0 0 self) ; "You are now a proud nail owner."
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSingentPickUpKeys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(singent view: 2651 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 35 0 0 0 self) ; "Hey, what the phu...! I don't want to see you move another inch or I'm gonna slice ya' into nice little bite-sized pieces. Now can it!"
			)
			(2
				(singent loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(singent loop: 3 cel: 0 x: 134 y: 117 setCycle: CT 4 1 self)
			)
			(4
				(keyring dispose:)
				(singent setCycle: End self)
			)
			(5
				(singent
					view: 264
					loop: 0
					cel: 0
					x: 95
					y: 107
					setCycle: End self
				)
			)
			(6
				(= next sSingentActions)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerFree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(or
						(OneOf (gEgo loop:) 0 2)
						(and
							(== (gEgo loop:) 4)
							(OneOf (gEgo cel:) 0 2)
						)
					)
					(gEgo loop: 0)
				else
					(gEgo loop: 1)
				)
				(gEgo
					view: 2652
					cel: 0
					setSpeed: 8
					setCycle: ForwardCounter 5 self
				)
			)
			(1
				(gWalkHandler delete: gCurRoom)
				(gEgo
					view: 2652
					loop: (if (== (gEgo loop:) 0) 2 else 3)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo normalize: (if (== (gEgo loop:) 2) 0 else 1))
				(= cycles 5)
			)
			(3
				((gCurRoom obstacles:) delete: local14)
				(local14 dispose:)
				(gCurRoom
					addObstacle:
						(= local14
							((Polygon new:)
								type: PContainedAccess
								init: 56 135 297 135 297 127 230 127 230 112 253 106 261 105 221 99 221 112 158 122 56 122
								yourself:
							)
						)
				)
				(= cycles 1)
			)
			(4
				(gMessager say: 33 0 0 0 self) ; "Good thinking! The nail proves to be just what you needed to free yourself from those handcuffs."
			)
			(5
				(gEgo put: 72) ; Nail
				(gGame points: 5 410 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerPullRug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: (if register 266 else 2660)
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(1
				(= ticks 20)
			)
			(2
				(pelvis hide:)
				(gEgo loop: 1 cel: 0 setCycle: ForwardCounter 2 self)
			)
			(3
				(gEgo setCel: 0 setCycle: End self)
				(sfx number: 263 play:)
			)
			(4
				(pelvis
					view: (gEgo view:)
					loop: 2
					cel: 0
					posn: (if register 221 else 261) (if register 99 else 105)
					cycleSpeed: 6
					setCycle: End
					show:
				)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(5
				(gEgo normalize: (if register 0 else 3))
				(= cycles 1)
			)
			(6
				(if register
					(pelvis approachX: 261 approachY: 105)
				else
					(pelvis approachX: 231 approachY: 106)
					(= local26 1)
					(gGame points: 5)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLayTheRug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 225 129 self)
			)
			(1
				(sfx number: 2601 play:)
				(gEgo
					view: 2661
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(pelvisRug init: approachVerbs: 4) ; Do
				(gEgo normalize: 1 put: 109) ; Wall_Hanging
				(= cycles 1)
			)
			(3
				(gMessager say: 32 0 0 0 self) ; "You carefully lay the rug on the floor. Even though you were never known for your interior decorating talents, you feel very satisfied with the location you have chosen."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChargeUpRoger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 267
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gEgo cel: 0)
				(= cycles 40)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo cel: 0)
				(= cycles 40)
			)
			(5
				(gGSound1 stop:)
				(gGSound2 number: 261 flags: 1 loop: 0 play:)
				(gEgo
					loop: 2
					cel: 0
					signal: (| $0800 (gEgo signal:))
					setCycle: Walk
					setMotion: MoveTo 146 125 self
				)
			)
			(6
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(7
				(gEgo
					loop: 6
					cel: 0
					posn: 181 126
					setCycle: Walk
					setMotion: DPath 144 131 202 128 135 127 190 119 self
				)
			)
			(8
				(gEgo normalize: 2)
				(= ticks 60)
			)
			(9
				(gMessager say: 31 0 0 0 self) ; "Your body is now carrying a nice static charge."
			)
			(10
				(= local20 1)
				(gGSound2 stop:)
				(gGSound1 number: 260 play:)
				(singent approachVerbs: 4) ; Do
				(gGame points: 5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKnockOutSingent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(receptacle dispose:)
				(gEgo
					view: 2670
					loop: 0
					cel: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(1
				(gEgo cel: 5)
				(= ticks 30)
			)
			(2
				(gEgo cel: 6)
				(= ticks 30)
			)
			(3
				(gEgo cel: 5)
				(Load 140 264) ; WAVE
				(= ticks 30)
			)
			(4
				(gEgo cel: 6)
				(Load 140 265) ; WAVE
				(= ticks 30)
			)
			(5
				(sfx loop: -1 number: 264 play:)
				(singent
					view: 2670
					loop: 2
					cel: 0
					setCycle: RandCycle
					setScript: 0
				)
				(sSingentActions dispose:)
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gEgo normalize: 1 posn: 153 115)
				(= ticks 120)
			)
			(7
				(sfx stop:)
				(if (not (gCast contains: littleLaserTitle))
					(littleLaserTitle init: approachVerbs: 4 89 setCycle: Fwd) ; Do, Holozine
				)
				(singent view: 2671 loop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(8
				(singent setCycle: End self)
				(sfx loop: 0 number: 265 play:)
			)
			(9
				((gCurRoom obstacles:) delete: local14)
				(local14 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 117 106 117 108 127 108 124 115 114 119 45 125 14 118 14 105 54 105 54 99 7 99 7 135 295 135 294 126 236 119 237 108 257 104 231 99 219 116 190 114 188 106
							yourself:
						)
				)
				(= cycles 1)
			)
			(10
				(SetFlag 54)
				(singent
					view: 2600
					setLoop: 3
					cel: 0
					posn: 95 107
					approachX: 70
					approachY: 121
					noun: 0
				)
				(= cycles 1)
			)
			(11
				(gMessager say: 58 4 10 0 self) ; "Wow! The static energy you built up discharged, frying lard boy's circuitry! Did you actually think of that or was it just luck?"
			)
			(12
				(gGame points: 5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoSits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 268
					loop: 0
					cel: (if register 0 else 6)
					signal: (| $0800 (gEgo signal:))
					setPri: 111
					setSpeed: 8
					setCycle: (if register End else Beg) self
				)
			)
			(1
				(if register
					(gWalkHandler addToFront: gCurRoom)
				else
					(gWalkHandler delete: self)
				)
				(= cycles 1)
			)
			(2
				(switch register
					(3
						(= local21 1)
						(= local16 1)
						(gEgo state: (& (gEgo state:) $fffd))
						(gCurRoom setInset: inLaserReader)
					)
					(2
						(= local21 1)
						(gEgo state: (& (gEgo state:) $fffd))
						(gCurRoom setInset: inLaserReader)
					)
					(1
						(= local21 1)
						(gEgo state: (& (gEgo state:) $fffd))
					)
					(else
						(= local21 0)
						(gEgo
							setPri: -1
							state: (& (gEgo state:) $0002)
							normalize: 3
						)
					)
				)
				(= cycles 1)
			)
			(3
				(cond
					(local22
						(= local22 0)
						(= next sExitTo270)
						(gEgo setMotion: PolyPath 59 99 self)
					)
					(local23
						(= local23 0)
						(= next sPickUpModdie)
						(gEgo setMotion: PolyPath 185 106 self)
					)
					(local24
						(= local24 0)
						(= next sPickUpKeys)
						(gEgo setMotion: PolyPath 70 121 self)
					)
					(local25
						(= local25 0)
						(= next sPickUpDatacorder)
						(gEgo setMotion: PolyPath 171 108 self)
					)
					(else
						(gGame handsOn:)
						(= cycles 1)
					)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sSingentActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 500))
			)
			(1
				(client loop: (Random 1 4) cel: 0 setCycle: End self)
				(if (== (client loop:) 1)
					(littleLaserTitle init: setCycle: Fwd)
				)
			)
			(2
				(if (== (client loop:) 1)
					(littleLaserTitle dispose:)
				)
				(= cycles 1)
			)
			(3
				(client loop: 1)
				(client cel: (client lastCel:))
				(self changeState: 0)
			)
		)
	)
)

(instance nigel of Actor
	(properties
		x 166
		y 137
		view 224
		loop 2
		cycleSpeed 12
	)

	(method (cue)
		(nigel dispose:)
	)
)

(instance singent of Actor
	(properties
		noun 58
		approachX 124
		approachY 115
		x 209
		y 125
		view 224
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local20
						(= local20 0)
						(gEgo setScript: sKnockOutSingent)
					)
					((and (IsFlag 54) (not (gEgo has: 64))) ; Keyring
						(if local21
							(= local24 1)
							(gEgo setScript: sEgoSits 0 0)
						else
							(gEgo setScript: sPickUpKeys)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self setScript: sSingentPickUpKeys)
	)

	(method (init)
		(if (IsFlag 54)
			(self
				view: 2600
				loop: 3
				cel: 0
				posn: 95 107
				approachX: 70
				approachY: 121
			)
		)
		(super init:)
	)
)

(instance cdromLight of Prop
	(properties
		x 235
		y 127
		view 269
		loop 8
	)
)

(instance cdrom of Prop
	(properties
		noun 60
		sightAngle 40
		x 133
		y 122
		priority 300
		fixPriority 1
		view 269
		loop 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 55) ; Holozine
				(ClearFlag 200)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance littleCdrom of View
	(properties
		noun 14
		sightAngle 40
		approachX 117
		approachY 108
		x 95
		y 70
		priority 100
		fixPriority 1
		view 260
		cel 5
	)

	(method (doVerb theVerb)
		(computer doVerb: theVerb)
	)
)

(instance littleLaserTitle of Prop
	(properties
		noun 14
		sightAngle 40
		approachX 117
		approachY 108
		x 90
		y 54
		priority 99
		fixPriority 1
		view 260
		loop 1
	)

	(method (doVerb theVerb)
		(computer doVerb: theVerb)
	)
)

(instance tvScreen of Prop
	(properties
		noun 30
		sightAngle 40
		x 265
		y 126
		z 44
		priority 115
		fixPriority 1
		view 262
		loop 2
		signal 20513
	)
)

(instance door of Prop
	(properties
		noun 2
		sightAngle 40
		approachX 20
		approachY 100
		y 17
		priority 95
		fixPriority 1
		view 261
		cel 5
		signal 20513
	)

	(method (cue)
		(gCurRoom newRoom: 270)
	)
)

(instance sporeSign of Prop
	(properties
		noun 10
		sightAngle 40
		x 192
		y 37
		view 261
		loop 1
		cel 3
		signal 20513
		cycleSpeed 15
	)
)

(instance pelvis of Prop
	(properties
		noun 26
		sightAngle 40
		approachX 221
		approachY 99
		x 232
		y 15
		priority 50
		fixPriority 1
		view 260
		cel 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 410))
						(super doVerb: theVerb)
					)
					((== view 260)
						(gEgo setScript: sRogerPullRug 0 1)
					)
					((== view 266)
						(gEgo setScript: sRogerPullRug 0 0)
					)
					(else
						(gEgo setScript: sPickUpRug)
					)
				)
			)
			(1 ; Look
				(if local26
					(gMessager say: noun theVerb 11) ; "A beautiful thick shag carpet of Pelvis Brelsford."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theDatacorder of View
	(properties
		noun 63
		sightAngle 40
		approachX 171
		approachY 108
		x 152
		y 74
		view 2604
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local21
						(= local25 1)
						(gEgo setScript: sEgoSits 0 0)
					)
					((IsFlag 54)
						(gEgo setScript: sPickUpDatacorder)
					)
					((IsFlag 410)
						(gMessager say: noun theVerb 8) ; "I'd better not try it. He might see me."
					)
					(else
						(gMessager say: noun theVerb 1) ; "You're tied up; hence, you can't do that."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance moddie of View
	(properties
		noun 56
		sightAngle 40
		approachX 187
		approachY 108
		x 178
		y 87
		view 260
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local21
						(= local23 1)
						(gEgo setScript: sEgoSits 0 0)
					)
					((IsFlag 54)
						(gEgo setScript: sPickUpModdie)
					)
					((IsFlag 410)
						(gMessager say: noun theVerb 8) ; "I'd better not try it. He might see me."
					)
					(else
						(gMessager say: noun theVerb 1) ; "You're tied up; hence, you can't do that."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rings of View
	(properties
		noun 52
		sightAngle 40
		x 247
		y 14
		view 2600
		loop 2
	)
)

(instance pelvisRug of View
	(properties
		noun 57
		sightAngle 40
		approachX 196
		approachY 126
		x 169
		y 127
		priority 10
		fixPriority 1
		view 2600
		loop 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local20
						(gMessager say: 36) ; "You're already carrying enough energy to power a small planetoid. You couldn't generate more energy if you were wearing a polyester leisure suit."
					)
					((IsFlag 54)
						(super doVerb: theVerb)
					)
					(else
						(gEgo setScript: sChargeUpRoger)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stool of View
	(properties
		noun 25
		sightAngle 40
		approachX 117
		approachY 108
		x 114
		y 113
		priority 110
		fixPriority 1
		view 260
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (IsFlag 54) (not local21))
					(gEgo setScript: sEgoSits 0 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nail of Prop
	(properties
		noun 29
		sightAngle 40
		approachX 288
		approachY 126
		x 310
		y 69
		view 260
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sPullDownKeyring)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyring of Prop
	(properties
		noun 28
		sightAngle 40
		approachX 288
		approachY 126
		x 311
		y 75
		view 260
		cel 3
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sPullDownKeyring)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pinup of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 154
		approachY 105
		x 154
		y 104
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 23 171 23 169 3 132 3 128 7
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sign1 of Feature
	(properties
		noun 4
		sightAngle 40
		approachX 288
		approachY 123
		x 288
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 282 11 279 31 296 44 300 21
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poster1 of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 123
		approachY 105
		x 123
		y 104
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 109 59 121 47 133 55 123 67
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poster2 of Feature
	(properties
		noun 7
		sightAngle 40
		approachX 123
		approachY 105
		x 123
		y 104
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 110 30 111 46 130 45 128 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poster3 of Feature
	(properties
		noun 9
		sightAngle 40
		approachX 96
		approachY 107
		x 96
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 82 23 94 0 117 6 102 33 yourself:)
		)
		(super init: &rest)
	)
)

(instance tv of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 240
		approachY 126
		x 300
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 297 91 297 83 293 79 295 70 293 64 281 60 280 57 274 56 272 60 266 61 260 64 261 79 257 82 254 90 260 92 281 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance desk of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 117
		approachY 107
		x 117
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 103 65 80 77 71 156 71 165 80 165 103 159 103 159 85 153 82 153 97 148 95 148 82 82 82 82 95 77 95 77 83 71 84 71 103
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (not (IsFlag 410)) (== theVerb 4)) ; Do
			(gMessager say: noun theVerb 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance beer1 of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 77
		approachY 107
		x 77
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 69 77 76 77 79 75 80 74 80 66 76 66 76 73 69 73
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (not (IsFlag 410)) (OneOf theVerb 4 2)) ; Do, Talk
			(gMessager say: noun theVerb 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance beer2 of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 253
		approachY 126
		x 253
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 239 118 238 122 247 120 246 117
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(beer1 doVerb: theVerb)
	)
)

(instance beer3 of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 253
		approachY 126
		x 253
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 249 113 257 114 257 111 249 110
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(beer1 doVerb: theVerb)
	)
)

(instance beer4 of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 253
		approachY 126
		x 253
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 94 259 94 258 92 249 92 249 85 257 85 258 90 265 90
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(beer1 doVerb: theVerb)
	)
)

(instance box of Feature
	(properties
		noun 16
		sightAngle 40
		approachX 185
		approachY 106
		x 185
		y 86
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 156 84 156 98 158 101 182 101 182 87 178 84
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance computer of Feature
	(properties
		noun 14
		sightAngle 40
		approachX 117
		approachY 108
		x 77
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 86 51 106 51 106 66 114 66 116 69 116 75 112 75 112 78 86 78 86 76 82 76 82 70 86 66
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Holozine
				(if (IsFlag 54)
					(if local21
						(= local16 1)
						(gCurRoom setInset: inLaserReader)
					else
						(gEgo setScript: sEgoSits 0 3)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(cond
					((not (IsFlag 410))
						(gMessager say: noun theVerb 1) ; "You struggle, but it's simply out of your grasp."
					)
					((IsFlag 54)
						(if local21
							(gCurRoom setInset: inLaserReader)
						else
							(gEgo setScript: sEgoSits 0 2)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance teddy of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 185
		approachY 107
		x 185
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 80 185 87 182 90 184 91 185 94 190 95 195 95 196 93 194 92 195 90 192 87 194 80
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance blowUpDoll of Feature
	(properties
		noun 12
		sightAngle 40
		approachX 222
		approachY 104
		x 222
		y 103
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 210 91 203 107 208 106 219 89 219 80 222 78 225 76 221 94 225 93 228 75 228 70 227 69 228 60 222 57 213 61 211 66 196 82 198 84 202 80 210 73 207 81 202 90 192 101 195 103
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (not (IsFlag 410)) (OneOf theVerb 4 2)) ; Do, Talk
			(gMessager say: noun theVerb 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 13
		sightAngle 40
		approachX 105
		approachY 107
		x 105
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 51 91 47 96 25 112 20 120 19 130 22 131 26 128 30 120 30 112 28 112 24 99 26 97 45 102 49 104 51
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance duckie of Feature
	(properties
		noun 17
		sightAngle 40
		approachX 185
		approachY 107
		x 185
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 100 188 100 190 98 190 95 187 94 185 95 184 93 180 93 179 97 182 98
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table of Feature
	(properties
		noun 19
		sightAngle 40
		approachX 266
		approachY 126
		x 266
		y 124
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 249 85 241 89 241 94 249 98 257 98 257 105 248 106 241 110 241 115 263 121 286 119 297 115 297 110 281 105 281 99 297 94 297 89 290 86
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rug of Feature
	(properties
		noun 20
		sightAngle 40
		approachX 45
		approachY 126
		x 45
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 118 56 107 98 133 96 135 44 129 43 124 38 121 32 122 27 125 20 129 14 137 8 133 3 133 0 135
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance noSign of Feature
	(properties
		noun 21
		sightAngle 40
		approachX 55
		approachY 97
		x 55
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 52 33 57 42 65 45 70 48 77 47 87 40 89 30 85 23 76 18 65 18 57 23
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hoop of Feature
	(properties
		noun 22
		sightAngle 40
		approachX 45
		approachY 97
		x 45
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 38 17 38 25 43 28 49 25 49 16 46 15 46 13 42 13 42 15
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance doorControls of Feature
	(properties
		noun 23
		nsLeft 57
		nsTop 56
		nsRight 65
		nsBottom 68
		sightAngle 40
		approachX 50
		approachY 104
		x 50
		y 103
	)

	(method (doVerb theVerb)
		(switch theVerb
			(87 ; Keyring
				(if (and (== local21 0) (IsFlag 54))
					(gEgo setScript: sExitTo270)
				else
					(= local22 1)
					(gEgo setScript: sEgoSits 0 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance twoHeader of Feature
	(properties
		noun 24
		nsLeft 136
		nsTop 27
		nsRight 172
		nsBottom 68
		sightAngle 40
		approachX 151
		approachY 107
		x 151
		y 103
	)
)

(instance books of Feature
	(properties
		noun 50
		sightAngle 40
		approachX 141
		approachY 106
		x 150
		y 73
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 75 152 79 156 75 158 67 152 64 144 65 146 71
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 119 76 126 75 133 78 139 73 143 72 136 70 117 71
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cdroms of Feature
	(properties
		noun 51
		sightAngle 40
		approachX 136
		approachY 110
		x 136
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 66 131 66 133 67 133 70 120 71
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 410))
						(gMessager say: noun theVerb 1) ; "You're tied up; hence, you can't do that."
					)
					((not (IsFlag 54))
						(gMessager say: noun theVerb 8) ; "I'd better not try it. He might see me."
					)
					((IsFlag 417)
						(gMessager say: noun theVerb 0 10) ; "You should have paid attention the first time. This game's budget is way too small to allow me to list all those titles over again."
					)
					((== local19 1)
						(gMessager sayRange: noun theVerb 0 1 2) ; "Your search through the CDs reveals a bunch of typically boring multimedia magazines."
						(= local19 3)
					)
					((== local19 9)
						(gEgo setScript: sGetCdrom)
					)
					(else
						(gMessager say: noun theVerb 0 local19)
						(++ local19)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sInsertCdrom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo put: 55) ; Holozine
				(cdrom cel: 0 init: setCycle: End self)
				(sfx number: 266 play: self)
			)
			(2)
			(3
				(cdromLight cel: 0 init: setCycle: ForwardCounter 2 self)
			)
			(4
				(laserTitle dispose:)
				(cdrom dispose:)
				(cdromLight dispose:)
				(downArrowButton init:)
				(upArrowButton init:)
				(localproc_1 47 0 17)
				(localproc_1 45 1 30)
				(localproc_1 46 2 40)
				(localproc_1 39 3 50)
				(localproc_1 48 4 60)
				(localproc_1 49 5 70)
				(= local16 1)
				(= cycles 1)
			)
			(5
				(gGame points: 3 409 handsOn:)
				(gTheIconBar
					setupExit: 1
					disable: 0
					select: (gTheIconBar at: 2)
					show:
				)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				(self dispose:)
			)
		)
	)
)

(instance sEjectCdrom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client cel: 1)
				(= ticks 10)
			)
			(1
				(client cel: 0)
				(= cycles 1)
			)
			(2
				(downArrowButton dispose:)
				(upArrowButton dispose:)
				(localproc_3)
				(localproc_4)
				(gotoButton loop: 1 cel: 0 show:)
				(= cycles 1)
			)
			(3
				(cdrom cel: (cdrom lastCel:) init: setCycle: Beg self)
				(sfx number: 266 play:)
				(= cycles 1)
			)
			(4
				(= local16 0)
				(SetFlag 200)
				(laserTitle init: setCycle: Fwd)
				(gGame handsOn:)
				(gTheIconBar setupExit: 1 enable: 0 show:)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				(self dispose:)
			)
		)
	)
)

(instance inLaserReader of Inset
	(properties
		picture 265
		disposeNotOnMe 1
		noun 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 80)
					(gMessager say: noun theVerb 3) ; "Unlike before, the room no longer gives off a subsonic vibration."
				else
					(gMessager say: noun theVerb 2) ; "The room seems to be vibrating very slightly. This would probably indicate a damping field in operation somewhere close by."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(= local11 (Str newWith: 80 {}))
		(ejectButton init:)
		(printButton init:)
		(gotoButton init:)
		(computerInset init:)
		(cdromDriveInset init:)
		(ratInset init:)
		(laserTitle init: setCycle: Fwd)
		(if local16
			(gEgo put: 55) ; Holozine
			(inLaserReader setScript: sInsertCdrom)
		else
			(gGame handsOn:)
			(gTheIconBar setupExit: 1 enable: 0 select: (gTheIconBar at: 2) show:)
			(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		)
		(if (IsFlag 200)
			(cdrom init:)
		)
	)

	(method (dispose)
		(ejectButton dispose:)
		(printButton dispose:)
		(gotoButton dispose:)
		(computerInset dispose:)
		(cdromDriveInset dispose:)
		(ratInset dispose:)
		(if local16
			(downArrowButton dispose:)
			(upArrowButton dispose:)
			(localproc_3)
			(localproc_4)
			(gEgo get: 55) ; Holozine
			(= local16 0)
		else
			(laserTitle dispose:)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		(local11 dispose:)
		(if (IsFlag 200)
			(cdrom dispose:)
		)
		(super dispose:)
		(cond
			((IsFlag 200)
				(littleCdrom init:)
			)
			((gCast contains: littleCdrom)
				(littleCdrom dispose:)
			)
		)
		(gWalkHandler addToFront: gCurRoom)
	)
)

(instance gotoButton of Prop
	(properties
		noun 43
		x 95
		y 88
		priority 200
		fixPriority 1
		view 269
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local16
					(self setScript: (sButtonAction new:))
					(if (== [local7 0] 0)
						(= loop 0)
						(localproc_3)
						(localproc_5)
					else
						(= loop 1)
						(localproc_4)
						(localproc_1 47 0 17)
						(localproc_1 45 1 30)
						(localproc_1 46 2 40)
						(localproc_1 39 3 50)
						(localproc_1 48 4 60)
						(localproc_1 49 5 70)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance printButton of Prop
	(properties
		noun 42
		x 205
		y 88
		priority 200
		fixPriority 1
		view 269
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local16
					(self setScript: (sButtonAction new:))
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ejectButton of Prop
	(properties
		noun 44
		x 114
		y 125
		priority 200
		fixPriority 1
		view 269
		loop 3
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local16
					(self setScript: (sButtonAction new:))
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance laserTitle of Prop
	(properties
		noun 14
		x 122
		y 24
		priority 200
		fixPriority 1
		view 269
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local16
					(self setScript: (sButtonAction new:))
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class ArrowButton of View
	(properties
		priority 200
		fixPriority 1
		view 269
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(switch theVerb
			(4 ; Do
				(= cel (= temp1 1))
				(UpdateScreenItem self)
				(FrameOut)
				(= scratch gGameTime)
				(= temp2 0)
				(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
					(temp0 localize: plane)
					(cond
						((self onMe: temp0)
							(if (not temp1)
								(= cel (= temp1 1))
								(UpdateScreenItem self)
								(FrameOut)
							)
							(if
								(and
									(not (mod (Abs (- gGameTime scratch)) 15))
									(!= temp2 gGameTime)
								)
								(cond
									(
										(and
											(== self upArrowButton)
											(== [local7 0] 0)
										)
										(localproc_2 1)
									)
									(
										(and
											(== self downArrowButton)
											(== [local7 0] 0)
										)
										(localproc_2 0)
									)
									(
										(and
											(== self upArrowButton)
											(< ([local7 1] y:) 25)
										)
										([local7 1]
											y: (+ ([local7 1] y:) 5)
											draw:
										)
									)
									(
										(and
											(== self downArrowButton)
											(>
												(+
													([local7 1] y:)
													(local10 at: 3)
												)
												85
											)
										)
										([local7 1]
											y: (- ([local7 1] y:) 5)
											draw:
										)
									)
								)
								(FrameOut)
							)
							(= temp2 gGameTime)
							(= gGameTime (+ gTickOffset (GetTime)))
						)
						(temp1
							(= cel (= temp1 0))
							(UpdateScreenItem self)
							(FrameOut)
						)
					)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(if (== temp1 1)
					(= cel 0)
					(UpdateScreenItem self)
					(FrameOut)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance upArrowButton of ArrowButton
	(properties
		noun 40
		x 220
		y 13
		loop 4
	)
)

(instance downArrowButton of ArrowButton
	(properties
		noun 41
		x 220
		y 79
		loop 5
	)
)

(instance sButtonAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canInput: 0)
				(sfx number: 920 play: self)
				(client cel: 1)
			)
			(1
				(client cel: 0)
				(= cycles 1)
			)
			(2
				(if (and local16 (== client ejectButton))
					(= next sEjectCdrom)
				)
				(gUser canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance computerInset of Feature
	(properties
		noun 14
		x 184
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 80 0 80 109 105 109 105 113 67 113 67 139 302 139 302 115 227 115 227 109 239 109 239 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local16)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cdromDriveInset of Feature
	(properties
		noun 38
		x 181
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 132 121 230 121 230 138 132 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local16)
					(super doVerb: theVerb)
				)
			)
			(89 ; Holozine
				(inLaserReader setScript: sInsertCdrom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ratInset of Feature
	(properties
		noun 59
		x 39
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 17 8 13 18 9 25 0 46 1 64 3 59 16 56 26 67 30 78 40 78 62 74 67 66 62 69 69 64 75 55 74 63 81 70 80 75 88 66 92 77 99 71 107 71 140 0 140
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance receptacle of Feature
	(properties
		noun 61
		sightAngle 40
		approachX 124
		approachY 115
		x 102
		y 126
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 99 53 106 53 106 58 99 58
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local20
					(= local20 0)
					(gEgo setScript: sKnockOutSingent)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Singent of SmallTalker
	(properties
		talkView 2651
		talkLoop 1
	)

	(method (init)
		(= client singent)
		(if (== (singent view:) 2651)
			(self talkView: 2651 talkLoop: 1)
		else
			(self talkView: 224 talkLoop: 0)
		)
		(super init:)
	)
)

(instance sfx of Sound
	(properties)
)

