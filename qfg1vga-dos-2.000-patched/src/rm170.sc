;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n104)
(use n106)
(use Teller)
(use n814)
(use Print)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm170 0
	f1 1
	f2 2
	f3 3
	f4 4
	f5 5
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = -1
	local7
	local8
	local9
	[local10 7]
	local17
	local18
	[local19 24] = [0 0 0 0 0 0 0 0 62 119 91 145 134 104 75 40 109 108 108 107 101 98 97 101]
	[local43 5]
	[local48 5] = [74 143 52 90 110]
	[local53 15] = [109 120 122 99 108 1 11 6 5 8 14 2 10 15 12]
	[local68 5]
	[local73 5]
	[local78 5]
	local83
	[local84 5] = [35 250 265 140 225]
	[local89 5] = [30 35 125 50 45]
	local94
	local95
	local96
	local97
	local98
	local99
	[local100 17] = [-1 0 13 22 32 38 47 59 69 78 104 113 121 128 135 141 151]
	local117
	local118
	[local119 2]
	[local121 7] = [0 -18 15 17 19 3 999]
	[local128 3] = [0 16 999]
	[local131 7]
	[local138 3] = [0 -18 999]
)

(procedure (localproc_0 &tmp temp0)
	(if (not local1)
		(= local1 1)
		(fairyFeat init:)
		(= local6 100)
	)
	(SetFlag 188)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= [local73 temp0] (Clone aChaseScript))
		(gEgo signal: (| (gEgo signal:) $1000))
		([local43 temp0]
			setStep: 6 4
			setPri: 14
			setScript: [local73 temp0] 0 temp0
		)
	)
	(= [local73 4] (Clone aChaseScript))
	(aFaery setScript: [local73 4] 0 4)
)

(procedure (localproc_1 &tmp temp0)
	(ClearFlag 188)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= [local68 temp0] (aFaeryScript new:))
		([local43 temp0] setStep: 3 2 setScript: [local68 temp0] 0 temp0)
	)
	(= [local68 4] (aFaeryScript new:))
	(aFaery setScript: [local68 4] 0 4)
)

(procedure (localproc_2 &tmp temp0 temp1)
	(ClearFlag 188)
	(= local83 80)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= [local68 temp0] (aFaeryScript new:))
		(= temp1 (Random 0 4))
		([local43 temp0]
			posn: [local84 temp1] [local89 temp1]
			setScript: [local68 temp0] 0 temp0
		)
	)
	(= [local68 4] (aFaeryScript new:))
	(aFaery setScript: [local68 4] 0 4)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= [local43 temp0] (Actor new:))
		(= [local68 temp0] (aFaeryScript new:))
		(= [local78 temp0] (fairyTeller new:))
		([local43 temp0]
			view: 70
			setLoop: temp0
			cel: 0
			posn: [local48 temp0] [local53 temp0]
			ignoreActors: 1
			illegalBits: 0
			ignoreHorizon: 1
			init:
			actions: [local78 temp0] 0 temp0
			setCycle: Fwd
			setScript: [local68 temp0] 0 temp0
			setPri: 14
		)
	)
	(= [local68 4] (aFaeryScript new:))
	(aFaery
		posn: [local48 4] [local53 4]
		setCycle: Fwd
		setScript: [local68 4] 0 4
	)
)

(class Script_ of Script
	(properties
		register2 -1
	)
)

(instance roomTimer of Timer
	(properties)
)

(instance rm170 of Rm
	(properties
		picture 70
		style 0
		horizon 37
		north 62
	)

	(method (init &tmp temp0)
		(= [local131 0] @local121)
		(= [local131 1] @local128)
		(= [local131 2] 999)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 63 71 230 71 230 88 254 88 254 144 241 144 241 156 139 156 139 123 160 114 132 102 88 102 81 111 59 111 57 103 39 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 59 140 125 140 125 161 59 161
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 66 115 102 115 132 121 132 138 97 124 66 124
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 94 0 94 54 0 54 0 0 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 54 149 54 150 -3
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 137 33 157 39 184 110 184 110 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 163 189 163 187 319 187 319 189
					yourself:
				)
		)
		(= local96 0)
		(LoadMany rsVIEW 70 71)
		(Load rsSCRIPT 964)
		(LoadMany rsSOUND 40 64)
		(LoadMany rsVIEW 510 72)
		(= local2 1)
		(fairyTeller init: aFaery @local121 @local131 @local138)
		(aFaery init:)
		(localproc_3)
		(gLongSong stop:)
		(faeryMusic init: play:)
		(egoBoogie init:)
		(bopTilYouDrop init:)
		(super init:)
		(SL enable:)
		(NormalEgo)
		(switch gPrevRoomNum
			(62
				(gCurRoom setScript: sEnterFromNorth)
			)
			(71
				(gCurRoom setScript: sEnterFromEast)
			)
			(69
				(gCurRoom setScript: sEnterFromWest)
			)
			(999
				(gEgo posn: (gEgo x:) (gEgo y:) init:)
			)
			(else
				(gCurRoom setScript: sEnterFromSouth)
			)
		)
		(mush1 init:)
		(mush2 init:)
		(mush3 init:)
		(mush4 init:)
		(mush5 init:)
		(mush6 init:)
		(mush7 init:)
		(ring init:)
		(rocks init:)
		(treesRight init:)
		(treesLeft init:)
		(theRoom init:)
		(firstTime init:)
	)

	(method (cue)
		(if local18
			(= local18 0)
			(= local117 1)
			(= local94 2)
			(gCurRoom setScript: meetFaery)
		)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(if (not local0)
			(ClearFlag 188)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose &tmp temp0)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(DisposeScript 964)
		(super dispose:)
	)

	(method (doit)
		(cond
			(script)
			((> (gEgo x:) 310)
				(HandsOff)
				(gCurRoom setScript: sExitEast)
			)
			((< (gEgo x:) 10)
				(HandsOff)
				(gCurRoom setScript: sExitWest)
			)
			((> (gEgo y:) 185)
				(HandsOff)
				(gCurRoom setScript: sExitSouth)
			)
			((== local2 0)
				(= local2 1)
				(aFaery init:)
				(fairyFeat init:)
				(localproc_3)
				(gLongSong stop:)
				(faeryMusic init: play:)
				(egoBoogie init:)
				(bopTilYouDrop init:)
			)
		)
		(cond
			((== local83 70)
				(-- local83)
				(= local117 1)
				(= local94 8)
				(gCurRoom setScript: meetFaery)
			)
			((> local83 1)
				(-- local83)
			)
			((== local83 1)
				(= local83 0)
			)
		)
		(if
			(and
				(== (gEgo onControl: 1) 16384)
				(== (User canControl:) 1)
				(not local98)
			)
			(= local98 1)
			(localproc_0)
			(= local18 0)
			(= local117 1)
			(= local94 7)
			(gCurRoom setScript: meetFaery)
		)
		(if (and (== local94 8) (== (gCurRoom script:) 0))
			(= local117 1)
			(= local94 3)
			(gCurRoom setScript: meetFaery)
		)
		(super doit:)
		(if (not (-- local6))
			(= local6 100)
			(if (or (!= local4 (gEgo x:)) (!= local5 (gEgo y:)))
				(= local4 (gEgo x:))
				(= local5 (gEgo y:))
				(fairyFeat
					x: (gEgo x:)
					y: (- (gEgo y:) 20)
					nsLeft: (- (gEgo x:) 30)
					nsTop: (- (gEgo y:) 50)
					nsBottom: (+ (gEgo y:) 10)
					nsRight: (+ (gEgo x:) 20)
				)
			)
		)
	)
)

(instance faeryMusic of Sound
	(properties
		flags -1
		number 40
		priority 1
		loop -1
	)
)

(instance egoBoogie of Sound
	(properties
		flags -1
		number 49
		priority 2
		loop -1
	)
)

(instance bopTilYouDrop of Sound
	(properties
		flags -1
		number 64
		priority 2
		loop -1
	)
)

(instance fairyFeat of Feature
	(properties
		x 98
		y 109
		z -100
		noun 1
		nsTop 68
		nsLeft 38
		nsBottom 151
		nsRight 158
		sightAngle 40
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(cond
			((IsFlag 188)
				(fairyTeller doVerb: theVerb &rest)
			)
			(local3
				(= local3 -1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance treesLeft of Feature
	(properties
		x 58
		y 94
		noun 6
		nsTop -1
		nsBottom 189
		nsRight 116
		sightAngle 40
		onMeCheck 2
	)
)

(instance treesRight of Feature
	(properties
		x 224
		y 94
		noun 5
		nsTop -1
		nsLeft 130
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)
)

(instance rocks of Feature
	(properties
		x 145
		y 101
		noun 4
		nsTop 49
		nsLeft 43
		nsBottom 153
		nsRight 247
		sightAngle 40
		onMeCheck 8
	)
)

(instance mush1 of Feature
	(properties
		x 115
		y 102
		noun 2
		nsTop 84
		nsLeft 79
		nsBottom 102
		nsRight 152
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 2 1 23) ; "The fairy ring is luminous at night."
			)
			(4 ; Do
				(if (and (not local18) (not (gEgo script:)))
					(gEgo setMotion: PolyPath 123 110)
				else
					(gMessager say: 2 4) ; "Don't you want to dance?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mush2 of Feature
	(properties
		x 71
		y 102
		noun 2
		nsTop 95
		nsLeft 64
		nsBottom 109
		nsRight 79
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setMotion: PolyPath 123 110)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush3 of Feature
	(properties
		x 80
		y 116
		noun 2
		nsTop 111
		nsLeft 72
		nsBottom 121
		nsRight 89
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setMotion: PolyPath 123 110)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush4 of Feature
	(properties
		x 113
		y 123
		noun 2
		nsTop 115
		nsLeft 97
		nsBottom 131
		nsRight 129
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setMotion: PolyPath 123 110)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush5 of Feature
	(properties
		x 156
		y 125
		noun 2
		nsTop 119
		nsLeft 144
		nsBottom 131
		nsRight 168
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setMotion: PolyPath 123 110)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush6 of Feature
	(properties
		x 163
		y 102
		noun 2
		nsTop 96
		nsLeft 153
		nsBottom 108
		nsRight 174
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setMotion: PolyPath 123 110)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance mush7 of Feature
	(properties
		x 177
		y 116
		noun 2
		nsTop 109
		nsLeft 170
		nsBottom 121
		nsRight 185
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setMotion: PolyPath 123 110)
		)
		(mush1 doVerb: theVerb &rest)
	)
)

(instance ring of Feature
	(properties
		x 137
		y 100
		z 100
		noun 2
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 2 1 23) ; "The fairy ring is luminous at night."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance aFaery of Actor
	(properties
		noun 1
		view 70
		loop 4
		priority 14
		signal 26640
		illegalBits 0
	)
)

(instance fairyTeller of Teller
	(properties)

	(method (doVerb theVerb &tmp [temp0 20])
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1) ; "The fairies look like little dancing lights, but you get a strong sense that they are female with butterfly wings."
				(return 1)
			)
			(4 ; Do
				(gMessager say: 1 4) ; "The fairies can avoid your grasp easily."
				(return 1)
			)
			(2 ; Talk
				(if local18
					(gMessager say: 1 21) ; "Don't you want to dance?"
				else
					(++ local9)
					(cond
						((and local3 (< (setUpFaerys state:) 2))
							(= local3 -1)
						)
						((> local9 5)
							(if (IsFlag 188)
								(= local117 1)
								(= local94 14)
								(gCurRoom setScript: meetFaery)
							else
								(gMessager say: 3 2 34) ; "They seem to be ignoring you."
							)
						)
						(else
							(SolvePuzzle 687 1)
							(super doVerb: theVerb &rest)
						)
					)
				)
			)
			(21 ; flask
				(cond
					(local18
						(gMessager say: 1 21) ; "Don't you want to dance?"
					)
					((IsFlag 689)
						(gMessager say: 1 21 3) ; "Don't be greedy. We already gave you some."
					)
					(local99
						(gMessager say: 1 21 20) ; "Perhaps you should be better prepared to get some fairy dust next time."
					)
					((not local17)
						(gMessager say: 1 21 22) ; "Maybe you should ask the Fairies for some. That would be the polite thing to do."
					)
					(else
						(= local117 1)
						(= local94 9)
						(gCurRoom setScript: meetFaery)
					)
				)
				(return 1)
			)
			(12 ; sword
				(localproc_0)
				(= local117 1)
				(= local94 15)
				(gCurRoom setScript: meetFaery)
				(return 1)
			)
			(16 ; dagger
				(if (gEgo has: 6) ; dagger
					(ThrowKnife 0)
					(localproc_2)
				else
					(gMessager say: 1 16) ; "You don't have a dagger."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (showDialog &tmp temp0 [temp1 20])
		(if (== (= temp0 (super showDialog: 3 local0)) 3)
			(gCurRoom setScript: getDust)
		)
		(return temp0)
	)
)

(instance aFaeryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local94 14)
					(HandsOn)
				)
				(if (> local83 0)
					(client
						setMotion:
							MoveTo
							(Random
								(- [local84 register] 25)
								(+ [local84 register] 25)
							)
							(Random
								(- [local89 register] 25)
								(+ [local89 register] 25)
							)
							self
					)
				else
					(client
						setMotion:
							MoveTo
							(Random
								(- [local48 register] 15)
								(+ [local48 register] 15)
							)
							(Random
								(- [local53 register] 15)
								(+ [local53 register] 15)
							)
							self
					)
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance aChaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(local118
						(client
							setMotion:
								MoveTo
								(- (Random (gEgo x:) (+ (gEgo x:) 10)) 18)
								(- (Random (gEgo y:) (- (gEgo y:) 8)) 50)
								self
						)
					)
					((IsFlag 187)
						(client
							setMotion:
								MoveTo
								(- (Random (gEgo x:) (+ (gEgo x:) 20)) 10)
								(- (Random (gEgo y:) (+ (gEgo y:) 40)) 50)
								self
						)
					)
					(else
						(client
							setMotion:
								MoveTo
								(- (Random (gEgo x:) (+ (gEgo x:) 70)) 40)
								(- (Random (gEgo y:) (+ (gEgo y:) 40)) 50)
								self
						)
					)
				)
			)
			(1
				(if (or (== local94 14) (== local94 8))
					(HandsOn)
				)
				(self init:)
			)
		)
	)
)

(instance deathDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local95 0)
				(gGame setCursor: gWaitCursor 1)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: PolyPath 123 113 self
				)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(faeryMusic stop:)
				(bopTilYouDrop play:)
				(gEgo view: 71)
				(self cue:)
			)
			(2
				(gEgo setLoop: (Random 0 4) cel: 0 setCycle: End self)
				(++ local95)
			)
			(3
				(cond
					((== (mod local95 3) 0)
						(gMessager say: 1 0 2) ; "Dance!"
						(self changeState: 2)
					)
					((>= local95 6)
						(= cycles 2)
					)
					(else
						(self changeState: 2)
					)
				)
			)
			(4
				(faeryMusic play:)
				(bopTilYouDrop stop:)
				(gEgo setLoop: 7 setCel: 1)
				(= cycles 10)
			)
			(5
				(gEgo cycleSpeed: 6 setCycle: End)
				(= cycles 35)
			)
			(6
				(gMessager say: 1 0 4) ; "He's no fun! He fell right over!"
				(= seconds 4)
			)
			(7
				(EgoDead 49 50 5 2 71) ; "For such wimpy-looking creatures, those fairies sure can play rough! You never danced so hard in your entire life (which is now over)."
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 350 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 71)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo -25 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 69)
			)
		)
	)
)

(instance sEnterFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not gNight)
					(FixTime 20)
					(-- state)
					(= seconds 3)
				else
					(gEgo init: posn: 350 111 setMotion: MoveTo 285 111 self)
				)
			)
			(1
				(gCurRoom setScript: setUpFaerys)
			)
		)
	)
)

(instance sEnterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not gNight)
					(FixTime 20)
					(-- state)
					(= seconds 3)
				else
					(gEgo init: posn: -25 126 setMotion: MoveTo 57 126 self)
				)
			)
			(1
				(gCurRoom setScript: setUpFaerys)
			)
		)
	)
)

(instance sEnterFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not gNight)
					(FixTime 20)
					(-- state)
					(= seconds 3)
				else
					(gEgo init: posn: 122 39 setMotion: MoveTo 122 51 self)
				)
			)
			(1
				(gCurRoom setScript: setUpFaerys)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		x 159
		y 1
		z 94
		nsTop 1
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(57 ; Talk [ REMOVED ]
				(gMessager say: 3 2) ; "Who are you talking to?"
				(return 0)
			)
			(50 ; detectMagicSpell
				(gMessager say: 3 50 23) ; MISSING MESSAGE
			)
			(2 ; Talk
				(if (not local17)
					(= local17 1)
					(if (IsFlag 186)
						(= local94 16)
					else
						(= local94 1)
					)
					(localproc_0)
					(gCurRoom setScript: meetFaery)
				)
			)
			(78 ; dazzleSpell
				(CastDazzle)
				(localproc_2)
			)
			(80 ; calmSpell
				(CastCalm)
			)
			(81 ; flameDartSpell
				(CastDart 0)
				(localproc_2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance meetFaery of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or local98 (== local94 3) (== local94 15))
					(if local98
						(gMessager say: 1 0 8 0) ; "He came into our circle!"
					)
					(gCurRoom setScript: deathDance)
				else
					(switch local94
						(1
							(SetFlag 186)
							(switch
								(Print
									addText: 3 0 33 1 0 0 ; "Don't you want to dance?"
									addButton: 0 3 0 30 1 0 20 ; "I'm not sure."
									addButton: 1 3 0 31 1 0 40 ; "Yes"
									addButton: 2 3 0 32 1 0 60 ; "No"
									init:
								)
								(0
									(= local18 1)
									(roomTimer setReal: gCurRoom 6)
									(HandsOn)
									(NormalEgo)
								)
								(1
									(= local18 0)
									(= local117 1)
									(= local94 2)
									(self changeState: 0)
								)
								(2
									(= local18 0)
									(= local117 1)
									(= local94 3)
									(self changeState: 0)
								)
							)
						)
						(16
							(switch
								(Print
									addText: 3 0 33 1 0 0 ; "Don't you want to dance?"
									addButton: 0 3 0 30 1 0 20 ; "I'm not sure."
									addButton: 1 3 0 31 1 0 40 ; "Yes"
									addButton: 2 3 0 32 1 0 60 ; "No"
									init:
								)
								(0
									(= local18 1)
									(roomTimer setReal: gCurRoom 6)
									(HandsOn)
									(NormalEgo)
								)
								(1
									(= local18 0)
									(= local117 1)
									(= local94 2)
									(self changeState: 0)
								)
								(2
									(= local18 0)
									(= local117 1)
									(= local94 3)
									(self changeState: 0)
								)
							)
						)
						(2
							(gEgo setScript: cuteDance)
						)
						(5
							(= local97 1)
						)
						(4
							(= local97 1)
						)
						(8
							(= local83 0)
							(localproc_0)
						)
						(9
							(gCurRoom setScript: getDust)
						)
						(14
							(localproc_1)
						)
						(else
							(if (not (gEgo script:))
								(HandsOn)
								(NormalEgo)
							)
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not gNight)
					(FixTime 20)
					(-- state)
					(= seconds 3)
				else
					(gEgo init: posn: 139 245 setMotion: MoveTo 139 180 self)
				)
			)
			(1
				(gCurRoom setScript: setUpFaerys)
			)
		)
	)
)

(instance f1 of Narrator
	(properties
		color 49
		special 1
	)

	(method (init)
		(self x: (Random 20 80) y: (Random 20 80))
		(super init: &rest)
	)
)

(instance f2 of Narrator
	(properties
		color 23
		special 1
	)

	(method (init)
		(self x: (Random 20 80) y: (Random 20 80))
		(super init: &rest)
	)
)

(instance f3 of Narrator
	(properties
		color 29
		special 1
	)

	(method (init)
		(self x: (Random 20 80) y: (Random 20 80))
		(super init: &rest)
	)
)

(instance f4 of Narrator
	(properties
		color 9
		special 1
	)

	(method (init)
		(self x: (Random 20 80) y: (Random 20 80))
		(super init: &rest)
	)
)

(instance f5 of Narrator
	(properties
		color 7
		special 1
	)

	(method (init)
		(self x: (Random 20 80) y: (Random 20 80))
		(super init: &rest)
	)
)

(instance gotoRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 100)
					(gEgo setMotion: PolyPath 38 94 self)
				else
					(+= state 2)
					(gEgo setMotion: PolyPath 145 179 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 54 146 self)
			)
			(2
				(gEgo setMotion: PolyPath 145 179 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance firstTime of Feature
	(properties
		x 93
		y 106
		nsTop 70
		nsLeft 43
		nsBottom 143
		nsRight 144
	)

	(method (doVerb theVerb)
		(fairyTeller doVerb: theVerb &rest)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 245 self)
			)
			(1
				(gCurRoom newRoom: 77)
			)
		)
	)
)

(instance cuteDance of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gWaitCursor 1)
				(SetFlag 187)
				(= local7 (gEgo cycleSpeed:))
				(= local8 (gEgo moveSpeed:))
				(= local0 1)
				(SolvePuzzle 688 3)
				(localproc_1)
				(gEgo ignoreActors: 1 illegalBits: 0)
				(self setScript: gotoRing self)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(if (TrySkill 2 25) ; agility
					(gMessager say: 1 0 1 0 self) ; "Then dance for us!"
				else
					(gMessager say: 1 0 6) ; "We can show it how, can't we?"
					(faeryMusic stop:)
					(egoBoogie play:)
					(gEgo setScript: klutzDance)
				)
			)
			(2
				(gEgo
					view: 71
					setLoop: 6
					setCel: 0
					xStep: 1
					yStep: 1
					cycleSpeed: 10
					moveSpeed: 10
					setCycle: Fwd
				)
				(self cue:)
			)
			(3
				(++ local95)
				(gEgo
					setMotion:
						DPath
						129
						161
						144
						166
						174
						179
						138
						185
						107
						178
						117
						164
						self
				)
			)
			(4
				(cond
					((== local95 1)
						(localproc_0)
						(self changeState: 3)
					)
					((== local95 2)
						(= local117 1)
						(= local94 5)
						(gMessager say: 1 0 7 0 self) ; "Ooooh!"
					)
					(local97
						(= local97 0)
						(= ticks 30)
					)
					((>= local95 3)
						(self changeState: 14)
					)
					(else
						(self changeState: 3)
					)
				)
			)
			(5
				(localproc_1)
				(gEgo setLoop: 5 setCel: 0 setCycle: CT 3 1 self)
			)
			(6
				(= seconds 2)
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(NormalEgo)
				(gEgo setHeading: 180)
				(= ticks 60)
			)
			(9
				(gEgo view: 71 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(10
				(gMessager say: 1 0 14) ; "Wow!"
				(= seconds 3)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(NormalEgo)
				(gEgo loop: 2)
				(= cycles 5)
			)
			(13
				(localproc_0)
				(= local117 1)
				(= local94 6)
				(gCurRoom setScript: meetFaery)
				(HandsOn)
				(gEgo cycleSpeed: local7 moveSpeed: local8 setHeading: 180)
				(self dispose:)
			)
			(14
				(gMessager say: 3 0 2) ; "I'll bet you're sorry you said that."
				(= local95 0)
				(HandsOn)
				(NormalEgo)
				(gEgo
					loop: 2
					cycleSpeed: local7
					moveSpeed: local8
					setHeading: 180
				)
				(self dispose:)
			)
		)
	)
)

(instance klutzDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 187)
				(= local0 1)
				(if (== local96 5)
					(= local96 0)
				)
				(gEgo
					view: 71
					setLoop: local96
					cel: 0
					cycleSpeed: (if local98 0 else 6)
					setCycle: End self
				)
				(++ local95)
				(++ local96)
			)
			(1
				(cond
					((== local95 6)
						(= local117 1)
						(= local94 4)
						(gMessager say: 1 0 9 0 self) ; "Hee, Hee!"
					)
					(local97
						(= local97 0)
						(faeryMusic play:)
						(egoBoogie stop:)
						(= ticks 60)
					)
					((>= local95 10)
						(self changeState: 4)
					)
					(else
						(self init:)
					)
				)
			)
			(2
				(HandsOn)
				(NormalEgo)
				(gEgo
					loop: 2
					cycleSpeed: local7
					moveSpeed: local8
					setHeading: 180
				)
				(= cycles 10)
			)
			(3
				(faeryMusic play:)
				(egoBoogie stop:)
				(localproc_0)
				(= local117 1)
				(= local94 6)
				(gMessager say: 1 0 13) ; "So what do you want?"
				(self dispose:)
			)
			(4
				(faeryMusic play:)
				(egoBoogie stop:)
				(gMessager say: 3 0 2) ; "I'll bet you're sorry you said that."
				(= local95 0)
				(HandsOn)
				(NormalEgo)
				(gEgo
					loop: 2
					cycleSpeed: local7
					moveSpeed: local8
					setHeading: 180
				)
				(self dispose:)
			)
		)
	)
)

(instance setUpFaerys of Script_
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 1)
				(or (!= (gEgo x:) register) (!= (gEgo y:) register2))
			)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(NormalEgo)
				(= local3 1)
				(EgoGait 0) ; walking
				(= register (gEgo x:))
				(= register2 (gEgo y:))
				(= cycles 2)
			)
			(1)
			(2
				(HandsOff)
				(gEgo setMotion: 0 setCycle: 0)
				(NormalEgo)
				(= local3 0)
				(= ticks 30)
			)
			(3
				(switch gPrevRoomNum
					(62
						(gEgo setHeading: 180 self)
					)
					(69
						(gEgo setHeading: 90 self)
					)
					(71
						(gEgo setHeading: 270 self)
					)
					(else
						(gEgo setHeading: 360 self)
					)
				)
				(= local6 100)
			)
			(4
				(firstTime dispose:)
				(= cycles 2)
			)
			(5
				(if (not local17)
					(= local17 1)
					(if (IsFlag 186)
						(= local94 16)
					else
						(= local94 1)
					)
					(localproc_0)
					(= ticks 30)
				else
					(self dispose:)
				)
			)
			(6
				(if (IsFlag 186)
					(gMessager say: 1 0 10 0 self) ; "Oh, it's you again!"
				else
					(SetFlag 186)
					(gMessager say: 1 0 5 0 self) ; "Ooh, looky. A human!"
				)
			)
			(7
				(gCurRoom setScript: meetFaery)
			)
		)
	)
)

(instance getDust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local99 1)
				(gEgo view: 72 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(gMessager say: 3 0 26) ; "You hold out your hand...what else could you do?"
				(= local118 1)
				(= seconds 6)
			)
			(2
				(= local117 1)
				(gMessager say: 1 0 3 0 self) ; "No peeking!"
			)
			(3
				(= cycles 10)
				(= local118 0)
			)
			(4
				(cond
					((gEgo has: 11) ; flask
						(SolvePuzzle 689 8)
						(gMessager say: 3 0 25 0 self) ; "You place the dust carefully away in an empty flask."
					)
					(
						(or
							(gEgo has: 12) ; healingPotion
							(gEgo has: 13) ; manaPotion
							(gEgo has: 14) ; staminaPotion
							(gEgo has: 19) ; ghostOil
						)
						(gMessager say: 3 0 27 0 self) ; "You realize that you need something such as an empty flask to put this fairy dust into."
					)
					(else
						(gMessager say: 3 0 28 0 self) ; "As the fairy dust sifts through your fingers, you realize that you need something to put it in. You're fresh out of empty containers."
					)
				)
			)
			(5
				(= seconds 2)
			)
			(6
				(if (gEgo has: 11) ; flask
					(= register 1)
					(gEgo use: 11 1) ; flask
				)
				(= ticks 60)
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(if register
					(gEgo get: 28) ; fairyDust
				)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

