;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use TargFeature)
(use n026)
(use MChase)
(use Dialog)
(use PAvoider)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm700 0
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
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	[local18 2]
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28 = 1
	local29
	local30
	local31
	local32
	local33
	local34 = 340
	local35
	local36
	local37
	local38
	[local39 2] = [8 0]
	local41
	local42
	local43
	local44
	local45
	[local46 2] = [700 705]
	local48
	[local49 4] = [-20 170 160 340]
	[local53 4] = [165 -10 260 165]
	local57
	[local58 2]
	local60
	local61
	local62
	local63
	[local64 2]
	[local66 4] = [20 -20 10 -10]
	[local70 48] = [-23 -23 -38 -38 10 -10 -20 20 -34 -34 -22 22 0 1 2 3 0 1 0 1 4 5 4 4 4 5 4 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
)

(procedure (localproc_0 &tmp [temp0 2] temp2 temp3)
	(= local48
		(+
			(<<
				(^
					(= local45
						(+ local41 (* (+ local42 15) 3) (* (+ local43 30) 2))
					)
					local41
				)
				$0001
			)
			(& $0001 (+ local42 local43))
		)
	)
	(= local44 (mod (+ local41 local42 local43) 2))
	(switch (mod (+ local41 (* local42 local43)) 4)
		(0
			(= local60 1)
		)
		(1
			(= local60 0)
		)
		(2
			(= local60 1)
		)
		(3
			(= local60 0)
		)
	)
	(if gCast
		(gCast eachElementDo: #dispose eachElementDo: #delete release:)
	)
	(if gAddToPics
		(gAddToPics eachElementDo: #dispose eachElementDo: #delete release:)
	)
	(Animate (gCast elements:) 0)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) eachElementDo: #dispose release:)
	)
	(if local44
		(gCurRoom picture: 700 curPic: 700)
		(if local60
			(gCurRoom
				style: 16393
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: -15 220 -15 151 121 151 151 167 151 220
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 190 220 190 167 218 152 330 152 330 220
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 330 115 243 114 164 79 154 43 154 -15 330 -15
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: -15 -15 122 -15 122 43 116 74 59 120 -15 117
						yourself:
					)
			)
		else
			(gCurRoom
				style: 9
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: -15 -15 168 -15 168 43 159 78 66 119 -15 119
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 190 -15 330 -15 330 119 255 119 200 76 190 41
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: -15 220 -15 158 121 158 128 220
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 172 220 176 155 330 154 330 220
						yourself:
					)
			)
		)
	else
		(gCurRoom picture: 705 curPic: 705)
		(if local60
			(gCurRoom
				style: 16393
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: -15 220 -15 169 136 170 155 220
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: -15 -15 188 -15 188 27 178 93 136 139 -15 138
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 330 158 223 147 207 27 207 -15 330 -15
						yourself:
					)
			)
		else
			(gCurRoom
				style: 9
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: -15 -15 113 -15 113 26 91 146 -15 156
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 330 142 182 142 146 98 129 28 129 -15 330 -15
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 161 220 188 172 330 172 330 220
						yourself:
					)
			)
		)
	)
	(DrawPic (gCurRoom picture:) (gCurRoom style:) 1)
	(= temp2 0)
	(for ((= temp3 1)) (< temp2 6) ((<<= temp3 $0001))
		(if (& local48 temp3)
			((ScriptID 703 0) ; InitAddTos
				init: temp2 local45 local60 local42 local43 local44
			)
		)
		(++ temp2)
	)
	(DisposeScript 703)
	(if local37
		(fireWood
			view: 700
			approachVerbs: 19 4 ; theTinderbox, Do
			approachX: 176
			approachY: 170
			loop: 7
			cel: 0
			x: 146
			y: 160
			init:
		)
	)
)

(procedure (localproc_1 param1 &tmp temp0 [temp1 2] temp3 temp4)
	(= temp3 -100)
	(for ((= temp0 0)) (!= temp3 30583) ((++ temp0))
		(= temp3 (WordAt param1 (* 2 temp0)))
	)
	(-- temp0)
)

(procedure (localproc_2 param1)
	(return
		(or
			(< (param1 x:) -80)
			(> (param1 x:) 399)
			(< (param1 y:) -80)
			(> (param1 y:) 269)
		)
	)
)

(procedure (localproc_3 param1 param2 param3 &tmp temp0)
	(for
		((= temp0 1))
		(Message msgGET gCurRoomNum param1 param2 param3 temp0)
		((++ temp0))
	)
	(-- temp0)
)

(instance controls of Controls
	(properties)
)

(instance sFx of Sound
	(properties)
)

(instance leopardProject of Actor
	(properties
		signal 4096
	)

	(method (init &tmp temp0 temp1)
		(switch (= temp0 (Random 0 2))
			(0
				(gLongSong2 number: 13 setLoop: 1 play:)
				(= temp1 2)
			)
			(1
				(gLongSong2 number: 943 setLoop: 1 play:)
				(= temp1 13)
			)
			(2
				(gLongSong2 number: 11 setLoop: 1 play:)
				(= temp1 4)
			)
		)
		(self
			view: 21
			loop: temp1
			x: (+ (it x:) (/ (* (it scaleY:) [local66 (it loop:)]) 128))
			y: (+ (it y:) (/ (* (it scaleY:) [local70 (it loop:)]) 128))
			setStep: 8 5
			moveSpeed: 0
			cycleSpeed: 0
			z: 15
			signal: 6160
			priority: (Max (it priority:) (gEgo priority:))
			ignoreActors: 1
			ignoreHorizon: 1
			illegalBits: 0
			setScale: -1 it
			setCycle: Fwd
			setMotion:
				MoveTo
				(/ (+ (gEgo nsLeft:) (gEgo nsRight:)) 2)
				(+ (gEgo nsTop:) 25)
				self
		)
		(switch temp0
			(0
				(-= global432 global373)
			)
			(1
				(-= global432 global375)
			)
			(2
				(-= global432 global380)
			)
		)
		(super init:)
		(SetNowSeen self)
	)

	(method (doit)
		(super doit:)
		(cond
			((== gHeroType 0) ; Fighter
				(if (== (gTheIconBar curInvIcon:) (gInventory at: 5)) ; theShield
					(= local11 1)
					(= local10 0)
				else
					(= local11 0)
				)
			)
			((== gHeroType 3) ; Paladin
				(if
					(and
						(== (gTheIconBar curInvIcon:) (gInventory at: 1)) ; theSword
						((gInventory at: 1) state:) ; theSword
					)
					(= local10 1)
					(= local11 0)
				else
					(= local10 0)
				)
			)
		)
		(cond
			(
				(and
					(gEgo onMe: (/ (+ nsRight nsLeft) 2) (+ nsTop 4))
					(not noun)
				)
				(= noun 1)
				(self cue: 0)
			)
			((and noun (it onMe: (/ (+ nsRight nsLeft) 2) (+ nsTop 4)))
				(self cue: 0)
			)
		)
	)

	(method (setScript)
		(if (IsObject script)
			(DisposeClone script)
			(= script 0)
		)
		(super setScript: &rest)
	)

	(method (cue param1 &tmp temp0)
		(cond
			((not script)
				(= temp0 0)
				(cond
					(
						(and
							(gEgo onMe: (/ (+ nsRight nsLeft) 2) (+ nsTop 4))
							(not global210)
							(not local11)
						)
						(cond
							((not local10)
								(= local28 0)
								(gLongSong2 number: 901 setLoop: 1 play:)
								(if (not (gEgo takeDamage: 20))
									(gCurRoom setScript: egoIsDead)
								)
							)
							((not local9)
								(= local9 1)
								(gMessager say: 4 6 91) ; "Your sword absorbs the energy of the Leopardman's spell."
							)
						)
						(= temp0 1)
					)
					(
						(and
							(gEgo onMe: (/ (+ nsRight nsLeft) 2) (+ nsTop 4))
							(or global210 local11)
						)
						(self setMotion: MoveTo (it x:) (it y:) self)
						(sFx number: 10 setLoop: 1 play:)
						(if (and local11 (not local8))
							(= local8 1)
							(gMessager say: 4 6 92) ; "Your shield reflects the Leopardman's spell."
						)
					)
					((it onMe: (/ (+ nsRight nsLeft) 2) (+ nsTop 4))
						(it getHurt: -1 0)
						(= temp0 1)
					)
					(else
						(= temp0 1)
					)
				)
				(if (and (not cycleSpeed) temp0)
					(self
						cycleSpeed: 1
						setMotion: 0
						setScript: (explode new:) self
					)
				)
			)
			((and argc param1)
				(DisposeClone script)
				(= script 0)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if (IsObject script)
			(DisposeClone script)
			(= script 0)
		)
		(super dispose:)
	)
)

(instance explode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== (client loop:) 2)
						(client loop: 9 cel: 0 setCycle: End self)
					)
					((== (client loop:) 4)
						(client loop: 10 cel: 0 setCycle: End self)
					)
					(else
						(client loop: 14 cel: 0 setCycle: End self)
					)
				)
				(gLongSong2 number: 930 setLoop: 1 play:)
			)
			(1
				(client cue: 1)
			)
		)
	)
)

(instance rm700 of Rm
	(properties
		noun 79
		picture 700
		horizon 41
		vanishingY 37
	)

	(method (init &tmp temp0)
		(= number gCurRoomNum)
		(= controls controls)
		(= gPerspective picAngle)
		(= curPic picture)
		(= gOverlays -1)
		(if (== gPrevRoomNum 550) ; combatRm
			(= local1 1)
			(= local41 global430)
			(= local42 global428)
			(= local43 global429)
			(= gPrevRoomNum global427)
			(= local44 (& global431 $0001))
			(= local28 (& global431 $0002))
			(localproc_0)
			(gEgo
				init:
				normalize:
				setScale: Scaler 120 59 189 47
				posn: 150 156
				signal: 2
				noun: 2
			)
			(switch global155
				(0
					(self setScript: egoIsDead)
				)
				(1
					(gLongSong setLoop: -1 changeTo: 400)
					(= local30 1)
					(it x: 210 y: 150 init:)
					(if (== global365 590)
						(it loop: 1 cel: 7)
					)
					(switch global365
						(590
							(gEgo solvePuzzle: 295 2 9)
						)
						(595
							(gEgo solvePuzzle: 290 2 9)
						)
						(580
							(gEgo solvePuzzle: 291 2 9)
						)
						(575
							(gEgo solvePuzzle: 296 2 9)
						)
						(565
							(gEgo solvePuzzle: 293 2 9)
						)
						(585
							(gEgo solvePuzzle: 292 2 9)
						)
					)
					(self setScript: monsterIsDead)
				)
				(2
					(= local3 1)
					(gEgo changeGait: 1) ; running
					(self setScript: encounterScript)
					(gLongSong setLoop: -1 changeTo: 700)
				)
			)
		else
			(gLongSong setLoop: -1 changeTo: 400)
			(= global432 230)
			(= global156 0)
			(= global426 0)
			(= local41 (Random 64 256))
			(= local42 (= local43 (Random 5 127)))
			(switch global365
				(74
					((ScriptID 705 0) init: 4 6 95) ; askFire
					(switch global460
						(1
							(= local37 1)
						)
						(2 0)
					)
					(= local42 (= local43 128))
					(= local41 192)
					(= local38 0)
					(= local30 1)
					(localproc_0)
					(gEgo
						x: (if local44 245 else 182)
						y: (if local44 80 else 125)
						init:
						signal: 2
						normalize:
						setScale: Scaler 120 59 189 47
						posn: 240 156
						noun: 2
					)
				)
				(590
					(localproc_0)
					(gEgo
						init:
						normalize:
						signal: 2
						setScale: Scaler 120 59 189 47
						posn: 160 156
						noun: 2
					)
					(if (IsFlag 96)
						(self setScript: monkeysWithEgo)
						(gGame save: 1)
					else
						(self setScript: encounterScript)
					)
				)
				(6
					(= local38 1)
					(localproc_0)
					(HandsOn)
					(gEgo
						init:
						normalize:
						signal: 2
						setScale: Scaler 120 59 189 47
						posn: 160 156
						noun: 2
					)
					(ClearFlag 105)
					(cond
						((& global431 $4000)
							(= global431 (| (&= global431 $bfff) $2000))
						)
						((and (IsFlag 102) (& global431 $8000))
							(= global431 (| (&= global431 $7fff) $4000))
						)
						((and (not (IsFlag 102)) (not (& global431 $8000)))
							(|= global431 $8000)
						)
					)
					(self setScript: (ScriptID 702 1)) ; startUp
					((ScriptID 702 0) init:) ; egoTell
				)
				(8
					(= local41 88)
					(= local42 (= local43 77))
					(localproc_0)
					(gEgo
						init:
						normalize:
						setScale: Scaler 120 59 189 47
						signal: 2
						posn: 160 156
						noun: 2
					)
					(self setScript: (ScriptID 701 2)) ; manuInCage
				)
				(9
					(SetFlag 105)
					(= local41 88)
					(= local42 (= local43 77))
					(localproc_0)
					(gEgo
						init:
						normalize:
						signal: 2
						setScale: Scaler 120 59 189 47
						posn: 160 156
						noun: 2
					)
					(self setScript: (ScriptID 701 5)) ; manuEncounter2
				)
				(7
					(= local41 88)
					(= local42 (= local43 77))
					(localproc_0)
					(gEgo
						init:
						normalize:
						signal: 2
						setScale: Scaler 120 59 189 47
						posn: 160 156
						noun: 2
					)
					(= local38 0)
					(self setScript: (ScriptID 704 0)) ; startUp
					(HandsOn)
				)
				(10
					(= local41 88)
					(= local42 (= local43 77))
					(localproc_0)
					(gEgo
						init:
						normalize:
						signal: 2
						setScale: Scaler 120 59 189 47
						posn: 160 156
						noun: 2
					)
					(if (not (IsFlag 116))
						((= local20 (Actor new:))
							view: 700
							loop: 5
							cel: 0
							x: 77
							y: 12
							priority: 15
							signal: 20496
							actions: genericProp
							noun: 81
							init:
						)
					)
					((View new:)
						view: 700
						loop: 4
						cel: 0
						x: 90
						y: 12
						priority: 15
						signal: 20496
						actions: genericProp
						noun: 81
						init:
					)
					((View new:)
						view: 700
						loop: 4
						cel: 1
						x: 85
						y: 18
						priority: 15
						signal: 20496
						actions: genericProp
						noun: 81
						init:
					)
					((View new:)
						view: 700
						loop: 5
						cel: 1
						x: 83
						y: 17
						priority: 15
						signal: 20496
						actions: genericProp
						noun: 81
						init:
					)
					(genericProp
						nsLeft: 63
						nsTop: 5
						nsRight: 100
						nsBottom: 22
						noun: 81
					)
					(HandsOn)
				)
				(4
					(= local30 1)
					(= local36 (localproc_3 6 1 80))
					(= local38 0)
					(= local42 (= local43 128))
					(= local41 192)
					(localproc_0)
					(gEgo
						x: 160
						y: 156
						init:
						setAvoider: PAvoider
						normalize:
						signal: 2
						setScale: Scaler 120 59 189 47
						noun: 2
					)
					(genericProp init:)
					(HandsOn)
				)
				(5
					(= local30 1)
					(= local38 0)
					(= local42 (= local43 128))
					(= local41 192)
					(localproc_0)
					(gEgo
						x: 160
						y: 156
						init:
						normalize:
						signal: 2
						setAvoider: PAvoider
						setScale: Scaler 120 59 189 47
						noun: 2
					)
					(genericProp approachVerbs: 4 init:) ; Do
					(HandsOn)
				)
				(else
					(localproc_0)
					(gEgo
						init:
						normalize:
						signal: 2
						setScale: Scaler 120 59 189 47
						posn: 160 156
						noun: 2
					)
					(if (!= global365 999)
						(self setScript: encounterScript)
						(= local38 1)
					)
				)
			)
		)
		(Animate (gCast elements:) 1)
	)

	(method (doit)
		(if (and local38 (IsFlag 102) (== global365 6))
			(= local38 0)
		)
		(cond
			(script
				(if (== global365 10)
					(if (> (gEgo z:) 70)
						(gTheIconBar enable: 3)
					else
						(gTheIconBar disable: 3)
					)
				)
			)
			(local57
				(if (and (<= 4 (gEgo x:) 316) (<= 48 (gEgo y:) 185))
					(= local57 0)
					(HandsOn)
				)
			)
			((<= (gEgo x:) 3)
				(cond
					((and (== global365 6) (IsFlag 102) (not (IsFlag 105)))
						(= local57 1)
						(gMessager say: 3 6 20) ; "Oh, no you don't. Get back here and help me figure out what to do!"
						(gEgo setMotion: PolyPath 20 (gEgo y:))
					)
					((and (== global365 9) (IsFlag 105))
						(= local57 1)
						(gMessager say: 5 6 101) ; "No go. Manu very sad. Man-friend stay with Manu. Manu very happy."
						(gEgo setMotion: PolyPath 20 (gEgo y:))
					)
					(else
						(= local24 1)
						(if (not local38)
							(= local42 -20)
							(= local43 (gEgo y:))
							(self setScript: sExit)
						else
							(self setScript: showNewRoom self 4)
						)
					)
				)
			)
			((>= (gEgo y:) 187)
				(cond
					((and (== global365 6) (IsFlag 102) (not (IsFlag 105)))
						(= local57 1)
						(gMessager say: 3 6 20) ; "Oh, no you don't. Get back here and help me figure out what to do!"
						(gEgo setMotion: PolyPath (gEgo x:) 170)
					)
					((and (== global365 9) (IsFlag 105))
						(= local57 1)
						(gMessager say: 5 6 101) ; "No go. Manu very sad. Man-friend stay with Manu. Manu very happy."
						(gEgo setMotion: PolyPath (gEgo x:) 170)
					)
					(else
						(= local24 1)
						(if (not local38)
							(= local42 (gEgo x:))
							(= local43 250)
							(self setScript: sExit)
						else
							(self setScript: showNewRoom self 3)
						)
					)
				)
			)
			((>= (gEgo x:) 317)
				(cond
					((and (== global365 6) (IsFlag 102) (not (IsFlag 105)))
						(= local57 1)
						(gMessager say: 3 6 20) ; "Oh, no you don't. Get back here and help me figure out what to do!"
						(gEgo setMotion: PolyPath 300 (gEgo y:))
					)
					((and (== global365 9) (IsFlag 105))
						(= local57 1)
						(gMessager say: 5 6 101) ; "No go. Manu very sad. Man-friend stay with Manu. Manu very happy."
						(gEgo setMotion: PolyPath 300 (gEgo y:))
					)
					(else
						(= local24 1)
						(if (not local38)
							(= local42 330)
							(= local43 (gEgo y:))
							(self setScript: sExit)
						else
							(self setScript: showNewRoom self 2)
						)
					)
				)
			)
			((<= (gEgo y:) 45)
				(cond
					((and (== global365 6) (IsFlag 102) (not (IsFlag 105)))
						(= local57 1)
						(gMessager say: 3 6 20) ; "Oh, no you don't. Get back here and help me figure out what to do!"
						(gEgo
							setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 10)
						)
					)
					((and (== global365 9) (IsFlag 105))
						(= local57 1)
						(gMessager say: 5 6 101) ; "No go. Manu very sad. Man-friend stay with Manu. Manu very happy."
						(gEgo
							setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 10)
						)
					)
					(else
						(= local24 1)
						(if (not local38)
							(= local42 (gEgo x:))
							(= local43 vanishingY)
							(self setScript: sExit)
						else
							(self setScript: showNewRoom self 1)
						)
					)
				)
			)
		)
		(super doit: &rest)
	)

	(method (cue &tmp temp0)
		(if (== global365 580)
			(gEgo setScale: Scaler 120 59 189 47)
		else
			(super cue:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Rest
				(if local38
					(gMessager say: 0 0 93) ; "This is not a good time to rest."
				else
					((ScriptID 7 5) init: global455) ; egoRests
				)
			)
			(74 ; Sleep
				(if (and local30 (not local38))
					(= global365 74)
					(= local17 1)
					(self setScript: sleepScript 0 0)
				else
					(gMessager say: 4 6 16) ; "Now would not be a good time to sleep."
				)
			)
			(20 ; theDaggers
				(++ global426)
				(if (OneOf global365 580 8 9)
					(gEgo setScale:)
				)
				(gEgo setScript: (ScriptID 32 0) self 20) ; project
			)
			(81 ; flameDartSpell
				(if (gEgo castSpell: 25)
					(if (OneOf global365 580 8 9)
						(gEgo setScale:)
					)
					(gEgo setScript: (ScriptID 32 0) self 81) ; project
				)
			)
			(-77 ; triggerSpell
				(gMessager say: 0 0 2 1 0 12) ; "Nothing seems to have been triggered."
			)
			(-76 ; detectMagicSpell
				(gMessager say: 0 0 1 1 0 12) ; "You sense no magic in this area."
			)
			(-80 ; calmSpell
				(gMessager say: 0 0 4 1 0 12) ; "A feeling of peace and tranquility fills the area."
			)
			(83 ; forceBoltSpell
				(if (gEgo castSpell: 27)
					(if (OneOf global365 580 8 9)
						(gEgo setScale:)
					)
					(gEgo setScript: (ScriptID 32 0) self 83) ; project
				)
			)
			(88 ; lightningBallSpell
				(if (gEgo castSpell: 32)
					(if (OneOf global365 580 8 9)
						(gEgo setScale:)
					)
					(gEgo setScript: (ScriptID 32 0) self 88) ; project
				)
			)
			(80 ; calmSpell
				(if (gEgo castSpell: 24)
					(= local2 1)
					((Timer new:) setReal: self (/ [gEgoStats 24] 10)) ; calmSpell
					(gEgo setScript: (ScriptID 12 0) self 80) ; castAreaScript
				)
			)
			(75 ; openSpell
				(if (gEgo castSpell: 19)
					(proc0_14 ((User curEvent:) x:) ((User curEvent:) y:))
					(if (and (== global365 8) (not (IsFlag 109)))
						(gEgo setScript: (ScriptID 13) 0 (ScriptID 701 6)) ; castOpenScript, cage
					else
						(gEgo setScript: (ScriptID 13)) ; castOpenScript
					)
				)
			)
			(77 ; triggerSpell
				(if (gEgo castSpell: 21)
					(if (== (genericProp noun:) 7)
						(gEgo setScript: (ScriptID 12 0) genericProp) ; castAreaScript
					else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(84 ; levitateSpell
				(if (gEgo castSpell: 28)
					((ScriptID 31 0) init: (gEgo x:) (+ (gEgo y:) 1) 80) ; leviCode
				)
			)
			(82 ; fetchSpell
				(if (gEgo castSpell: 26)
					(cond
						((== global365 10)
							(if (not script)
								(self setScript: (ScriptID 37 0) 0 genericProp) ; castFetchScript
							)
						)
						((not script)
							(self setScript: (ScriptID 37 0)) ; castFetchScript
						)
					)
				)
				(return 1)
			)
			(86 ; jugglingLightsSpell
				(cond
					(local38
						(gMessager say: 4 6 99) ; "The monster isn't likely to be impressed by a few pretty lights."
					)
					((gEgo castSpell: 30)
						(gEgo setScript: (ScriptID 62 0)) ; castJuggle
					)
				)
			)
			(87 ; summonStaffSpell
				(if (gEgo castSpell: 31)
					(gEgo setScript: (ScriptID 46 0)) ; staffScript
				)
			)
			(78 ; dazzleSpell
				(if (gEgo castSpell: 22)
					((Timer new:) setReal: self (/ [gEgoStats 22] 10)) ; dazzleSpell
					(gEgo setScript: (ScriptID 12 0) self 78) ; castAreaScript
				)
			)
			(33 ; theRocks
				(if (OneOf global365 580 8 9)
					(gEgo setScale:)
				)
				(gEgo setScript: (ScriptID 32 0) self 33) ; project
			)
			(85 ; reversalSpell
				(if (gEgo castSpell: 29)
					(= global210 [gEgoStats 29]) ; reversalSpell
					(sFx number: 943 setLoop: 1 play:)
					(gEgo setScript: (ScriptID 12 0) self 85) ; castAreaScript
				)
			)
			(4 ; Do
				(if (> ((User curEvent:) y:) 100)
					(gEgo setScript: getRocks)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if timer
			(timer dispose: delete:)
		)
		(= global461 0)
		(= global462 0)
		(super dispose:)
	)
)

(instance monkeysWithEgo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 701 0) self) ; monkeysWith
			)
			(1
				(gCurRoom setScript: encounterScript)
			)
		)
	)
)

(instance paladinHearsMonster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
				(= register (Narrator y:))
			)
			(1
				(Narrator y: 20)
				(gMessager say: 4 6 96) ; "Your Paladin instincts warn you of approaching danger."
				(gEgo setLoop: 5 cel: 3 setCycle: End self)
			)
			(2
				(Narrator y: register)
				(gEgo x: (+ (gEgo x:) 25) normalize:)
				(= cycles 10)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance doBattle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
				(if (IsObject (gEgo looper:))
					((gEgo looper:) dispose:)
				)
				(gEgo looper: 0 setMotion: 0)
			)
			(1
				(gMessager say: 4 6 51) ; "It's time to prove yourself."
				(= cycles 2)
			)
			(2
				(if (< global156 2)
					(= global156 2)
				)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance getRocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: 0
					view: 4
					loop: (mod (gEgo loop:) 2)
					setCycle: End self
				)
				(= register (Narrator y:))
			)
			(1
				(Narrator y: 20)
				(gMessager say: 4 6 89 0 self) ; "You pick up a few rocks just the right size for throwing."
				(gEgo get: 23 (Random 2 5)) ; theRocks
			)
			(2
				(Narrator y: register)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance encounterScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo normalize:)
				(HandsOn)
				(switch global365
					(595
						(= local63 100)
						(if (not global156)
							(= global156 180)
						)
						(= global462 800)
					)
					(565
						(= local63 40)
						(if (not global156)
							(= global156 150)
						)
						(= global462 600)
					)
					(585
						(= local63 30)
						(if (not global156)
							(= global156 200)
						)
						(= global462 700)
					)
					(580
						(= local63 30)
						(if (not global156)
							(= global156 150)
						)
						(= global462 700)
					)
					(575
						(= local63 30)
						(if (not global156)
							(= global156 180)
						)
						(= global462 700)
					)
					(590
						(= local63 50)
						(if (not global156)
							(= global156 200)
						)
						(= global462 700)
					)
				)
				(self cue:)
			)
			(2
				(= local30 0)
				(if local3
					(if (== global102 0)
						(it signal: (& (it signal:) $bfff))
						(= local6 200)
					)
					(it x: 300 y: 150 init:)
					(gEgo setMotion: PolyPath -10 (gEgo y:))
				else
					(= local6 50)
					(if (and (IsFlag 150) (not local0))
						(gMessager say: 4 6 96) ; "Your Paladin instincts warn you of approaching danger."
					)
					(= temp0 (Random 0 3))
					(it x: [local49 temp0] y: [local53 temp0] init:)
				)
				(= local38 1)
				(gLongSong setLoop: -1 number: 700 play:)
				(self dispose:)
			)
		)
	)
)

(instance genericProp of Prop
	(properties)

	(method (init)
		(|= signal $1000)
		(if (== global365 5)
			(= view 700)
			(= cel 0)
			(= loop (Random 9 10))
			(= x 180)
			(= y 147)
			(= noun 7)
			(= approachX x)
			(= approachY 155)
		else
			(= view 700)
			(= loop 8)
			(= cel (Random 0 3))
			(= x 181)
			(= y 166)
			(= noun 6)
			(= local35 (Random 1 local36))
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== global365 10)
						(if
							(and
								(>= (gEgo z:) 75)
								(gEgo inRect: 70 170 110 190)
							)
							(if (IsObject local20)
								(local20 dispose:)
								(ClearFlag 132)
								(gEgo get: 39 solvePuzzle: 317 3 2) ; theOrchid
								(gMessager say: 4 6 12) ; "You carefully pick one of the orchids."
								(SetFlag 116)
							else
								(gMessager say: 4 6 13) ; "You don't need another orchid. Besides, they're an endangered plant species."
							)
						else
							(gMessager say: 4 6 14) ; "You're not close enough."
						)
					)
					((== noun 6)
						(gMessager say: 6 4 79) ; "It wouldn't be nice to steal the sign. Besides, someone might see you take it. (You never know when a policeman will come wandering through the trackless jungle.)"
					)
					((== cel 0)
						(self setCycle: End self)
						(= local4 1)
						(gLongSong2 number: 401 setLoop: 1 play:)
						(gEgo addHonor: 10)
					)
					(else
						(gMessager say: 7 6 81) ; "There is no need to spring that trap because it has already been sprung."
					)
				)
			)
			(1 ; Look
				(cond
					((== global365 10)
						(super doVerb: theVerb &rest)
					)
					((== global365 4)
						(gMessager say: 6 1 80 local35)
					)
					((== cel 0)
						(gMessager say: 7 6 82) ; "You see a trap set to catch animals."
					)
					(else
						(gMessager say: 7 1 81) ; "You can see a trap that has been sprung. Something small and very dead hangs from it."
					)
				)
			)
			(-82 ; fetchSpell
				(if (== global365 10)
					(if (IsObject local20)
						(local20 dispose:)
						(gEgo solvePuzzle: 317 3 get: 39) ; theOrchid
						(gMessager say: 4 6 15) ; "You magically fetch one of the orchids."
						(SetFlag 116)
					else
						(gMessager say: 4 6 13) ; "You don't need another orchid. Besides, they're an endangered plant species."
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (== global365 5)
			(if (or (not local4) local5)
				(self doVerb: 4)
			else
				(= local5 1)
				(gMessager say: 7 6 83) ; "You spring the trap so that it will no longer be a threat."
			)
		else
			(super cue:)
		)
	)
)

(instance egoIsDead of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo
					view: 43
					loop: (Random 0 3)
					cel: 0
					cycleSpeed: 10
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(switch global365
					(595
						(EgoDead 1 700 633 End 158) ; "... and everything else? This refugee from a Leopard colony spelled cat-astrophe to you."
					)
					(590
						(if (IsFlag 96)
							(EgoDead 2 700 707 End 158) ; "As you are slashed to monster hash, you have the satisfaction of knowing that Manu was right -- this is a bad thing. You just wish you had been better."
						else
							(EgoDead 84 700 707 End 158) ; "It's like something from out of this world. Now so are you. The Demon worm hooked you, line and sinker."
						)
					)
					(565
						(EgoDead 3 700 707 End 152) ; "It Came From the Savanna. The refugee from a formicary has sent you to the infirmary... or the morgue. Ant you glad we saved your game for you before the battle?"
					)
					(580
						(EgoDead 5 700 937 End 152) ; "Boa, are you sore! Quetzlcoatl's cousin has cost you your career."
					)
					(585
						(EgoDead 6 700 455 End 155) ; "The Crocodile... Crimped your style... Left you in... A broken pile."
					)
					(575
						(EgoDead 4 700 937 End 152) ; "That sure wasn't the gorilla your dreams. He sure made a monkey out of you... or maybe a mummy."
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance monsterIsDead of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 13] temp14)
		(switch (= state newState)
			(0
				(HandsOff)
				(it
					approachVerbs: 4 ; Do
					approachX: (/ (+ (it nsLeft:) (it nsRight:)) 2)
					approachY: (+ (/ (+ (it nsTop:) (it nsBottom:)) 2) 5)
				)
				(= local30 1)
				(it setMotion: 0 init:)
				(= local38 0)
				(if (== global365 590)
					(= cycles 5)
				else
					(= temp0 (if (Random 0 1) -10 else 10))
					(Face it (it x:) (+ (it y:) temp0) self)
				)
			)
			(1
				(if (!= global365 590)
					(it
						loop: (if (< temp0 0) 1 else 0) ; UNINIT
						cel: 0
						setMotion: 0
						init:
						setCycle: End
					)
				else
					(it setCycle: Beg)
				)
				(gLongSong2 setLoop: 1 number: 931 play:)
				(switch global365
					(565
						(gLongSong setLoop: 1 changeTo: 153 self)
					)
					(580
						(gLongSong setLoop: 1 changeTo: 153 self)
					)
					(575
						(gLongSong setLoop: 1 changeTo: 153 self)
					)
					(590
						(gLongSong setLoop: 1 changeTo: 156 self)
					)
					(595
						(gLongSong setLoop: 1 changeTo: 159 self)
					)
					(585
						(gLongSong setLoop: 1 changeTo: 156 self)
					)
				)
			)
			(2
				(cond
					((IsFlag 96)
						(ClearFlag 96)
						(client setScript: (ScriptID 701 1) 0 0 1) ; monkeysEnter
					)
					((== global365 590)
						(HandsOn)
						(it dispose:)
					)
				)
				(= cycles 6)
			)
			(3
				(it
					approachVerbs: 4 ; Do
					approachX: (/ (+ (it nsLeft:) (it nsRight:)) 2)
					approachY: (+ (/ (+ (it nsTop:) (it nsBottom:)) 2) 5)
				)
				(= [temp1 0] (- (it nsLeft:) 3))
				(= [temp1 1] (/ (+ (it nsTop:) (it nsBottom:)) 2))
				(= [temp1 2] (+ 3 (it nsRight:)))
				(= [temp1 3] (/ (+ (it nsTop:) (it nsBottom:)) 2))
				(= [temp1 4] (+ 3 (it nsRight:)))
				(= [temp1 5] (+ 3 (it nsBottom:)))
				(= [temp1 6] (- (it nsLeft:) 3))
				(= [temp1 7] (+ 3 (it nsBottom:)))
				(= [temp1 8] 30583)
				(= [temp1 9] 0)
				(if
					(= temp14
						(MergePoly
							@temp1
							((gCurRoom obstacles:) elements:)
							((gCurRoom obstacles:) size:)
						)
					)
					((gCurRoom obstacles:)
						add:
							((Polygon new:)
								points: temp14
								size: (localproc_1 temp14)
								type: PBarredAccess
								dynamic: 1
								yourself:
							)
					)
				else
					((gCurRoom obstacles:)
						add:
							((Polygon new:)
								points: @temp1
								size: 4
								type: PBarredAccess
								dynamic: 1
								yourself:
							)
					)
				)
				(= local13 1)
				(HandsOn)
				(gLongSong number: 400 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (it z:)
			(it z: (- (it z:) 1))
		)
		(super doit:)
	)
)

(instance searchMonster of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (Random 0 1)
					(Face gEgo (+ (gEgo x:) 10) (gEgo y:) self)
				else
					(Face gEgo (- (gEgo x:) 10) (gEgo y:) self)
				)
				(if register
					(gEgo get: 0 register) ; theRoyals
				)
			)
			(1
				(gEgo view: 4 cel: 0 setCycle: End self)
			)
			(2
				(= cycles 10)
			)
			(3
				(if register
					(Message msgGET 700 4 6 18 1 @temp0) ; "Searching the body, you find %d royals."
					(gMessager sayFormat: 99 @temp0 register)
					(= cycles 1)
				else
					(gMessager say: 4 6 19 0 self) ; "You don't find anything of interest."
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sleepScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
				(= local0 0)
			)
			(1
				(gEgo setMotion: PolyPath 165 135 self)
			)
			(2
				(gEgo
					x: (- (gEgo x:) 25)
					view: 35
					loop: 1
					cel: 0
					setCycle: End self
				)
				(gLongSong setLoop: -1 fade: 127 1 30 0 changeTo: 927)
			)
			(3
				(if (= temp2 (PalVary pvGET_CURRENT_STEP))
					(if (< temp2 64)
						(PalVary pvCHANGE_TICKS 3)
					)
				else
					(PalVary pvINIT 700 3)
				)
				(= seconds 5)
			)
			(4
				(if (not local13)
					(if local15
						(= temp3 (Random 0 3))
					else
						(= temp3 0)
					)
					(if (not temp3)
						(cond
							((<= 4 gTimeOfDay 6)
								(if (< (Random 1 10) 5)
									(= global365 585)
								)
							)
							((not (Random 0 2))
								(= global365 585)
							)
						)
						(if (and (!= global365 74) (!= gTimeOfDay 7))
							(= temp1 gClock)
							((ScriptID 7 4) init: 3) ; fixTime
							(= temp0
								(/ (mod (- (+ gClock 3600) temp1) 3600) 150)
							)
							(gEgo useStamina: (- (* temp0 2)))
							(gEgo takeDamage: (- (* temp0 2)))
							(gEgo useMana: (- (* temp0 2)))
						)
					)
				)
				(self cue:)
			)
			(5
				(switch global365
					(74
						(= seconds 10)
					)
					(else
						(= local15 0)
						(= local37 0)
						(if (IsFlag 150)
							(= local0 1)
							(self setScript: paladinHearsMonster self)
						else
							(= seconds 2)
						)
					)
				)
			)
			(6
				(cond
					((== global365 74)
						(PalVary pvREVERSE 3)
						(= seconds 4)
					)
					(local0
						(= seconds 3)
					)
					(else
						(gEgo setCycle: Beg self)
					)
				)
			)
			(7
				(if (!= global365 74)
					(if local0
						(= local13 1)
						(client setScript: encounterScript)
						(self dispose:)
					else
						(= local13 1)
						(gEgo x: 165 y: 135)
						(client setScript: encounterScript)
						(self dispose:)
					)
				else
					(self cue:)
				)
			)
			(8
				((ScriptID 7 7) init: 5 40) ; egoSleeps
				(= cycles 10)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(gEgo x: 165 y: 135 normalize:)
				(= cycles 10)
			)
			(11
				(gLongSong setLoop: -1 number: 400 play:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance castFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((User curEvent:) x: 146 y: 160)
				(self setScript: (ScriptID 32 0) self 81) ; project
			)
			(1
				(HandsOn)
				(gEgo normalize:)
				(= local15 1)
				((= local7 (Prop new:))
					signal: 20496
					view: 700
					loop: 6
					cel: 0
					x: 144
					y: 149
					priority: 13
					setScript: loopSound
					init:
					setCycle: Fwd
				)
				(self dispose:)
			)
		)
	)
)

(instance justLayDown of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 165 135 self)
			)
			(1
				(gEgo
					x: 140
					y: 135
					view: 35
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance loopSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(gLongSong2 number: 913 setLoop: 10000 play: self)
			)
			(2
				(self init:)
			)
		)
	)

	(method (doit)
		(if (and (!= (gLongSong2 number:) 913) (== state 1))
			(self cue:)
		else
			(super doit:)
		)
	)

	(method (dispose)
		(gLongSong2 client: 0 stop:)
		(super dispose:)
	)
)

(instance kindleFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 4 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(if local15
					(self cue:)
				else
					(= seconds 5)
				)
			)
			(2
				(if local15
					(= local15 0)
					(local7 setScript: 0 dispose:)
					(gMessager say: 93 48 0) ; "You put the fire out."
					(= local7 0)
				else
					(= local15 1)
					((= local7 (Prop new:))
						view: 700
						loop: 6
						cel: 0
						x: 144
						y: 149
						priority: 13
						signal: 20496
						setScript: loopSound
						init:
						setCycle: Fwd
					)
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwSpell of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					(
						(and
							(< global432 global373)
							(< global432 global380)
							(< global432 global375)
						)
						(= local27 1)
						(= local63 15)
						(it setMotion: MChase gEgo local63 it)
						(self dispose:)
					)
					((and local28 (< global432 115))
						(it setMotion: PolyPath -50 -50 it setAvoider: PAvoider)
						(= local38 0)
						(self dispose:)
					)
					(else
						(it setMotion: 0)
						(Face it gEgo self)
					)
				)
			)
			(1
				(= register (it loop:))
				(it
					view: 706
					cel: 0
					loop:
						(cond
							((< (gEgo x:) (it x:))
								(if (< (gEgo y:) (it y:)) 3 else 1)
							)
							((< (gEgo y:) (it y:)) 2)
							(else 0)
						)
					setCycle: End self
				)
			)
			(2
				((leopardProject new:) init:)
				(= cycles 5)
			)
			(3
				(it setCycle: Beg self)
			)
			(4
				(it view: 590 loop: register setCycle: Walk)
				(= temp0
					(switch global209
						(1 240)
						(2 120)
						(3 70)
					)
				)
				(= cycles (Random 20 temp0))
			)
			(5
				(it setMotion: MChase gEgo local63 it)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo signal: 8194)
				(if (and (== global365 8) (not (IsFlag 109)))
					(if (IsFlag 110)
						(if (IsFlag 111)
							(EgoDead 8) ; "Three strikes and you're out. Look, you're supposed to be a hero, right? Heroes help those in need, right? Well, you figure it out."
						else
							(SetFlag 111)
							(gEgo addHonor: -100)
						)
					else
						(SetFlag 110)
						(gEgo addHonor: -100)
					)
				)
				(self cue:)
			)
			(1
				(if (and global426 (not local33))
					(gMessager say: 0 20 86 0 self) ; "You gather all of your daggers before continuing on your journey."
					(gEgo get: 10 global426) ; theDaggers
				else
					(self cue:)
				)
			)
			(2
				(if local15
					(gMessager say: 4 6 98) ; "Only YOU can prevent jungle fires."
				)
				(gEgo setMotion: PolyPath local42 local43 self)
			)
			(3
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance it of TargActor
	(properties
		view 0
		signal 28672
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
		(if local30
			(self approachVerbs: 4) ; Do
		)
		(switch global365
			(595
				(if local30
					(self view: 592 setScale: -1 gEgo cycleSpeed: 6 noun: 82)
				else
					(self
						origStep: 1542
						view: 590
						setScale: -1 gEgo
						moveSpeed: (+ (gEgo moveSpeed:) 4)
						cycleSpeed: (+ (gEgo cycleSpeed:) 4)
						setCycle: Walk
						noun: 83
						setMotion: MChase gEgo local63 self
					)
				)
			)
			(590
				(if local30
					(self
						view: 585
						setScale: -1 gEgo
						cycleSpeed: (+ (gEgo cycleSpeed:) 4)
					)
				else
					(self
						origStep: 1540
						view: 585
						setScale: -1 gEgo
						moveSpeed: (+ (gEgo moveSpeed:) 3)
						cycleSpeed: (+ (gEgo cycleSpeed:) 5)
						setCycle: Fwd
						setCel: 0
						setLoop: 2
						noun: 84
						setMotion: MChase gEgo local63 self
					)
				)
			)
			(565
				(if local30
					(self view: 563 setScale: -1 gEgo cycleSpeed: 6 noun: 85)
				else
					(self
						origStep: 1542
						view: 561
						setScale: -1 gEgo
						moveSpeed: (+ (gEgo moveSpeed:) 6)
						cycleSpeed: (+ (gEgo cycleSpeed:) 7)
						setCycle: Walk
						noun: 86
						setMotion: MChase gEgo local63 self
					)
				)
			)
			(580
				(if local30
					(self
						view: 577
						z: 20
						setScale: -1 gEgo
						cycleSpeed: 6
						noun: 87
					)
				else
					(self
						origStep: 1542
						view: 575
						setScale: -1 gEgo
						moveSpeed: (+ (gEgo moveSpeed:) 3)
						cycleSpeed: (gEgo cycleSpeed:)
						setCycle: Walk
						z: 20
						noun: 88
						setMotion: MChase gEgo local63 self
					)
				)
			)
			(585
				(if local30
					(self view: 582 setScale: -1 gEgo cycleSpeed: 6 noun: 89)
				else
					(self
						origStep: 1542
						view: 580
						setScale: -1 gEgo
						moveSpeed: (+ (gEgo moveSpeed:) 4)
						cycleSpeed: (+ (gEgo cycleSpeed:) 5)
						setCycle: Walk
						noun: 90
						setMotion: MChase gEgo local63 self
					)
				)
			)
			(575
				(if local30
					(self view: 572 setScale: -1 gEgo cycleSpeed: 6 noun: 91)
				else
					(self
						origStep: 1542
						view: 570
						setScale: -1 gEgo
						moveSpeed: (+ (gEgo moveSpeed:) 4)
						cycleSpeed: (+ (gEgo cycleSpeed:) 5)
						setCycle: Walk
						noun: 92
						setMotion: MChase gEgo local63 self
					)
				)
			)
			(else
				(self dispose:)
			)
		)
	)

	(method (cue &tmp temp0)
		(if (< global461 global462)
			(cond
				((and (>= global461 15) (== global365 595) (not local27))
					(if (not (gCurRoom timer:))
						(self setScript: throwSpell)
					)
				)
				((and (== global365 590) (== loop 2) (not local12))
					(self
						setCel:
						setLoop: (if (> x (gEgo x:)) 0 else 1)
						setCycle: End self
						setMotion: 0
					)
					((= local14 (Prop new:))
						view: 585
						loop: 3
						cel: 0
						setScale: -1 self
						x: x
						y: y
						signal: 16400
						priority: priority
						cycleSpeed: cycleSpeed
						setCycle: End
						init:
					)
				)
				((and (== global365 590) (== cel 0) (not local12))
					(self
						setCel: 0
						setLoop: 2
						setCycle: Fwd
						setMotion: MChase gEgo local63 self
					)
					(if (IsObject local14)
						(local14 dispose:)
						(= local14 0)
					)
				)
				(
					(and
						(== global365 590)
						(> (GetDistance x y (gEgo x:) (gEgo y:)) local63)
						(not local12)
					)
					(self setCycle: Beg self)
					(if (IsObject local14)
						(local14 setCycle: Beg)
					)
				)
				((<= (gEgo z:) local63)
					(= local38 0)
					(gEgo setMotion: 0)
					(self setMotion: 0)
					(= global430 local41)
					(= global428 local42)
					(= global429 local43)
					(= global427 gPrevRoomNum)
					(if local44
						(&= global431 $fffe)
					else
						(^= global431 $0001)
					)
					(if local28
						(&= global431 $fffd)
					else
						(^= global431 $0002)
					)
					(if (not local26)
						(= local26 1)
						(= local6 10000)
						(self setScript: doBattle)
					)
				)
				((not local12)
					(= local12 1)
					(self setCycle: 0 setMotion: MChase gEgo local63 self)
				)
			)
		else
			(self setMotion: 0)
			(= local15 0)
			(gMessager say: 4 6 90) ; "You got away this time."
			(gEgo setMotion: 0)
			(= local38 0)
			(= local30 1)
			(= local13 1)
			(= local33 1)
			(if (IsFlag 96)
				(ClearFlag 96)
				(gCurRoom setScript: (ScriptID 701 1) 0 0 0) ; monkeysEnter
			else
				(gCurRoom setScript: 0)
				(HandsOn)
			)
			(gLongSong setLoop: -1 changeTo: 400)
			(self dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local38
					(super doVerb: theVerb &rest)
				else
					(switch global365
						(595
							(self
								setScript:
									searchMonster
									0
									(if local32
										0
									else
										(Random 2 10)
									)
							)
						)
						(565
							(self setScript: searchMonster 0 0)
						)
						(580
							(self setScript: searchMonster 0 0)
						)
						(585
							(self
								setScript:
									searchMonster
									0
									(if local32
										0
									else
										(Random 2 10)
									)
							)
						)
						(575
							(self
								setScript:
									searchMonster
									0
									(if local32
										0
									else
										(Random 2 10)
									)
							)
						)
					)
					(= local32 1)
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (and local2 local1 (gCurRoom timer:) (not (gEgo script:)))
			(= local2 0)
			((gCurRoom timer:) dispose:)
			(gCurRoom timer: 0)
			(gMessager say: 0 6 87) ; "That didn't seem to do much."
		)
		(if script
			(script doit:)
		)
		(if (not local6)
			(|= signal $4000)
			(if (== global365 590)
				(cond
					(mover
						(if (not (& signal $0008))
							(if (== local62 7)
								(= local62 0)
								(|= signal $0030)
								(= priority 0)
							else
								(++ local62)
								(&= signal $ffdf)
							)
						)
						(if (not (Random 0 50))
							(ShakeScreen 1)
						)
					)
					((and (or (== loop 1) (== loop 0)) cycler)
						(&= signal $ffcf)
						(ShakeScreen 1)
					)
				)
			)
			(if (not (mod gClock 10))
				(if (and (localproc_2 self) (not local25) (== gEgoGait 2)) ; sneaking
					(= local25 1)
					(if (>= (Random 0 [gEgoStats 8]) 100) ; sneak
						(= global461 10000)
						(self cue:)
					)
				)
			else
				(= local25 0)
			)
			(cond
				((and mover (gCurRoom timer:))
					(if (== global365 590)
						((gCurRoom timer:) dispose: delete:)
					else
						(self setMotion: 0)
						(= local31
							((Polygon new:)
								type: PBarredAccess
								init:
									(- nsLeft 6)
									(- nsBottom 5)
									(+ 6 nsRight)
									(- nsBottom 5)
									(+ 6 nsRight)
									(+ 3 nsBottom)
									(- nsLeft 6)
									(+ 3 nsBottom)
								yourself:
							)
						)
						(gCurRoom addObstacle: local31)
					)
				)
				((and (== global365 590) cycler (gCurRoom timer:))
					(self setCycle: 0)
					(if (IsObject local14)
						(local14 setCycle: 0)
					)
					(= local31
						((Polygon new:)
							type: PBarredAccess
							init:
								(- nsLeft 6)
								(- nsBottom 5)
								(+ 6 nsRight)
								(- nsBottom 5)
								(+ 6 nsRight)
								(+ 3 nsBottom)
								(- nsLeft 6)
								(+ 3 nsBottom)
							yourself:
						)
					)
					(gCurRoom addObstacle: local31)
				)
				(
					(and
						(== global365 590)
						(not local30)
						(not mover)
						(not (gCurRoom timer:))
						(not cycler)
					)
					(if (and (not local12) (not local26))
						(cond
							(
								(<=
									(GetDistance x y (gEgo x:) (gEgo y:))
									local63
								)
								(self setCycle: End self)
								(if (IsObject local14)
									(local14 setCycle: End)
								)
							)
							((!= cel 0)
								(self setCycle: Beg self)
								(if (IsObject local14)
									(local14 setCycle: Beg)
								)
							)
						)
					)
				)
				((and (not local30) (not mover) (not (gCurRoom timer:)))
					(if ((gCurRoom obstacles:) contains: local31)
						((gCurRoom obstacles:) delete: local31)
						(local31 dispose:)
					)
					(if (and (not script) (!= global365 590))
						(self setMotion: MChase gEgo local63 self)
					)
				)
			)
			(if
				(and
					(not local30)
					(== global365 595)
					(not (gCurRoom timer:))
					(not local26)
					(<= (GetDistance x y (gEgo x:) (gEgo y:)) 15)
				)
				(= global461 0)
				(self cue:)
			)
			(if (<= y 45)
				(|= signal $0008)
			else
				(&= signal $fff7)
			)
			(if (& signal $8000)
				(return)
			)
			(if (and (& signal $0004) (not (& signal $0002)))
				(return)
			)
			(if scaler
				(scaler doit:)
			)
			(if (& scaleSignal $0001)
				(= temp5 (>> origStep $0008))
				(= temp6 (& origStep $00ff))
				(if (< y (gCurRoom vanishingY:))
					(= temp3 (/ (- (gCurRoom vanishingY:) y) temp5))
					(= temp4 (/ (- (gCurRoom vanishingY:) y) temp6))
				else
					(= temp3 (/ (* temp5 scaleX) 128))
					(= temp4 (/ (* temp6 scaleY) 128))
				)
				(cond
					((> temp3 temp5)
						(= temp3 temp5)
					)
					((< temp3 1)
						(= temp3 1)
					)
				)
				(cond
					((> temp4 temp6)
						(= temp4 temp6)
					)
					((< temp4 1)
						(= temp4 1)
					)
				)
				(if (or (!= temp3 xStep) (!= temp4 yStep))
					(self setStep: temp3 temp4 1)
				)
			)
			(cond
				(avoider
					(avoider doit:)
				)
				(mover
					(mover doit:)
				)
			)
			(if cycler
				(= temp1 brLeft)
				(= temp2 brRight)
				(cycler doit:)
			)
			(= brTop (- y 1))
			(= brLeft (- x 1))
			(= brRight (+ x 1))
			(= brBottom (+ y 1))
			(= xLast x)
			(= yLast y)
		else
			(if (== local6 1)
				(switch global365
					(565
						(sFx number: 904 setLoop: 1 play:)
					)
					(585
						(sFx number: 907 setLoop: 1 play:)
					)
					(595
						(sFx number: 909 setLoop: 1 play:)
					)
					(580
						(sFx number: 909 setLoop: 1 play:)
					)
				)
			)
			(-- local6)
		)
	)

	(method (getHurt param1 param2)
		(= local1 1)
		(if (gCurRoom timer:)
			((gCurRoom timer:) dispose: delete:)
		)
		(if (not local30)
			(switch global365
				(595
					(if (== param1 -1)
						(if local29
							0
						else
							(= local29 1)
							(gMessager say: 4 6 94) ; "The Leopardman's own spell doesn't seem to have hurt him at all."
						)
					else
						(= local6 10)
						(-= global156 param2)
					)
				)
				(590
					(if (!= cel 0)
						(= local6 10)
						(-= global156 param2)
					)
				)
				(565
					(= local6 10)
					(-= global156 param2)
				)
				(580
					(= local6 10)
					(-= global156 param2)
				)
				(585
					(= local6 10)
					(-= global156 param2)
				)
				(575
					(= local6 10)
					(-= global156 param2)
				)
			)
			(if (and (< global156 1) (!= script doBattle))
				(= local26 0)
				(self setMotion: 0)
				(self setScript: monsterIsDead)
			)
		)
	)
)

(instance fireWood of View
	(properties
		x 146
		y 160
		noun 80
		view 700
		loop 7
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 129 155 163 155 163 171 129 171
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(if (not local15)
					(= noun 93)
					(gCurRoom setScript: castFire)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(19 ; theTinderbox
				(if (not local15)
					(= noun 93)
					(gCurRoom setScript: kindleFire)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(48 ; thePeaceWater
				(if local15
					(= noun 80)
					(gEgo drop: 37 1) ; thePeaceWater
					(gEgo get: 15 1) ; theWaterskin
					(gCurRoom setScript: kindleFire)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if local15
					(= noun 80)
					(gCurRoom setScript: kindleFire)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance showNewRoom of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(self cue:)
			)
			(1
				(switch register
					(4
						(= temp0 -15)
						(= temp1 (gEgo y:))
						(gEgo setMotion: PolyPath temp0 temp1 self)
					)
					(3
						(= temp1 230)
						(= temp0 (gEgo x:))
						(gEgo setMotion: PolyPath temp0 temp1 self)
					)
					(2
						(= temp0 330)
						(= temp1 (gEgo y:))
						(gEgo setMotion: PolyPath temp0 temp1 self)
					)
					(1
						(self cue:)
					)
				)
			)
			(2
				(= local57 1)
				(it setMotion: 0)
				(gEgo setMotion: 0)
				(= cycles 2)
			)
			(3
				(HandsOff)
				(switch register
					(4
						(-- local42)
						(= temp0 0)
						(it x: (+ 330 (- (it x:) (gEgo x:))))
						(gEgo x: 325 y: 155)
						(= temp1 (gEgo y:))
					)
					(1
						(-- local43)
						(= temp0 (gEgo x:))
						(= temp1 0)
						(it y: (+ 230 (- (it y:) (gEgo y:))))
						(gEgo y: 205 x: 160)
					)
					(3
						(++ local43)
						(= temp1 190)
						(it y: (+ 45 (- (it y:) (gEgo y:))))
						(gEgo y: 45 x: 160)
						(= temp0 (gEgo x:))
					)
					(2
						(++ local42)
						(= temp0 320)
						(= temp1 (gEgo y:))
						(it x: (+ -15 (- (it x:) (gEgo x:))))
						(gEgo x: -5 y: 155)
					)
				)
				(localproc_0)
				(gEgo
					init:
					normalize:
					signal: 2
					setScale: Scaler 120 59 189 47
					setMotion: PolyPath temp0 temp1
				)
				(= cycles 2)
			)
			(4
				(if (!= global365 6)
					(it init:)
				)
				(HandsOn)
				(= cycles 2)
			)
			(5
				(if (== global365 6)
					((ScriptID 702 0) init:) ; egoTell
					(++ local22)
					(= seconds (+ (gEgo moveSpeed:) 1))
				else
					(= local24 0)
					(self dispose:)
				)
			)
			(6
				(switch local22
					(1
						(if (& global431 $4000)
							(gMessager say: 4 6 58) ; "You are certain there is someone behind you."
						else
							(gMessager say: 4 6 62) ; "You sense that you are being followed."
						)
					)
					(2
						(if (& global431 $4000)
							(gMessager say: 4 6 61) ; "You feel as if someone very disgusted with you just walked off. Maybe you should try saying something next time."
							(= local38 0)
						else
							(gMessager say: 4 6 57) ; "You feel as if someone or something is stalking you just out of sight."
						)
					)
					(3
						(gMessager say: 4 6 59) ; "You guess whatever it was lost interest."
						(= local38 0)
					)
				)
				(self dispose:)
			)
		)
	)
)

