;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use PuzzleBar)
(use Array)
(use Scaler)
(use IconBar)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm510 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0)
	(RemapColors 2 254 60) ; ByPercent
	(RemapColors 1 253 112 175 62) ; ByRange
)

(procedure (localproc_1 param1 &tmp temp0)
	(for ((= temp0 5)) (> temp0 0) ((-- temp0))
		(local2 at: temp0 (local2 at: (- temp0 1)))
	)
	(local2 at: 0 param1)
	(if
		(and
			(== (local1 at: 0) (local2 at: 0))
			(== (local1 at: 1) (local2 at: 1))
			(== (local1 at: 2) (local2 at: 2))
			(== (local1 at: 3) (local2 at: 3))
			(== (local1 at: 4) (local2 at: 4))
			(== (local1 at: 5) (local2 at: 5))
		)
		(crestPuzzle setScript: sCrest)
	)
)

(instance rm510 of GloryRm
	(properties
		noun 17
		picture 510
	)

	(method (init)
		(gGlory handsOn:)
		(super init: &rest)
		(SetFlag 373)
		(gEgo
			init:
			normalize:
			x: 160
			y: 120
			setScaler: Scaler 122 50 189 87
			changeGait:
		)
		(switch gPrevRoomNum
			(500
				(gEgo x: 103 y: 71)
				(gCurRoom setScript: sFrom500)
			)
			(662
				(gEgo x: 318 y: 110)
				(gCurRoom setScript: sFrom662)
			)
			(else
				(gEgo x: 160 y: 170)
			)
		)
		(guy1 init: approachVerbs: 4 1) ; Do, Look
		(guy2 init: approachVerbs: 4 1) ; Do, Look
		(guy3 init: approachVerbs: 4 1) ; Do, Look
		(if (IsFlag 253)
			(guy3 view: 511 loop: 2 cel: 0)
			(if (IsFlag 252)
				(guy3 loop: 1 cel: 5)
			)
		)
		(guy4 init: approachVerbs: 4 1) ; Do, Look
		(guy5 init: approachVerbs: 4 42 29 28) ; Do, theToolkit, theKeyRing, theLockpick
		(crestF init: approachVerbs: 4 1) ; Do, Look
		(relief1F init: approachVerbs: 4 1) ; Do, Look
		(relief1Teller init: relief1F 510 21 155 7)
		(relief2F init: approachVerbs: 4 1) ; Do, Look
		(relief2Teller init: relief2F 510 21 155 8)
		(relief3F init: approachVerbs: 4 1) ; Do, Look
		(relief3Teller init: relief3F 510 21 155 9)
		(relief4F init: approachVerbs: 4 1) ; Do, Look
		(relief4Teller init: relief4F 510 21 155 10)
		(relief5F init: approachVerbs: 4 1) ; Do, Look
		(relief5Teller init: relief5F 510 21 155 11)
		(reaper1F init: approachVerbs: 4 1) ; Do, Look
		(reaper2F init: approachVerbs: 4 1) ; Do, Look
		(reaper3F init: approachVerbs: 4 1) ; Do, Look
		(scythe1F init:)
		(scythe2F init:)
		(scythe3F init:)
		(grate init: approachVerbs: 4 1) ; Do, Look
		(windowFeat init:)
		(exitReaper init: setPri: 116 approachVerbs: 4 1) ; Do, Look
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 49 179 291 179 308 157 308 137 256 132 215 145 145 128 110 128 110 123 125 101 111 68 101 69 114 104 104 121 91 121 73 115 27 118 27 137 48 137 48 155 23 155
					yourself:
				)
		)
		(aDoorMat init:)
		(localproc_0)
		(torchEff init: setScaler: gEgo setCycle: RandCycle)
		(gLongSong number: 510 setLoop: -1 play:)
	)

	(method (doit)
		(if (and (aDoorMat onMe: (gEgo x:) (gEgo y:)) (not script))
			(gCurRoom setScript: sCantExit)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(aDoorMat dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(ClearFlag 373)
		(gEgo changeGait: gEgoGait)
		(if (== newRoomNumber 500)
			(gEgo solvePuzzle: 448 6)
		else
			(gEgo solvePuzzle: 447 6)
		)
		(RemapColors 0) ; Off
		(RemapColors 2 254 60) ; ByPercent
		(super newRoom: newRoomNumber)
	)
)

(instance relief1Teller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 8 (and (== gHeroType 2) (IsFlag 242))) ; Examine Relief Closely, Thief
	)

	(method (sayMessage)
		(ClearFlag 51)
		(if (== iconValue 7) ; Open Relief
			(ClearFlag 51)
			(gCurRoom setScript: sOpenRelief1)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance relief2Teller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(gCurRoom setScript: 0)
		(super
			showCases:
				12 ; Examine Relief Closely
				(or (and (== gHeroType 2) (IsFlag 242)) (== gHeroType 3)) ; Thief, Paladin
		)
	)

	(method (sayMessage)
		(ClearFlag 51)
		(cond
			((== iconValue 12) ; Examine Relief Closely
				(ClearFlag 51)
				(gCurRoom setScript: sSearchRelief2)
			)
			((== iconValue 11) ; Open Relief
				(ClearFlag 51)
				(gCurRoom setScript: sOpenRelief2)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance relief3Teller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 16 (and (== gHeroType 2) (IsFlag 242))) ; Examine Relief Closely, Thief
	)

	(method (sayMessage)
		(ClearFlag 51)
		(if (== iconValue 15) ; Open Relief
			(ClearFlag 51)
			(gCurRoom setScript: sOpenRelief3)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance relief4Teller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 20 (and (== gHeroType 2) (IsFlag 242))) ; Examine Relief Closely, Thief
	)

	(method (sayMessage)
		(ClearFlag 51)
		(if (== iconValue 19) ; Open Relief
			(ClearFlag 51)
			(gCurRoom setScript: sOpenRelief4)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance relief5Teller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				25 ; Examine Relief Closely
				(and (== gHeroType 2) (IsFlag 242)) ; Thief
				24 ; Pick Lock
				(gEgo has: 24) ; theToolkit
				26 ; Unlock Relief
				(gEgo has: 62) ; relief-key
		)
	)

	(method (sayMessage)
		(ClearFlag 51)
		(cond
			((== iconValue 24) ; Pick Lock
				(ClearFlag 51)
				(if (> (gEgo trySkill: 9 250) 0) ; pick locks
					(gCurRoom setScript: sTo662 0 1)
				else
					(gMessager say: 11 42 49) ; "You try to pick the lock hidden in the bas relief, but there is something strange about it. You suspect that the lock may be magical rather than mechanical."
				)
			)
			((== iconValue 26) ; Unlock Relief
				(ClearFlag 51)
				(gCurRoom setScript: sTo662 1)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance guy1 of Prop
	(properties
		noun 7
		approachX 56
		approachY 118
		x 55
		y 113
		view 510
		loop 5
		signal 16384
	)

	(method (doVerb theVerb)
		(relief1F doVerb: theVerb)
	)
)

(instance guy2 of Prop
	(properties
		noun 8
		approachX 76
		approachY 116
		x 83
		y 112
		view 510
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(relief2F doVerb: theVerb)
	)
)

(instance axe of Prop
	(properties
		x 83
		y 112
		view 511
		signal 16385
	)
)

(instance guy3 of Prop
	(properties
		noun 9
		approachX 155
		approachY 139
		x 174
		y 132
		view 510
		signal 16384
	)

	(method (doVerb theVerb)
		(relief3F doVerb: theVerb)
	)
)

(instance guy4 of Prop
	(properties
		noun 10
		approachX 251
		approachY 135
		x 242
		y 128
		view 510
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(relief4F doVerb: theVerb)
	)
)

(instance guy5 of Prop
	(properties
		noun 11
		approachX 268
		approachY 140
		x 284
		y 130
		view 510
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(relief5F doVerb: theVerb)
	)
)

(instance exitReaper of Prop
	(properties
		noun 4
		approachX 117
		approachY 128
		x 119
		y 129
		view 510
		loop 3
		signal 20480
	)

	(method (doVerb theVerb)
		(reaper1F doVerb: theVerb)
	)
)

(instance crestF of Feature
	(properties
		nsLeft 43
		nsTop 128
		nsRight 98
		nsBottom 150
		sightAngle 40
		approachX 92
		approachY 155
		x 75
		y 133
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(gCast eachElementDo: #perform (ScriptID 90 0) 1) ; ZCode
			(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
			(crestPuzzle init: show: dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance relief1F of Feature
	(properties
		noun 7
		nsLeft 42
		nsTop 76
		nsRight 64
		nsBottom 113
		sightAngle 180
		approachX 56
		approachY 118
		x 49
		y 92
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(relief1Teller doVerb: theVerb)
			)
			(80 ; openSpell
				(= global441 x)
				(= global442 y)
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sOpenRelief1 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance relief2F of Feature
	(properties
		noun 8
		nsLeft 74
		nsTop 68
		nsRight 95
		nsBottom 116
		sightAngle 90
		approachX 76
		approachY 116
		x 88
		y 110
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gHeroType 3) ; Paladin
					(gCurRoom setScript: sRelief2Paladin)
				else
					(relief2Teller doVerb: theVerb)
				)
			)
			(80 ; openSpell
				(= global441 88)
				(= global442 92)
				(gCurRoom setScript: sCastOpenRelief2)
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sOpenRelief2 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance relief3F of Feature
	(properties
		noun 9
		nsLeft 164
		nsTop 63
		nsRight 195
		nsBottom 135
		sightAngle 180
		approachX 155
		approachY 139
		x 179
		y 99
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (IsFlag 252))
					(if (IsFlag 253)
						(gCurRoom setScript: sRelief3Dust)
					else
						(relief3Teller doVerb: theVerb)
					)
				else
					(gMessager say: 1 4 0) ; "Nothing now remains of the former resident of this chamber."
				)
			)
			(80 ; openSpell
				(= global441 x)
				(= global442 y)
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(if (IsFlag 253)
					(if (gCurRoom script:)
						(gCurRoom setScript: 0)
					)
					(gGlory handsOn:)
					(self doVerb: 4)
				else
					(gCurRoom setScript: sOpenRelief3 0 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance relief4F of Feature
	(properties
		noun 10
		nsLeft 226
		nsTop 60
		nsRight 248
		nsBottom 126
		sightAngle 180
		approachX 251
		approachY 135
		x 237
		y 83
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(relief4Teller doVerb: theVerb)
			)
			(80 ; openSpell
				(= global441 x)
				(= global442 y)
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sOpenRelief4 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance relief5F of Feature
	(properties
		noun 11
		nsLeft 273
		nsTop 64
		nsRight 298
		nsBottom 132
		sightAngle 180
		approachX 268
		approachY 140
		x 285
		y 98
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(relief5Teller doVerb: theVerb)
			)
			(80 ; openSpell
				(= global441 x)
				(= global442 y)
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gMessager say: 11 80 0) ; "Your spell should have opened the relief, but doesn't seem to have had any effect. There is apparently a stronger magic than yours holding the door; you'll need to find the key."
				(if (gCurRoom script:)
					((gCurRoom script:) dispose:)
					(gCurRoom script: 0)
				)
				(gGlory handsOn:)
			)
			(29 ; theKeyRing
				(if (gEgo has: 62) ; relief-key
					(gCurRoom setScript: sTo662 0 3)
				else
					(gMessager say: 20 6 43) ; "You don't have a key that fits this lock."
				)
			)
			(42 ; theToolkit
				(if (> (gEgo trySkill: 9 250) 0) ; pick locks
					(gCurRoom setScript: sTo662 0 1)
				else
					(gMessager say: 11 42 49) ; "You try to pick the lock hidden in the bas relief, but there is something strange about it. You suspect that the lock may be magical rather than mechanical."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance reaper1F of Feature
	(properties
		noun 4
		nsLeft 111
		nsTop 70
		nsRight 140
		nsBottom 131
		sightAngle 180
		approachX 117
		approachY 128
		x 125
		y 100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sShakeHands)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance reaper2F of Feature
	(properties
		heading 270
		noun 5
		nsLeft 18
		nsTop 60
		nsRight 39
		nsBottom 140
		sightAngle 180
		approachX 52
		approachY 148
		x 28
		y 100
	)
)

(instance reaper3F of Feature
	(properties
		heading 100
		noun 6
		nsLeft 299
		nsTop 82
		nsRight 319
		nsBottom 180
		sightAngle 180
		approachX 291
		approachY 179
		x 309
		y 131
	)
)

(instance scythe1F of Feature
	(properties
		noun 13
		nsLeft 99
		nsTop 58
		nsRight 124
		nsBottom 69
		sightAngle 180
		x 96
		y 56
	)
)

(instance scythe2F of Feature
	(properties
		noun 14
		nsLeft 32
		nsTop 38
		nsRight 67
		nsBottom 53
		sightAngle 180
		x 49
		y 45
	)
)

(instance scythe3F of Feature
	(properties
		noun 15
		nsLeft 270
		nsTop 35
		nsRight 314
		nsBottom 55
		sightAngle 180
		x 292
		y 45
	)
)

(instance grate of Feature
	(properties
		noun 23
		nsLeft 141
		nsTop 168
		nsRight 190
		nsBottom 189
		sightAngle 40
		approachX 165
		approachY 178
		x 165
		y 178
	)
)

(instance windowFeat of Feature
	(properties
		noun 22
		nsLeft 155
		nsTop 22
		nsRight 209
		nsBottom 42
		sightAngle 40
		x 182
		y 31
	)
)

(instance sCantExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 3 4 0 0 self) ; "The door will not budge; it appears to be magically sealed. There is no obvious way to open it."
			)
			(1
				(gEgo setMotion: MoveTo 120 100 self)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCrest of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 2) (not (gEgo has: 62))) ; relief-key
			(if (== register 100)
				(localproc_0)
				(self cue:)
			else
				(Palette 2 0 8 (+= register 1)) ; PalIntensity
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crestPuzzle noHands: 1)
				(theKey setLoop: 7 1 setCel: 0 setCycle: End self)
			)
			(1
				(= ticks 30)
			)
			(2
				(if (not (gEgo has: 62)) ; relief-key
					(RemapColors 0) ; Off
					(Palette 2 0 8 0) ; PalIntensity
					(theKey x: 163 y: 70 setLoop: 8 1 cel: 0)
				else
					(= ticks 90)
				)
			)
			(3
				(if (not (gEgo has: 62)) ; relief-key
					(gEgo get: 62 1) ; relief-key
					(gMessager say: 20 6 50) ; "Spelling out the name "BORGOV" in colors has caused a secret compartment to open in the crest. Inside is a small key which you add to your keyring."
				else
					(gGlory
						setCursor:
							(IconBarCursor view: 940 loop: 0 cel: 0 yourself:)
					)
				)
				(local2 at: 5 0)
				(crestPuzzle state: (& (crestPuzzle state:) $ffdf))
			)
		)
	)
)

(instance crestPuzzle of PuzzleBar
	(properties)

	(method (init)
		((ScriptID 0 21) doit: 100) ; statusCode
		(= local6 1)
		(= local1 (IntArray with: 6 2 4 1 2 5))
		(= local2 (IntArray with: 0 0 0 0 0 0))
		(theKey setLoop: 7 1 setCel: 0 x: 178 y: 152)
		(self changeCursor: 999)
		(super init: &rest)
		(theKey init: puzzleCast)
	)

	(method (setPlane)
		(= usePlane 0)
		(plane
			bitmap: 0
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 0 10 319 199
			addCast: puzzleCast
		)
	)

	(method (addIcons))

	(method (helpYou)
		(gMessager say: 24 9 0 local6 0)
		(if (== local6 5)
			(self setScript: sCrest)
		else
			(++ local6)
		)
	)

	(method (resetPuzzle)
		(= noHands 0)
		(= local3
			((Polygon new:)
				type: PTotalAccess
				init: 74 36 136 37 136 17 158 9 180 18 182 38 238 35 261 57 270 91 249 126 241 143 201 162 160 169 114 159 74 141 52 98 51 73 62 47
				yourself:
			)
		)
		(= local4
			((Polygon new:)
				type: PTotalAccess
				init: 198 56 198 119 159 143 159 56
				yourself:
			)
		)
		(self
			add: dummyIcon helpIcon red1 orange2 yellow3 green4 blue5 violet6
			eachElementDo: #init self
			eachElementDo: #show
		)
		(crestView init: puzzleCast)
	)

	(method (dispose)
		(local1 dispose:)
		(local2 dispose:)
		(local3 dispose:)
		(local4 dispose:)
		((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
		(if script
			(script dispose:)
			(= script 0)
		)
		(if puzzleCast
			(puzzleCast dispose:)
			(= puzzleCast 0)
		)
		(plane deleteCast: self dispose:)
		(= plane 0)
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		(gCurRoom drawPic: (gCurRoom picture:) (gCurRoom style:))
		(gCast eachElementDo: #perform (ScriptID 90 0) 0) ; ZCode
		(DisposeClone self)
	)
)

(instance dummyIcon of TextIcon
	(properties
		view 512
		loop 6
		cel 0
	)

	(method (highlight))

	(method (show))

	(method (onMe param1 param2)
		(return (not (local3 onMe: param1 param2)))
	)

	(method (select)
		(gGlory setCursor: (IconBarCursor view: 940 loop: 0 cel: 0 yourself:))
		(crestPuzzle state: (& (crestPuzzle state:) $ffdf))
	)
)

(instance theKey of Prop
	(properties
		x 178
		y 152
		priority 10
		fixPriority 1
		view 512
		loop 7
	)
)

(instance red1 of TextIcon
	(properties
		nsLeft 114
		nsTop 55
		x 114
		y 55
		view 512
		value 1
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(localproc_1 value)
		)
	)
)

(instance crestView of View
	(properties
		x 51
		y 10
		view 512
		loop 9
	)
)

(instance orange2 of TextIcon
	(properties
		nsLeft 114
		nsTop 70
		x 114
		y 70
		view 512
		loop 1
		value 2
	)

	(method (select)
		(if (super select: &rest)
			(localproc_1 value)
		)
	)
)

(instance yellow3 of TextIcon
	(properties
		nsLeft 114
		nsTop 84
		x 114
		y 84
		view 512
		loop 2
		value 3
	)

	(method (select)
		(if (super select: &rest)
			(localproc_1 value)
		)
	)
)

(instance green4 of TextIcon
	(properties
		nsLeft 115
		nsTop 98
		x 115
		y 98
		view 512
		loop 3
		value 4
	)

	(method (select)
		(if (super select: &rest)
			(localproc_1 value)
		)
	)
)

(instance blue5 of TextIcon
	(properties
		nsLeft 116
		nsTop 110
		x 116
		y 110
		view 512
		loop 4
		value 5
	)

	(method (select)
		(if (super select: &rest)
			(localproc_1 value)
		)
	)
)

(instance violet6 of TextIcon
	(properties
		nsLeft 121
		nsTop 124
		x 121
		y 124
		view 512
		loop 5
		value 6
	)

	(method (select)
		(if (super select: &rest)
			(localproc_1 value)
		)
	)
)

(instance helpIcon of TextIcon
	(properties
		x 159
		y 55
		view 512
		loop 6
		cel 0
	)

	(method (highlight))

	(method (show))

	(method (onMe param1 param2)
		(if (local4 onMe: param1 param2)
			(return 1)
		else
			(return 0)
		)
	)

	(method (select)
		(crestPuzzle helpYou:)
	)
)

(instance sShakeHands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local5 (gEgo cycleSpeed:))
				(gEgo
					view: 31
					setLoop: 0
					setCel: 0
					cycleSpeed: global433
					setCycle: End self
				)
			)
			(1
				(exitReaper
					signal: (| (exitReaper signal:) $0001)
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gMessager say: 4 4 0 0 self) ; "As you shake hands with the Grim Reaper statue, the door at the top of the stairs opens. You quickly make your escape from the deadly crypt."
			)
			(3
				(exitReaper setCycle: Beg)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					cycleSpeed: local5
					normalize:
					setMotion: PolyPath 120 100 self
				)
			)
			(5
				(exitReaper signal: (& (exitReaper signal:) $fffe))
				(gEgo setMotion: PolyPath 103 71 self)
			)
			(6
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance sFrom500 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 120 100 self)
			)
			(1
				(gEgo setMotion: MoveTo 102 124 self)
			)
			(2
				(= cycles (+ (gEgo cycleSpeed:) 2))
			)
			(3
				(gEgo solvePuzzle: 446 6)
				(if (not (IsFlag 249))
					(SetFlag 249)
					(gMessager say: 20 6 42 0 self) ; "You are in a dark, dank crypt filled with bas relief figures of long-departed knights and statues of the Grim Reaper. Stairs lead back up to the entrance. A brightly-colored copy of the Borgov crest adorns part of the floor."
				else
					(self cue:)
				)
			)
			(4
				(if (and (== gHeroType 3) (not (IsFlag 250))) ; Paladin
					(gMessager say: 20 6 38 0 self) ; "Your "danger sense" tingles slightly as you enter the dark confines of this crypt."
				else
					(self cue:)
				)
			)
			(5
				(gEgo normalize: 5)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenRelief1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 (gEgo cycleSpeed:))
				(gGlory handsOff:)
				(if register
					(self cue:)
				else
					(gEgo
						view: 31
						setLoop: 1
						setCel: 0
						cycleSpeed: global433
						setCycle: End self
					)
				)
			)
			(1
				(guy1 signal: (| (guy1 signal:) $0001) setCycle: End self)
			)
			(2
				(guy1 hide:)
				(if register
					(gEgo setMotion: PolyPath 56 118 self)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(3
				(if (not register)
					(gEgo normalize: 7)
				)
				(gEgo
					setPri: 138
					setSpeed: global433
					setMotion: MoveTo 46 102 self
				)
			)
			(4
				(gEgo hide:)
				(torchEff hide:)
				(guy1 signal: (| (guy1 signal:) $0001) show: setCycle: Beg self)
			)
			(5
				(gMessager say: 20 6 40 0 self) ; "You have entered into a dark passageway. It twists and curves so that you quickly lose any sense of direction."
			)
			(6
				(= ticks 180)
			)
			(7
				(gMessager say: 20 6 39 0 self) ; "You feel, more than see, a dark door at the end of the passage. You open it by touch."
			)
			(8
				(guy4 signal: (| (guy4 signal:) $0001) setCycle: End self)
			)
			(9
				(guy4 setPri: 1 signal: (& (guy4 signal:) $fffe))
				(gEgo
					x: 216
					y: 114
					show:
					setPri: -1
					setMotion: MoveTo 251 135 self
				)
				(torchEff show:)
			)
			(10
				(guy4
					signal: (| (guy4 signal:) $0001)
					setPri: -1
					setCycle: Beg self
				)
			)
			(11
				(guy4 signal: (& (guy4 signal:) $fffe))
				(= register 0)
				(gEgo setSpeed: local5)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenRelief4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 (gEgo cycleSpeed:))
				(gGlory handsOff:)
				(guy4 signal: (| (guy4 signal:) $0001) setCycle: End self)
				(if (not register)
					(gEgo
						view: 31
						setLoop: 1
						setCel: 0
						cycleSpeed: global433
						setCycle: End self
					)
				)
			)
			(1
				(guy4 signal: (& (guy4 signal:) $fffe))
				(if register
					(gEgo setMotion: PolyPath 251 135 self)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(2
				(if (not register)
					(gEgo normalize: 7)
				)
				(guy4 setPri: 1)
				(gEgo
					setPri: 116
					setSpeed: global433
					setMotion: MoveTo 216 114 self
				)
			)
			(3
				(gEgo hide:)
				(guy4
					signal: (| (guy4 signal:) $0001)
					setPri: -1
					setCycle: Beg self
				)
			)
			(4
				(guy4 signal: (& (guy4 signal:) $fffe))
				(gMessager say: 20 6 40 0 self) ; "You have entered into a dark passageway. It twists and curves so that you quickly lose any sense of direction."
			)
			(5
				(= ticks 180)
			)
			(6
				(gMessager say: 20 6 39 0 self) ; "You feel, more than see, a dark door at the end of the passage. You open it by touch."
			)
			(7
				(guy1 signal: (| (guy1 signal:) $0001) setCycle: End self)
			)
			(8
				(guy1 setPri: 1)
				(gEgo
					x: 46
					y: 102
					show:
					setPri: -1
					setMotion: MoveTo 56 118 self
				)
			)
			(9
				(guy1
					signal: (| (guy1 signal:) $0001)
					setPri: -1
					setCycle: Beg self
				)
			)
			(10
				(= register 0)
				(gEgo setSpeed: local5)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRelief2Paladin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 20 6 46 0 self) ; "Something seems wrong about this relief. You sense danger."
			)
			(1
				(relief2Teller doVerb: 4)
			)
		)
	)
)

(instance sOpenRelief2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 (gEgo cycleSpeed:))
				(gGlory handsOff:)
				(guy2 signal: (| (guy2 signal:) $0001) setCycle: End self)
			)
			(1
				(guy2 signal: (& (guy2 signal:) $fffe))
				(axe init: setCycle: End self)
			)
			(2
				(axe setCycle: Beg self)
				(if (not register)
					(gEgo
						view: 6
						setLoop: 1
						setCel: 0
						cycleSpeed: global433
						setCycle: End
					)
				)
			)
			(3
				(axe dispose:)
				(guy2 signal: (| (guy2 signal:) $0001) setCycle: Beg self)
			)
			(4
				(guy2 signal: (& (guy2 signal:) $fffe))
				(if (not register)
					(if (< (gEgo takeDamage: 30) 1)
						(EgoDead 1 510 973 1 912) ; "You should have axed permission before searching that relief. Now the chopper has made chop suey of you."
					else
						(gEgo setLoop: 3 setCel: 0 setCycle: End self)
					)
				else
					(++ state)
					(gMessager say: 8 80 0 0 self) ; "That was a close call! Fortunately, your Open spell allowed you to watch the trap operate from a distance instead of becoming part of the axemanship demonstration."
				)
			)
			(5
				(gMessager say: 20 6 45 0 self) ; "Ouch! That axe felt like it was designed to take your head right off your shoulders. Fortunately, you're buff."
			)
			(6
				(gEgo setSpeed: local5)
				(if (not register)
					(gEgo normalize: 5)
				else
					(gEgo normalize: 6)
				)
				(= register 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCastOpenRelief2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 61 143 self)
			)
			(1
				(gCurRoom setScript: (ScriptID 13) 0 relief2F) ; castOpenScript
			)
		)
	)
)

(instance sSearchRelief2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 20 6 41 0 self) ; "Watch out! It's a trap!"
			)
			(1
				(guy2 signal: (| (guy2 signal:) $0001) setCycle: End self)
			)
			(2
				(guy2 signal: (& (guy2 signal:) $fffe))
				(axe init: setCycle: CT 1 1 self)
			)
			(3
				(axe setCycle: End)
				(gEgo
					setMotion:
						JumpTo
						(- (gEgo x:) 18)
						(+ (gEgo y:) 12)
						self
				)
			)
			(4
				(axe setCycle: Beg self)
			)
			(5
				(axe dispose:)
				(guy2 signal: (| (guy2 signal:) $0001) setCycle: Beg self)
			)
			(6
				(guy2 signal: (& (guy2 signal:) $fffe))
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenRelief3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(guy3 signal: (| (guy3 signal:) $0001) setCycle: End self)
			)
			(1
				(guy3 view: 511 setLoop: 2 setCel: 5 setCycle: Beg self)
			)
			(2
				(guy3 signal: (& (guy3 signal:) $fffe))
				(SetFlag 253)
				(gMessager say: 20 6 44 0 self) ; "Inside the coffin is an old skeleton, all that remains of a long-dead knight."
			)
			(3
				(= register 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRelief3Dust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(guy3
					signal: (| (guy3 signal:) $0001)
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(guy3 signal: (& (guy3 signal:) $fffe))
				(SetFlag 252)
				(gMessager say: 16 4 0 0 self) ; "The skeleton crumbles to dust under your touch."
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTo662 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 (gEgo cycleSpeed:))
				(gGlory handsOff:)
				(if (== register 2)
					(self cue:)
				else
					(gEgo
						view: 31
						setLoop: 0
						setCel: 0
						cycleSpeed: global433
						setCycle: End self
					)
				)
			)
			(1
				(if (!= register 1)
					(gMessager say: 11 29 0 0 self) ; "The small key from the crest opens a lock in the relief. You open the coffin lid to reveal a dark passageway leading deep into the mountainside."
				else
					(gMessager say: 21 155 24 0 self) ; "Using your Thieves' toolkit, you manage to spring the lock on the coffin lid. It opens to reveal a dark, narrow passage leading deep into the heart of the mountain."
				)
			)
			(2
				(guy5 signal: (| (guy5 signal:) $0001) setCycle: End self)
			)
			(3
				(guy5 signal: (& (guy5 signal:) $fffe))
				(gEgo normalize: 6)
				(if (== register 2)
					(gEgo ignoreActors: 1 setMotion: PolyPath 268 140 self)
				else
					(self cue:)
				)
			)
			(4
				(gEgo setMotion: MoveTo 300 120 self)
			)
			(5
				(if (or (!= (gEgo x:) 300) (!= (gEgo y:) 120))
					(gEgo setMotion: MoveTo 300 120 self)
				else
					(self cue:)
				)
			)
			(6
				(guy5 signal: (| (guy5 signal:) $0001) setCycle: Beg self)
			)
			(7
				(guy5 signal: (& (guy5 signal:) $fffe))
				(gEgo setSpeed: local5)
				(gCurRoom newRoom: 662)
			)
		)
	)
)

(instance sFrom662 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(guy5 signal: (| (guy5 signal:) $0001) setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 268 140 self)
			)
			(2
				(guy5 setCycle: Beg self)
			)
			(3
				(guy5 signal: (& (guy5 signal:) $fffe))
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance torchEff of Prop
	(properties
		view 775
	)

	(method (onMe)
		(return 0)
	)

	(method (doit)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(= z (+ (gEgo z:) 8))
		(super doit: &rest)
	)
)

(instance aDoorMat of Polygon
	(properties)

	(method (init)
		(super init: 99 89 127 89 119 78 96 78)
	)
)

