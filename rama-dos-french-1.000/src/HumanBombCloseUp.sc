;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8115)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SoundManager)
(use Button)
(use BombCtr)
(use newYorkRegion)
(use n1111)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	HumanBombCloseUp 0
	theBomb 1
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(if
		(and
			(IsFlag 159)
			(IsFlag 160)
			(IsFlag 161)
			(IsFlag 162)
			(IsFlag 163)
			(IsFlag 164)
			(IsFlag 165)
			(IsFlag 166)
			(IsFlag 167)
			(IsFlag 168)
			(IsFlag 169)
			(IsFlag 170)
			(IsFlag 171)
			(IsFlag 172)
			(IsFlag 173)
			(IsFlag 174)
		)
		(SetFlag 175)
		(inputScreen init: global117)
	)
)

(procedure (localproc_1 param1)
	(if (== (param1 loop:) 11)
		(param1 setLoop: (param1 digitLoop:) setCel: 0)
		(SetFlag (param1 myFlag:))
		(localproc_0)
	else
		(param1 setCel: (mod (+ (param1 cel:) 1) 10))
	)
)

(procedure (localproc_2)
	(return
		(and
			(== 251 global183)
			(== global180 global184)
			(== global181 global185)
			(== global182 global186)
			(== 1097 global187)
		)
	)
)

(procedure (localproc_3)
	(SoundManager fadeMusic: 0 20 10 1)
	(inputScreen setCel: 5)
	(disarmSnd play:)
	(SetFlag 157)
	(proc201_3 theBomb)
	(theBomb hide: dispose:)
	(rightSnd play:)
	(activitySign init: global117)
	(theLight dispose:)
	(armedSign cel: 0)
	(digitList eachElementDo: #dispose)
	(buttonList eachElementDo: #dispose)
	(BOMB_0 case: 5)
	(SoundManager playMusic: 0 -1 6030)
)

(procedure (localproc_4 param1)
	(switch param1
		(0
			(= global183
				(+
					(* (digit00 cel:) 1000)
					(* (digit01 cel:) 100)
					(* (digit02 cel:) 10)
					(* (digit03 cel:) 1)
				)
			)
		)
		(1
			(= global184
				(+
					(* (digit10 cel:) 1000)
					(* (digit11 cel:) 100)
					(* (digit12 cel:) 10)
					(* (digit13 cel:) 1)
				)
			)
		)
		(2
			(= global185
				(+
					(* (digit20 cel:) 1000)
					(* (digit21 cel:) 100)
					(* (digit22 cel:) 10)
					(* (digit23 cel:) 1)
				)
			)
		)
		(3
			(= global186
				(+
					(* (digit30 cel:) 1000)
					(* (digit31 cel:) 100)
					(* (digit32 cel:) 10)
					(* (digit33 cel:) 1)
				)
			)
		)
		(4
			(= global187
				(+
					(* (digit40 cel:) 1000)
					(* (digit41 cel:) 100)
					(* (digit42 cel:) 10)
					(* (digit43 cel:) 1)
				)
			)
		)
	)
)

(instance HumanBombCloseUp of CloseupLocation
	(properties)

	(method (init)
		(self picture: 8015 heading: 270)
		(super init: 8015 &rest)
		(activitySign init: global117)
		(armedSign init: global117)
		(if (proc1111_24 157)
			(proc201_2 theBomb)
			(theBomb init: global117)
			(inputScreen init: global117)
			(theLight init: global117)
			(buttonList
				add:
					butn00
					butn01
					butn02
					butn03
					butn10
					butn11
					butn12
					butn13
					butn20
					butn21
					butn22
					butn23
					butn30
					butn31
					butn32
					butn33
					butn40
					butn41
					butn42
					butn43
			)
			(buttonList eachElementDo: #init global117)
			(digitList
				add:
					digit00
					digit01
					digit02
					digit03
					digit10
					digit11
					digit12
					digit13
					digit20
					digit21
					digit22
					digit23
					digit30
					digit31
					digit32
					digit33
					digit40
					digit41
					digit42
					digit43
			)
			(digitList eachElementDo: #init global117)
		)
		(if (>= global244 3)
			(gCurRoom setScript: sRedLights)
		)
		(BOMB_0 init:)
	)

	(method (dispose)
		(proc201_3 theBomb)
		(if (gCurRoom script:)
			((gCurRoom script:) dispose:)
		)
		(super dispose:)
	)
)

(class CodeDigit of View
	(properties
		view 8015
		digitLoop 0
		place 1
		bombCode 0
		myFlag 0
	)

	(method (init)
		(if (or (== myFlag 0) (IsFlag myFlag))
			(self
				setCel: (mod (/ bombCode place) 10)
				setLoop: (self digitLoop:)
			)
		else
			(self setCel: 0 setLoop: 11)
		)
		(super init: &rest)
	)
)

(instance buttonList of Set
	(properties)
)

(instance digitList of Set
	(properties)
)

(instance theBomb of BombCtr
	(properties
		xPos 396
		yPos 99
	)
)

(instance inputScreen of View
	(properties
		x 96
		y 67
		loop 3
		view 8015
	)

	(method (init)
		(self setPri: 150)
		(if (and (proc1111_24 157) (IsFlag 175))
			(switch global244
				(0
					(= cel 1)
				)
				(1
					(= cel 2)
				)
				(2
					(= cel 3)
				)
				(3
					(= cel 4)
				)
				(4
					(= cel 5)
				)
			)
			(super init: &rest)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (< global244 3)
					(self setCel: (+ cel 1))
					(if (localproc_2)
						(localproc_3)
						(inputScreen dispose:)
					else
						(+= global244 1)
						(wrngSnd play:)
						(if (>= global244 3)
							(proc201_6)
							(self deleteHotspot: 2)
							(gCurRoom setScript: sRedLights)
						)
					)
				)
			)
		)
	)
)

(instance theLight of View
	(properties
		x 288
		y 129
		loop 10
		view 8015
	)
)

(instance activitySign of View
	(properties
		x 391
		y 93
		loop 3
		view 8015
	)

	(method (init)
		(if (IsFlag 157)
			(super init: &rest)
		)
	)
)

(instance armedSign of View
	(properties
		x 94
		y 123
		loop 4
		view 8015
	)

	(method (init)
		(if (IsFlag 157)
			(= cel 0)
		else
			(= cel 1)
		)
		(super init: &rest)
	)
)

(class BombButn of Button
	(properties
		myBombCode 0
		myDigit 0
	)

	(method (init)
		(&= signal $efff)
		(super init: &rest)
		(self setHotspot: 1)
	)

	(method (trace param1)
		(if
			(and
				(gTheCursor isInvCursor:)
				(== 114 (proc70_7 (gTheCursor invItem:)))
			)
			(return)
		else
			(super trace: param1 &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (< global244 3)
					(butnSnd play:)
					(localproc_1 myDigit)
					(localproc_4 myBombCode)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance butn00 of BombButn
	(properties
		x 38
		y 175
		loop 2
		view 8015
		downLoop 1
		downCel 0
	)

	(method (init)
		(= myDigit digit00)
		(super init: &rest)
	)
)

(instance butn01 of BombButn
	(properties
		x 61
		y 175
		loop 2
		cel 1
		view 8015
		downLoop 1
	)

	(method (init)
		(= myDigit digit01)
		(super init: &rest)
	)
)

(instance butn02 of BombButn
	(properties
		x 87
		y 176
		loop 2
		cel 2
		view 8015
		downLoop 1
		downCel 2
	)

	(method (init)
		(= myDigit digit02)
		(super init: &rest)
	)
)

(instance butn03 of BombButn
	(properties
		x 112
		y 176
		loop 2
		cel 3
		view 8015
		downLoop 1
		downCel 3
	)

	(method (init)
		(= myDigit digit03)
		(super init: &rest)
	)
)

(instance butn10 of BombButn
	(properties
		x 136
		y 177
		loop 2
		cel 4
		view 8015
		downLoop 1
		downCel 4
		myBombCode 1
	)

	(method (init)
		(= myDigit digit10)
		(super init: &rest)
	)
)

(instance butn11 of BombButn
	(properties
		x 162
		y 177
		loop 2
		cel 5
		view 8015
		downLoop 1
		downCel 5
		myBombCode 1
	)

	(method (init)
		(= myDigit digit11)
		(super init: &rest)
	)
)

(instance butn12 of BombButn
	(properties
		x 187
		y 177
		loop 2
		cel 6
		view 8015
		downLoop 1
		downCel 6
		myBombCode 1
	)

	(method (init)
		(= myDigit digit12)
		(super init: &rest)
	)
)

(instance butn13 of BombButn
	(properties
		x 214
		y 177
		loop 2
		cel 7
		view 8015
		downLoop 1
		downCel 7
		myBombCode 1
	)

	(method (init)
		(= myDigit digit13)
		(super init: &rest)
	)
)

(instance butn20 of BombButn
	(properties
		x 239
		y 177
		loop 2
		cel 8
		view 8015
		downLoop 1
		downCel 8
		myBombCode 2
	)

	(method (init)
		(= myDigit digit20)
		(super init: &rest)
	)
)

(instance butn21 of BombButn
	(properties
		x 263
		y 177
		loop 2
		cel 9
		view 8015
		downLoop 1
		downCel 9
		myBombCode 2
	)

	(method (init)
		(= myDigit digit21)
		(super init: &rest)
	)
)

(instance butn22 of BombButn
	(properties
		x 290
		y 177
		loop 2
		cel 10
		view 8015
		downLoop 1
		downCel 10
		myBombCode 2
	)

	(method (init)
		(= myDigit digit22)
		(super init: &rest)
	)
)

(instance butn23 of BombButn
	(properties
		x 315
		y 177
		loop 2
		cel 11
		view 8015
		downLoop 1
		downCel 11
		myBombCode 2
	)

	(method (init)
		(= myDigit digit23)
		(super init: &rest)
	)
)

(instance butn30 of BombButn
	(properties
		x 339
		y 178
		loop 2
		cel 12
		view 8015
		downLoop 1
		downCel 12
		myBombCode 3
	)

	(method (init)
		(= myDigit digit30)
		(super init: &rest)
	)
)

(instance butn31 of BombButn
	(properties
		x 364
		y 178
		loop 2
		cel 13
		view 8015
		downLoop 1
		downCel 13
		myBombCode 3
	)

	(method (init)
		(= myDigit digit31)
		(super init: &rest)
	)
)

(instance butn32 of BombButn
	(properties
		x 391
		y 179
		loop 2
		cel 14
		view 8015
		downLoop 1
		downCel 14
		myBombCode 3
	)

	(method (init)
		(= myDigit digit32)
		(super init: &rest)
	)
)

(instance butn33 of BombButn
	(properties
		x 416
		y 179
		loop 2
		cel 15
		view 8015
		downLoop 1
		downCel 15
		myBombCode 3
	)

	(method (init)
		(= myDigit digit33)
		(super init: &rest)
	)
)

(instance butn40 of BombButn
	(properties
		x 441
		y 179
		loop 2
		cel 16
		view 8015
		downLoop 1
		downCel 16
		myBombCode 4
	)

	(method (init)
		(= myDigit digit40)
		(super init: &rest)
	)
)

(instance butn41 of BombButn
	(properties
		x 466
		y 180
		loop 2
		cel 17
		view 8015
		downLoop 1
		downCel 17
		myBombCode 4
	)

	(method (init)
		(= myDigit digit41)
		(super init: &rest)
	)
)

(instance butn42 of BombButn
	(properties
		x 493
		y 179
		loop 2
		cel 18
		view 8015
		downLoop 1
		downCel 18
		myBombCode 4
	)

	(method (init)
		(= myDigit digit42)
		(super init: &rest)
	)
)

(instance butn43 of BombButn
	(properties
		x 517
		y 180
		loop 2
		cel 19
		view 8015
		upCel 19
		downLoop 1
		downCel 19
		myBombCode 4
	)

	(method (init)
		(= myDigit digit43)
		(super init: &rest)
	)
)

(instance digit00 of CodeDigit
	(properties
		x 44
		y 146
		digitLoop 5
		place 1000
	)

	(method (init)
		(= bombCode global183)
		(= myFlag 159)
		(super init: &rest)
	)
)

(instance digit01 of CodeDigit
	(properties
		x 68
		y 146
		digitLoop 5
		place 100
	)

	(method (init)
		(= bombCode global183)
		(= myFlag 160)
		(super init: &rest)
	)
)

(instance digit02 of CodeDigit
	(properties
		x 94
		y 146
		digitLoop 5
		place 10
	)

	(method (init)
		(= bombCode global183)
		(= myFlag 161)
		(super init: &rest)
	)
)

(instance digit03 of CodeDigit
	(properties
		x 119
		y 146
		digitLoop 5
	)

	(method (init)
		(= bombCode global183)
		(= myFlag 162)
		(super init: &rest)
	)
)

(instance digit10 of CodeDigit
	(properties
		x 144
		y 146
		digitLoop 6
		place 1000
	)

	(method (init)
		(= bombCode global184)
		(= myFlag 163)
		(super init: &rest)
	)
)

(instance digit11 of CodeDigit
	(properties
		x 170
		y 146
		digitLoop 6
		place 100
	)

	(method (init)
		(= bombCode global184)
		(= myFlag 164)
		(super init: &rest)
	)
)

(instance digit12 of CodeDigit
	(properties
		x 195
		y 146
		digitLoop 6
		place 10
	)

	(method (init)
		(= bombCode global184)
		(super init: &rest)
		(= cel (mod (/ bombCode place) 10))
	)
)

(instance digit13 of CodeDigit
	(properties
		x 221
		y 146
		digitLoop 6
	)

	(method (init)
		(= bombCode global184)
		(super init: &rest)
		(= cel (mod (/ bombCode place) 10))
	)
)

(instance digit20 of CodeDigit
	(properties
		x 246
		y 147
		digitLoop 7
		place 1000
	)

	(method (init)
		(= bombCode global185)
		(super init: &rest)
		(= cel (mod (/ bombCode place) 10))
	)
)

(instance digit21 of CodeDigit
	(properties
		x 272
		y 147
		digitLoop 7
		place 100
	)

	(method (init)
		(= bombCode global185)
		(super init: &rest)
		(= cel (mod (/ bombCode place) 10))
	)
)

(instance digit22 of CodeDigit
	(properties
		x 298
		y 147
		digitLoop 7
		place 10
	)

	(method (init)
		(= bombCode global185)
		(= myFlag 165)
		(super init: &rest)
	)
)

(instance digit23 of CodeDigit
	(properties
		x 323
		y 147
		digitLoop 7
	)

	(method (init)
		(= bombCode global185)
		(= myFlag 166)
		(super init: &rest)
	)
)

(instance digit30 of CodeDigit
	(properties
		x 349
		y 148
		digitLoop 8
		place 1000
	)

	(method (init)
		(= bombCode global186)
		(= myFlag 167)
		(super init: &rest)
	)
)

(instance digit31 of CodeDigit
	(properties
		x 375
		y 148
		digitLoop 8
		place 100
	)

	(method (init)
		(= bombCode global186)
		(= myFlag 168)
		(super init: &rest)
	)
)

(instance digit32 of CodeDigit
	(properties
		x 400
		y 148
		digitLoop 8
		place 10
	)

	(method (init)
		(= bombCode global186)
		(= myFlag 169)
		(super init: &rest)
	)
)

(instance digit33 of CodeDigit
	(properties
		x 426
		y 148
		digitLoop 8
	)

	(method (init)
		(= bombCode global186)
		(= myFlag 170)
		(super init: &rest)
	)
)

(instance digit40 of CodeDigit
	(properties
		x 452
		y 148
		digitLoop 9
		place 1000
	)

	(method (init)
		(= bombCode global187)
		(= myFlag 171)
		(super init: &rest)
	)
)

(instance digit41 of CodeDigit
	(properties
		x 478
		y 148
		digitLoop 9
		place 100
	)

	(method (init)
		(= bombCode global187)
		(= myFlag 172)
		(super init: &rest)
	)
)

(instance digit42 of CodeDigit
	(properties
		x 504
		y 148
		digitLoop 9
		place 10
	)

	(method (init)
		(= bombCode global187)
		(= myFlag 173)
		(super init: &rest)
	)
)

(instance digit43 of CodeDigit
	(properties
		x 530
		y 148
		digitLoop 9
	)

	(method (init)
		(= bombCode global187)
		(= myFlag 174)
		(super init: &rest)
	)
)

(instance sRedLights of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(buttonList eachElementDo: #setActive 0)
				(= cycles 1)
			)
			(1
				(= local1 0)
				(= local1 (buttonList at: local0))
				(local1 setLoop: (local1 downLoop:) setCel: (local1 downCel:))
				(= ticks 1)
			)
			(2
				(if (== (++ local0) (buttonList size:))
					(= local0 0)
					(= ticks 1)
				else
					(= state 0)
					(= ticks 1)
				)
			)
			(3
				(= local1 0)
				(= local1 (buttonList at: local0))
				(local1 setLoop: (local1 upLoop:) setCel: (local1 upCel:))
				(= ticks 1)
			)
			(4
				(if (== (++ local0) (buttonList size:))
					(= local0 0)
					(= state 0)
					(= ticks 1)
				else
					(= state 2)
					(= ticks 1)
				)
			)
			(5
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(buttonList eachElementDo: #dispose)
		(digitList eachElementDo: #dispose)
		(inputScreen dispose:)
		(armedSign dispose:)
		(activitySign dispose:)
		(super dispose: &rest)
	)
)

(instance BOMB_0 of Feature
	(properties
		noun 4
		nsBottom 270
		nsLeft 20
		nsRight 582
		nsTop 42
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 157)
			(= case 5)
		else
			(= case 4)
		)
		(self setHotspot: 144)
	)
)

(instance wrngSnd of Sound
	(properties
		number 8002
		flags 5
	)
)

(instance rightSnd of Sound
	(properties
		number 8003
		flags 5
	)
)

(instance alarmSnd of Sound ; UNUSED
	(properties
		number 8004
		flags 5
		loop -1
	)
)

(instance butnSnd of Sound
	(properties
		number 8007
		flags 5
	)
)

(instance disarmSnd of Sound
	(properties
		number 8008
		flags 5
	)
)

