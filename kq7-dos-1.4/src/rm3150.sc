;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3150)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use n098)
(use Plane)
(use Str)
(use Print)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm3150 0
	putOnSalve 1
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
	[local12 12] = [4269 1465 925 4279 2502 5405 2520 892 4456 4561 4573 4572]
	[local24 7] = [898 899 918 919 920 921 1216]
	[local31 6] = [1011 4657 4551 4654 46570 46540]
	[local37 3] = [897 4553 4358]
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	local48
	local49
	local50
	local51
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	local66
	local67
	local68
	local69
)

(procedure (localproc_0)
	(return
		(and
			(not (bearSfx handle:))
			(not (rndSfx handle:))
			(not (cricketSfx handle:))
			(not (sfx2 handle:))
			(not (sfx handle:))
		)
	)
)

(procedure (localproc_1)
	(if (or (> (- local58 (gEgo x:)) 2) (> (- (gEgo x:) local58) 2))
		(= local58 (gEgo x:))
		(= local59 (- (gEgo x:) 256))
		(= local59 (Max 0 local59))
		(= local59 (Min 127 local59))
		(= local60 (- 127 local59))
	)
	(cond
		(local41
			(return 0)
		)
		((not argc)
			(cond
				((and local59 (not (gKqMusic1 handle:)))
					(gKqMusic1
						number: 3000
						setLoop: -1
						loop: -1
						play:
						setVol: local59
					)
				)
				((and (not local59) (gKqMusic1 handle:))
					(gKqMusic1 stop:)
				)
				(else
					(DoSound sndSET_VOLUME gKqMusic1 local59)
				)
			)
			(cond
				((and local60 (not (music2 handle:)))
					(music2
						number: 3150
						setLoop: -1
						loop: -1
						play:
						setVol: local60
					)
				)
				((and (not local60) (music2 handle:))
					(music2 stop:)
				)
				(else
					(DoSound sndSET_VOLUME music2 local60)
				)
			)
		)
		(else
			(Load rsSOUND 3000)
			(Load rsSOUND 3150)
			(gKqMusic1 number: 3000 setLoop: -1 loop: -1 setVol: 0)
			(music2 number: 3150 setLoop: -1 loop: -1 setVol: 0)
		)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0)
	(if (and (>= argc 2) param2)
		(= local49 param2)
	else
		(= local49 0)
	)
	(switch param1
		(0
			(= temp0 0)
			(bearSfx number: 0 stop:)
		)
		(1
			(switch (++ local52)
				(1
					(= temp0 3153)
				)
				(2
					(= temp0 3155)
				)
				(3
					(= temp0 3161)
					(= local52 0)
				)
			)
		)
		(else
			(= temp0 param1)
		)
	)
	(if temp0
		(bearSfx number: temp0 setLoop: 1 loop: 1 play: gCurRoom setVol: 127)
	)
)

(procedure (localproc_3 &tmp temp0)
	(gCurRoom setRect: -318 0 320 136)
	(localproc_7)
)

(procedure (localproc_4 &tmp temp0)
	(gCurRoom setRect: 0 0 640 136)
	(localproc_7)
)

(procedure (localproc_5 &tmp temp0)
	(= local1 0)
	((ScriptID 19 0) code: 0) ; eastFeat
	((ScriptID 19 1) code: 0) ; westFeat
	(bearSfx setLoop: 1 number: 0 stop:)
	(rndSfx setLoop: 1 number: 0 stop:)
	(sfx setLoop: 1 number: 0 stop:)
	(cricketSfx setLoop: 1 number: 0 stop:)
	(if local53
		(= local50 20)
	else
		(= local50 30)
	)
	(= local4 9999)
	(= local44 0)
	(= local45 0)
	(= local46 0)
	(= local49 0)
	(= local51 0)
	(= local52 0)
	(= local54 0)
	(= local55 0)
	(= local56 0)
	(= local57 0)
	(= local58 0)
	(= local59 0)
	(= local60 0)
	(= local61 0)
	(= local63 0)
	(= local64 0)
	(= local65 0)
	(= local66 0)
	(= local67 0)
	(= local68 0)
	(= local40 0)
	(= local69 0)
	(= local47 1)
	(= local62 1)
	(= local42 0)
	(= local41 0)
	(wereBear view: 996 z: 0)
	(if (not (gCast contains: wereBear))
		(wereBear init:)
	)
	(if (== gChapter 4)
		(= local43 31500)
	else
		(= local43 3150)
	)
	(if (not (gFeatures contains: myNorthExit))
		(myNorthExit init:)
	)
	(cricketTimer setTicks: 30 cricketTimer)
	(forestTimer setTicks: 60 forestTimer)
	(rndFxTimer setTicks: 900 rndFxTimer)
	(if (not (gFeatures contains: rosieBearTrigger))
		(rosieBearTrigger init:)
		(rosieDeadTrigger init:)
		(valBearTrigger init:)
	)
	(if (and (OneOf gPrevRoomNum 3000 3200) (OneOf gChapter 3 5))
		(= local48 1)
	else
		(= local48 0)
	)
	((ScriptID 13 0) ; aEgoTalker
		client: gEgo
		mouth: 0
		view: -1
		loop: -1
		clientCel: -2
		mouth_x: -999
		mouth_y: -999
		hide_mouth: 0
	)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2)
	(= temp1 0)
	((= temp2 (Str new:)) format: {11-22-94 9:55am\n})
	(if (gCurRoom script:)
		(if ((gCurRoom script:) script:)
			((= temp1 (Str new:))
				format:
					{%scurRoom script: %s\nstate: %d register: %d\n%s script: %s\nstate %d register: %d\n}
					(temp2 data:)
					((gCurRoom script:) name:)
					((gCurRoom script:) state:)
					((gCurRoom script:) register:)
					((gCurRoom script:) name:)
					(((gCurRoom script:) script:) name:)
					(((gCurRoom script:) script:) state:)
					((gCurRoom script:) register:)
			)
		else
			((= temp1 (Str new:))
				format:
					{%scurRoom script: %s\nstate: %d register: %d}
					(temp2 data:)
					((gCurRoom script:) name:)
					((gCurRoom script:) state:)
					((gCurRoom script:) register:)
			)
		)
	)
	(if (not local1)
		(= local1 1)
		((= temp0 (Str new:))
			format: {total mem: %uK current free: %uK} global322 (MemoryInfo 0)
		)
		(proc98_8 (temp0 data:) 0)
		(temp0 dispose:)
	)
	(if temp1
		(proc98_1 (temp1 data:) 0)
		(temp1 dispose:)
	else
		(proc98_1 (temp2 data:) 0)
	)
	(temp2 dispose:)
)

(procedure (localproc_7)
	(if (not (gThePlane left:))
		((ScriptID 19 1) ; westFeat
			nsTop: 108
			nsBottom: 138
			approachX: 0
			approachY: 133
			approachVerbs: 8 10 ; Do, Exit
		)
		((ScriptID 19 0) ; eastFeat
			nsTop: 78
			nsBottom: 119
			approachX: 325
			approachY: 98
			approachVerbs: 8 10 ; Do, Exit
		)
	else
		((ScriptID 19 0) ; eastFeat
			nsTop: 65
			nsBottom: 102
			approachX: 645
			approachY: 90
			approachVerbs: 8 10 ; Do, Exit
		)
		((ScriptID 19 1) ; westFeat
			nsTop: 78
			nsBottom: 119
			approachX: 315
			approachY: 98
			approachVerbs: 8 10 ; Do, Exit
		)
	)
)

(instance rm3150 of KQRoom
	(properties
		picture 3151
		east 3200
		west 4550
		screen_mid 3152
	)

	(method (init &tmp [temp0 2])
		(= local3 (IsFlag 97))
		(if (== gPrevRoomNum 26)
			(gEgo put: 0) ; Golden_Comb
			(= gChapter 5)
			(= gPrevRoomNum 3200)
			(gEgo get: 65) ; Were-beast_Salve
			(gEgo get: 10) ; Jackalope_Fur
		)
		(= global375 (Str with: {Locked views:}))
		(= global376 (Str with: {Locked waves:}))
		(SetFlag 21)
		(SetFlag 55)
		(if (<= (gGame speedRating:) 165)
			(= local53 1)
		else
			(= local53 0)
		)
		(Print font: 0 x: -1 y: -1 fore: 0 back: 84)
		(if (and (OneOf gPrevRoomNum 4650 4550) (IsFlag 151))
			(= gChapter 4)
		)
		(switch gChapter
			(4
				(= gValOrRoz -3) ; Roz
			)
			(3
				(= gValOrRoz -4) ; Val
			)
			(else
				(= gChapter 5)
				(= gValOrRoz -4) ; Val
			)
		)
		(= local6 ((ScriptID 19 0) nsTop:)) ; eastFeat
		(= local7 ((ScriptID 19 0) nsBottom:)) ; eastFeat
		(= local8 ((ScriptID 19 1) nsTop:)) ; westFeat
		(= local9 ((ScriptID 19 1) nsBottom:)) ; westFeat
		(localproc_5)
		(SetFlag 552)
		(super init:)
		(cond
			(
				(and
					(== gChapter 4)
					(OneOf gPrevRoomNum 4650 4550)
					(IsFlag 151)
				)
				(self
					addObstacle:
						((Polygon new:)
							name: {Polygon}
							type: PBarredAccess
							init: 1 0 637 0 637 73 591 70 521 76 418 69 349 91 333 84 276 96 203 125 56 125 1 108
							yourself:
						)
						((Polygon new:)
							name: {Polygon}
							type: PBarredAccess
							init: 455 134 359 96 392 84 441 84 542 119 637 119 637 136 0 136 0 133 193 133 271 100 315 107 382 134
							yourself:
						)
				)
			)
			((and (== gChapter 4) (not (IsFlag 151)))
				(self
					addObstacle:
						((Polygon new:)
							name: {Polygon}
							type: PBarredAccess
							init: 1 0 637 0 637 73 591 70 521 76 418 69 349 91 333 84 295 87 261 92 206 119 133 125 56 125 1 108
							yourself:
						)
						((Polygon new:)
							name: {Polygon}
							type: PBarredAccess
							init: 441 128 359 96 392 84 441 84 542 119 637 119 637 136 0 136 0 134 184 134 234 107 315 107 363 128
							yourself:
						)
				)
			)
			(else
				(self
					addObstacle:
						((Polygon new:)
							name: {Polygon}
							type: PBarredAccess
							init: 1 0 637 0 637 73 591 70 521 76 418 69 349 91 333 84 295 87 261 92 210 113 179 113 133 125 56 125 1 108
							yourself:
						)
						((Polygon new:)
							name: {Polygon}
							type: PBarredAccess
							init: 443 134 359 96 392 84 441 84 542 119 637 119 637 136 0 136 0 133 235 133 202 119 230 107 315 107 371 134
							yourself:
						)
				)
			)
		)
		(cond
			((OneOf gPrevRoomNum 4650 4550)
				(cond
					((and (IsFlag 151) (not (IsFlag 5)))
						(localproc_4)
						(= local40 1)
						(gEgo
							setScaler: 0
							setScale: 0
							normalize: 0 9022
							illegalBits: 0
							ignoreActors: 1
							x: -15
							y: 131
							heading: 90
							loop: 8
							cel: 0
							init:
						)
						(self setScript: sEnterScr 0 199)
					)
					((and (== gChapter 5) (IsFlag 567))
						(localproc_3)
						(ClearFlag 5)
						(ClearFlag 567)
						(ClearFlag 559)
						(gEgo
							setScaler: Scaler 100 65 135 80
							normalize: 2
							illegalBits: 0
							ignoreActors: 1
							get: 65 ; Were-beast_Salve
							init:
							x: 500
							y: 78
							heading: 180
							loop: 8
							cel: 2
						)
						(= local48 1)
						(proc98_6 1)
						(= local58 640)
						(localproc_1 1)
					)
					(else
						(localproc_4)
						(if (== gChapter 5)
							(SetFlag 559)
						)
						(gEgo
							setScaler: Scaler 100 65 135 80
							normalize: 0
							illegalBits: 0
							ignoreActors: 1
							init:
							x: -15
							y: 131
							heading: 180
							loop: 8
							cel: 2
						)
						(self setScript: sEnterScr 0 199)
					)
				)
			)
			((== gPrevRoomNum 3200)
				(localproc_3)
				(gEgo
					x: 650
					y: 95
					heading: 270
					normalize:
					illegalBits: 0
					ignoreActors: 1
					loop: 8
					cel: 1
					setScaler: Scaler 100 65 135 80
					init:
				)
				(self setScript: sEnterScr 0 99)
				(= local48 1)
				(= local58 (gEgo x:))
				(localproc_1 1)
			)
			(else
				(localproc_3)
				(gEgo
					normalize: 2
					illegalBits: 0
					ignoreActors: 1
					loop: 8
					cel: 2
					setCycle: 0
					setLoop: 2 1
					setLooper: 0
					looper: 0
					x: 502
					y: 61
					heading: 180
					setPri: -1
					setScaler: Scaler 66 24 76 60
					init:
				)
				(self setScript: sEnterScr 0 0)
				(if
					(or
						(not (gKqMusic1 handle:))
						(!= gPrevRoomNum 3000)
						(!= (gKqMusic1 number:) 3000)
					)
					(= local58 (gEgo x:))
					(localproc_1 1)
				)
				(= local48 1)
			)
		)
		(gKeyDownHandler addToFront: self)
		(proc98_4 128 (gEgo view:))
		(proc98_4 140 1216 900 901)
	)

	(method (handleEvent event &tmp temp0)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_DIVIDE
					(if (>= (++ local67) 2)
						(= local68 1)
					)
					(= local2 0)
					(ClearFlag 562)
					(ClearFlag 541)
					(if (proc98_2 -1)
						(FrameOut)
					)
				)
				($005c ; \
					(cond
						((IsFlag 541)
							(= local2 0)
							(ClearFlag 562)
							(ClearFlag 541)
							(proc98_2)
						)
						((and (not (IsFlag 541)) (IsFlag 562))
							(SetFlag 541)
							(= local2 1)
						)
						(else
							(SetFlag 562)
						)
					)
					(event claimed: 1)
					(return)
				)
				(else
					(event claimed: 0)
					(return)
				)
			)
		else
			(UpdatePlane (gCast plane:))
			(event claimed: 0)
			(return)
		)
	)

	(method (doit &tmp [temp0 2])
		(if (and local2 (not (Random 0 20)))
			(localproc_6)
		)
		(cond
			((gCurRoom script:))
			(
				(and
					(== gChapter 4)
					(or
						(and (IsFlag 151) (rosieBearTrigger onMe: gEgo))
						(and
							(not (IsFlag 151))
							(rosieDeadTrigger onMe: gEgo)
						)
					)
				)
				(gCurRoom setScript: rosieBearComesOut)
			)
			((and (OneOf gChapter 3 5) (valBearTrigger onMe: gEgo))
				(self setScript: valBearComesOut)
			)
			((and (leEyes script:) (> (gEgo x:) 405))
				(leEyes dispose:)
			)
			((and (not (leEyes script:)) (< (gEgo x:) 400))
				(leEyes
					view: local43
					setPri: 4
					cel: 0
					loop: 0
					signal: 26657
					z: 0
					init:
					setScript: eyeScript 0 0
				)
			)
			((>= (gEgo x:) 635)
				(gCurRoom setScript: sExitEast)
			)
			((<= (gEgo x:) 10)
				(gCurRoom setScript: sExitWest)
			)
			((and local48 (not local61) (< (gEgo x:) 245))
				(proc98_5)
				(= local61 1)
				(gEgo setMotion: 0 setHeading: 310)
				(if (wereBear script:)
					((wereBear script:) register: -1)
				else
					(wereBear setScript: sBearEyes 0 3)
				)
			)
			(
				(and
					local48
					(or
						(wereBear script:)
						(gEgo mover:)
						(not local62)
						(not (localproc_0))
					)
				))
			(
				(and
					local48
					(not (Random 0 20))
					(< (gEgo x:) 340)
					(> (gEgo x:) 303)
				)
				(wereBear setScript: sBearEyes 0 1)
			)
			(
				(and
					local48
					(not (Random 0 20))
					(< (gEgo x:) 270)
					(> (gEgo x:) 245)
				)
				(wereBear setScript: sBearEyes 0 2)
			)
		)
		(localproc_1)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(= local42 1)
		((ScriptID 19 0) ; eastFeat
			nsTop: local6
			nsBottom: local7
			code: 0
			approachX: 0
			approachY: 0
			approachVerbs: 0
		)
		((ScriptID 19 1) ; westFeat
			nsTop: local8
			nsBottom: local9
			code: 0
			approachX: 0
			approachY: 0
			approachVerbs: 0
		)
		(ClearFlag 552)
		(if local3
			(SetFlag 97)
		)
		(gKeyDownHandler delete: self)
		(bearTimer dispose: delete:)
		(forestTimer dispose: delete:)
		(cricketTimer dispose: delete:)
		(rndFxTimer dispose: delete:)
		(proc98_0 1)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(if local49
			(local49 cue:)
		)
		(= local49 0)
	)
)

(instance myNorthExit of ExitFeature
	(properties
		nsLeft 468
		nsTop 40
		nsRight 555
		nsBottom 70
		approachX 519
		approachY 76
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb)
		(gCurRoom setScript: sExitNorth)
	)
)

(instance leEyes of Actor
	(properties)
)

(instance wereBear of Actor
	(properties
		priority 4
		fixPriority 1
		view 996
		loop 5
		signal 26657
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 37 86) ; Do, Exit, Silver_Pellet, Sling
	)

	(method (doVerb theVerb &tmp temp0)
		((= temp0 (Str new:)) format: {wereBear doVerb: %d} theVerb)
		(proc98_8 (temp0 data:) 0)
		(temp0 dispose:)
		(if (gCurRoom script:)
			(= local45 theVerb)
			(proc98_5)
		)
	)

	(method (cue)
		(switch (++ local69)
			(1
				(self cel: 11 cycleSpeed: 8 setCycle: End self)
				(sfx2 number: 955 setLoop: 1 loop: 1 play: setVol: 127)
				(UpdateScreenItem self)
				(FrameOut)
			)
			(2
				(= local69 0)
				(self dispose:)
			)
		)
	)
)

(instance music2 of Sound
	(properties)
)

(instance bearSfx of Sound
	(properties)
)

(instance rndSfx of Sound
	(properties)
)

(instance sfx2 of Sound
	(properties)
)

(instance sfx of Sound
	(properties)
)

(instance cricketSfx of Sound
	(properties)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(= local41 1)
				(gEgo setMotion: MoveTo -15 (gEgo y:) self)
				(gKqMusic1 fade:)
			)
			(1
				(if (and (== gChapter 4) (not (IsFlag 151)))
					(gEgo setMotion: MoveTo 75 130 self)
				else
					(gCurRoom newRoom: 4550)
				)
			)
			(2
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(gEgo setMotion: MoveTo 650 (gEgo y:) self)
				(gKqMusic1 fade:)
			)
			(1
				(gCurRoom newRoom: 3200)
			)
		)
	)
)

(instance valBearTrigger of Feature
	(properties
		nsLeft 203
		nsTop 103
		nsRight 217
		nsBottom 212
	)
)

(instance rosieBearTrigger of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					name: {Polygon}
					type: PTotalAccess
					init: 176 110 247 136 239 136 167 110
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rosieDeadTrigger of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					name: {Polygon}
					type: PTotalAccess
					init: 176 106 244 125 238 128 172 108
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bearTimer of Timer
	(properties)

	(method (cue)
		(= local62 1)
	)
)

(instance forestTimer of Timer
	(properties)

	(method (cue &tmp temp0)
		(if (< (gEgo x:) 320)
			(++ local44)
		else
			(= local44 0)
		)
		(self setTicks: 60 self)
	)
)

(instance cricketTimer of Timer
	(properties)

	(method (cue &tmp temp0)
		(if (and (not local5) local47 (< (gEgo x:) 350) (localproc_0))
			(cricketSfx
				number: (Random 900 901)
				setLoop: 1
				loop: 1
				play:
				setVol: 127
			)
			(self setTicks: (Random 90 180) self)
		else
			(self setTicks: 90 self)
		)
	)
)

(instance lookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leEyes cycleSpeed: 1 cel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 3 5))
			)
			(2
				(if (not register)
					(leEyes cycleSpeed: 0 setCycle: Beg self)
				else
					(++ state)
					(self cue:)
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(leEyes cycleSpeed: 1 setCycle: End self)
			)
			(5
				(= seconds (Random 3 5))
			)
			(6
				(leEyes cycleSpeed: 0 setCycle: Beg self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance blinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leEyes
					view: local43
					x: local65
					y: local66
					cel: (leEyes lastCel:)
					cycleSpeed: 4
					moveSpeed: 4
				)
				(= cycles 2)
			)
			(1
				(leEyes setMotion: MoveTo local63 local64 self)
			)
			(2
				(= seconds (Random 4 7))
			)
			(3
				(leEyes cycleSpeed: 0 setCycle: Beg self)
			)
			(4
				(= ticks 30)
			)
			(5
				(leEyes cycleSpeed: 0 setCycle: End self)
			)
			(6
				(= seconds (Random 4 7))
			)
			(7
				(leEyes
					setSpeed: (Random 4 8)
					setMotion: MoveTo local65 local66 self
				)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance WestExitCode of Code
	(properties)

	(method (doit)
		((ScriptID 19 1) code: 0) ; westFeat
		((ScriptID 19 0) code: 0) ; eastFeat
		(proc98_5)
		(if (== gChapter 4)
			(= local46 1)
		else
			(= local45 999)
		)
		(self dispose:)
	)
)

(instance EastExitCode of Code
	(properties)

	(method (doit)
		((ScriptID 19 1) code: 0) ; westFeat
		((ScriptID 19 0) code: 0) ; eastFeat
		(proc98_5)
		(cond
			((== gChapter 4)
				(= local45 999)
			)
			((IsFlag 559)
				(= local45 999)
			)
			(else
				(= local46 1)
			)
		)
		(self dispose:)
	)
)

(instance eyeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					((and (not (Random 0 3)) (<= ((gCast plane:) left:) -260))
						(leEyes x: 589 y: 56 setLoop: 9 setPri: 188)
						(= register -1)
						(self setScript: lookScript self 0)
					)
					(
						(and
							(<= ((gCast plane:) left:) 0)
							(>= ((gCast plane:) left:) -200)
						)
						(while (== register (= temp0 (Random 100 106)))
						)
						(= register temp0)
						(switch register
							(100
								(leEyes x: 96 y: 45 setLoop: 1 setPri: 122)
								(self setScript: lookScript self 0)
							)
							(101
								(= local65 62)
								(= local66 58)
								(leEyes setLoop: 2 setPri: 62)
								(= local63 69)
								(= local64 62)
								(self setScript: blinkScript self)
							)
							(102
								(leEyes x: 72 y: 47 setLoop: 6 setPri: 47)
								(self setScript: lookScript self 0)
							)
							(103
								(leEyes x: 358 y: 44 setLoop: 6 setPri: 4)
								(self setScript: lookScript self 0)
							)
							(104
								(leEyes setLoop: 8 x: 98 y: 41 setPri: 100)
								(self setScript: lookScript self 1)
							)
							(105
								(if (== (sBearEyes register:) 3)
									(= ticks 90)
								else
									(leEyes x: 174 y: 34 setLoop: 7 setPri: 4)
									(self setScript: lookScript self 1)
								)
							)
							(106
								(leEyes x: 31 y: 75 setLoop: 9 setPri: -1)
								(self setScript: lookScript self 1)
							)
						)
					)
					(
						(and
							(not (Random 0 3))
							(>= ((gCast plane:) left:) -280)
							(<= ((gCast plane:) left:) -200)
						)
						(switch (= register (Random 1 2))
							(1
								(= local65 442)
								(= local66 129)
								(leEyes setLoop: 4 setPri: 188)
								(= local63 421)
								(= local64 128)
								(self setScript: blinkScript self)
							)
							(2
								(leEyes x: 325 y: 33 setPri: 33 setLoop: 9)
								(self setScript: lookScript self 0)
							)
						)
					)
					(else
						(while (== register (= temp0 (Random 200 207)))
						)
						(= register temp0)
						(switch register
							(200
								(= local65 243)
								(= local66 38)
								(leEyes setLoop: 9 setPri: 4)
								(= local63 234)
								(= local64 35)
								(self setScript: blinkScript self)
							)
							(201
								(= local65 397)
								(= local66 57)
								(leEyes setLoop: 6 setPri: 4)
								(= local63 388)
								(= local64 56)
								(self setScript: blinkScript self)
							)
							(202
								(= local65 442)
								(= local66 129)
								(leEyes setLoop: 4 setPri: 188)
								(= local63 421)
								(= local64 128)
								(self setScript: blinkScript self)
							)
							(203
								(= local65 343)
								(= local66 58)
								(leEyes setLoop: 7 setPri: 4)
								(= local63 354)
								(= local64 62)
								(self setScript: blinkScript self)
							)
							(204
								(leEyes x: 325 y: 33 setPri: 33 setLoop: 9)
								(self setScript: lookScript self 0)
							)
							(205
								(= local65 53)
								(= local66 50)
								(leEyes setLoop: 4 setPri: 4)
								(= local63 45)
								(= local64 40)
								(self setScript: blinkScript self)
							)
							(206
								(= local65 235)
								(= local66 79)
								(leEyes setPri: 9 setLoop: 4)
								(= local63 230)
								(= local64 73)
								(self setScript: blinkScript self)
							)
							(207
								(leEyes x: 295 y: 30 setLoop: 8 setPri: -1)
								(self setScript: lookScript self 1)
							)
						)
					)
				)
			)
			(1
				(= ticks (Random 30 120))
			)
			(2
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc98_5)
				(if (and (<= (gEgo heading:) 270) (>= (gEgo heading:) 90))
					(-- state)
					(gEgo setHeading: 360 self)
				else
					(= cycles 2)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					normalize: 3
					illegalBits: 0
					ignoreActors: 1
					setLoop: 8 1
					cel: 3
					setCycle: 0
					heading: 360
					setPri: -1
					setSpeed: 12
					setScaler: Scaler 66 24 76 60
				)
				(= cycles 2)
			)
			(3
				(gEgo setLoop: 3 1 setMotion: MoveTo 512 69 self)
			)
			(4
				(gEgo setMotion: MoveTo 502 61 self)
			)
			(5
				(gCurRoom newRoom: 3000)
			)
		)
	)
)

(instance sBearEyes of Script
	(properties)

	(method (dispose)
		(= register 0)
		(wereBear view: 996 z: 0)
		(= local62 0)
		(if (not local42)
			(bearTimer setReal: bearTimer (Random 10 14))
		)
		(super dispose:)
	)

	(method (doit)
		(if (and (== register 3) (leEyes script:))
			(leEyes script: 0 dispose:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(1
						(= local57 71)
						(if (== local56 284)
							(= local55 284)
							(= local56 248)
						else
							(= local55 248)
							(= local56 284)
						)
						(= ticks (Random 120 240))
						(wereBear
							view: local43
							setLoop: 5 1
							z: 0
							x: local55
							y: local57
							setPri: 4
							cycleSpeed: 2
							moveSpeed: 4
							illegalBits: 0
							ignoreActors: 1
							init:
							cel: 4
						)
						(localproc_2 1)
					)
					(2
						(wereBear
							view: local43
							setLoop: 5 1
							z: 0
							x: 289
							y: 63
							setPri: 70
							cycleSpeed: 2
							moveSpeed: 4
							ignoreActors: 1
							cel: 4
						)
						(= state 99)
						(= ticks (Random 90 120))
						(localproc_2 1)
					)
					(3
						(proc98_5)
						(wereBear
							view: local43
							setLoop: 5 1
							z: 0
							x: 265
							y: 38
							setPri: 10
							cycleSpeed: 2
							moveSpeed: 6
							illegalBits: 0
							ignoreActors: 1
							cel: 4
						)
						(= state 199)
						(= cycles 2)
					)
				)
			)
			(1
				(if (not (gCast contains: wereBear))
					(wereBear init: show:)
				else
					(wereBear show:)
				)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= cycles 2)
			)
			(2
				(wereBear setMotion: MoveTo 262 local57 self)
			)
			(3
				(= ticks 90)
			)
			(4
				(wereBear setCycle: Beg self)
			)
			(5
				(= cycles 2)
			)
			(6
				(wereBear setCycle: End self)
			)
			(7
				(= ticks 90)
			)
			(8
				(wereBear setMotion: MoveTo local56 local57 self)
			)
			(9
				(if (== register -1)
					(= register 3)
					(self init:)
				else
					(self dispose:)
				)
			)
			(100
				(if (not (gCast contains: wereBear))
					(wereBear init: show:)
				else
					(wereBear show:)
				)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= cycles 2)
			)
			(101
				(wereBear setMotion: MoveTo 301 63 self)
			)
			(102
				(= ticks 60)
			)
			(103
				(wereBear setCycle: Beg self)
			)
			(104
				(= cycles 2)
			)
			(105
				(wereBear setCycle: End self)
			)
			(106
				(= ticks 90)
			)
			(107
				(wereBear setMotion: MoveTo 289 63 self)
			)
			(108
				(if (== register -1)
					(= register 3)
					(self init:)
				else
					(self dispose:)
				)
			)
			(200
				(if (not (gCast contains: wereBear))
					(wereBear init: show:)
				else
					(wereBear show:)
				)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= cycles 2)
			)
			(201
				(localproc_2 1 self 40)
				(wereBear setMotion: MoveTo 174 38 self)
			)
			(202)
			(203
				(localproc_2 0)
				((ScriptID 13 0) ; aEgoTalker
					client: gEgo
					view: 30800
					loop: 7
					clientCel: 7
					hide_mouth: 0
				)
				(gMessager say: 5 24 0 1 self 1100) ; "Oh...my..."
				(wereBear setCycle: Beg self)
			)
			(204)
			(205
				((ScriptID 13 0) ; aEgoTalker
					client: gEgo
					mouth: 0
					view: -1
					loop: -1
					clientCel: -2
					mouth_x: -999
					mouth_y: -999
					hide_mouth: 0
				)
				(if
					(and
						(not (wereBear cycler:))
						(!= (wereBear cel:) (wereBear lastCel:))
					)
					(wereBear setCycle: End)
				)
				(= ticks 30)
			)
			(206
				(= ticks 60)
			)
			(207
				(wereBear moveSpeed: 2 setMotion: MoveTo 197 45 self)
			)
			(208
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance boxOnFloor of View
	(properties
		x 495
		y 80
		view 3158
		loop 2
		signal 26657
	)
)

(instance lidOnFloor of View
	(properties
		x 500
		y 80
		view 3158
		loop 1
		signal 26657
	)
)

(instance eatRosie_NOT_Black of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(= local47 0)
				(wereBear view: 33154 x: 136 y: 112 setLoop: 0 cel: 0)
				(= ticks 30)
			)
			(1
				(sfx number: 3152 setLoop: 1 loop: 1 play: setVol: 127)
				(wereBear setCycle: CT 4 1 self)
			)
			(2
				(wereBear cel: 5)
				(sfx2 number: 1003 setLoop: 1 play: self setVol: 127)
				(gEgo hide:)
			)
			(3
				(wereBear cycleSpeed: 12 setCycle: End self)
			)
			(4
				(= next rosieDeadScr)
				(self dispose:)
			)
		)
	)
)

(instance munchScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc98_0 0)
				(proc98_4 140 2520 4561)
				(= ticks 30)
			)
			(1
				(bearSfx number: 2520 setLoop: 1 loop: 1 play: setVol: 127)
				(cond
					((and (== gChapter 4) (not (Random 0 4)))
						(= ticks (+ 10 (DoAudio audPLAY 4350 0 0 3 1)))
					)
					((and (OneOf gChapter 3 5) (not (Random 0 4)))
						(= ticks (+ 10 (DoAudio audPLAY 6350 1 8 1 1)))
					)
					(else
						(sfx
							number: 1003
							setLoop: 1
							loop: 1
							play: self
							setVol: 127
						)
					)
				)
			)
			(2
				(if (== gChapter 4)
					(sfx number: 4082 setLoop: 1 loop: 1 play: setVol: 127)
				else
					(sfx number: 835 setLoop: 1 loop: 1 play: setVol: 127)
				)
				(= ticks 180)
			)
			(3
				(bearSfx number: 4561 setLoop: 1 loop: 1 play: setVol: 127)
				(sfx stop:)
				(= ticks 180)
			)
			(4
				(bearSfx stop:)
				(= ticks 30)
			)
			(5
				(sfx2 number: 2474 setLoop: 1 play: self setVol: 127)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance rosieDeadScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leEyes dispose:)
				(wereBear dispose:)
				((= local0 (Plane new:))
					setRect: 0 0 319 (gThePlane bottom:)
					back: 0
					picture: -1
					priority: 1000
					init:
				)
				(if (or local68 (proc98_9))
					(self setScript: munchScript self)
				else
					(= cycles 2)
				)
			)
			(1
				(wereBear dispose:)
				(bearSfx stop:)
				(sfx stop:)
				(rndSfx stop:)
				(gKqMusic1 setVol: 0 stop:)
				(music2 setVol: 0 stop:)
				(local0 dispose:)
				(= local0 0)
				(= local41 1)
				(cond
					((== local45 37)
						(EgoDead 73 self 1)
					)
					((IsFlag 151)
						(EgoDead 72 self 1)
					)
					(else
						(switch (Random 1 3)
							(1
								(EgoDead 28 self 1)
							)
							(2
								(EgoDead 22 self 1)
							)
							(3
								(EgoDead 19 self 1)
							)
						)
					)
				)
			)
			(2
				(= local41 0)
				(ClearFlag 5)
				(if (not (IsFlag 151))
					(gEgo
						x: 525
						y: 92
						z: 0
						setMotion: 0
						heading: 180
						loop: 8
						cel: 0
						normalize: 2 836
						illegalBits: 0
						ignoreActors: 1
						setScaler: Scaler 100 65 135 80
						init:
						show:
					)
					(localproc_3)
				else
					(gEgo
						x: 75
						y: 130
						z: 0
						setMotion: 0
						heading: 90
						loop: 8
						cel: 0
						normalize: 0 9022
						illegalBits: 0
						ignoreActors: 1
						setScaler: 0
						setScale: 0
						init:
						show:
					)
					(localproc_4)
				)
				(localproc_5)
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance useSlingEyes of Prop
	(properties
		x 94
		y 87
		priority 1
		fixPriority 1
		view 3156
	)
)

(instance rndFxTimer of Timer
	(properties)

	(method (cue &tmp temp0 temp1 temp2 temp3)
		(= temp2 0)
		(= temp3 0)
		(if
			(and
				(localproc_0)
				(!= (sBearEyes register:) 3)
				local47
				(< (gEgo x:) 320)
			)
			(cond
				((or local5 (not (Random 0 20)))
					(if local5
						(switch (++ local5)
							(2
								(= temp1 [local12 0])
							)
							(3
								(= temp1 [local12 1])
							)
							(4
								(= temp1 [local12 2])
							)
							(5
								(= temp1 [local12 3])
							)
							(6
								(= temp1 [local12 4])
							)
							(7
								(= temp1 [local12 5])
								(= local5 1)
							)
						)
					else
						(= temp1 [local12 (= temp0 (Random 0 5))])
					)
				)
				((not (Random 0 10))
					(= temp1 [local31 (= temp0 (Random 0 5))])
				)
				((not (Random 0 8))
					(= temp1 [local37 (= temp0 (Random 0 2))])
				)
				(else
					(= temp1 [local24 (= temp0 (Random 0 6))])
				)
			)
			(rndSfx
				number: temp1
				setLoop: 1
				loop: 1
				play:
				setVol: (if temp3 temp3 else 127)
			)
			(self setTicks: (Random 600 1200) self)
		else
			(self setTicks: (Random 300 600) self)
		)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (dispose)
		(= local47 1)
		(localproc_1)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc98_5)
				(= local47 0)
				(= local41 0)
				(= state register)
				(= cycles 2)
			)
			(1
				(= local58 (gEgo x:))
				(localproc_1 1)
				(gEgo
					setLoop: 2 1
					setSpeed: 12
					setMotion: MoveTo 512 69 self
				)
			)
			(2
				(proc98_4 140 3161 4358 1011 915)
				(gEgo setMotion: MoveTo 519 76 self)
			)
			(3
				(proc98_4 140 897 3153 3155)
				(gEgo
					normalize: 2
					illegalBits: 0
					ignoreActors: 1
					loop: 8
					cel: 2
					heading: 180
					x: 519
					y: 76
					setScaler: Scaler 100 65 135 80
				)
				(proc98_6 1)
				(self dispose:)
			)
			(100
				(proc98_4 140 3161 4358 1011 915)
				(proc98_4 140 897 3153 3155)
				(= local58 (gEgo x:))
				(localproc_1 1)
				(gEgo setMotion: MoveTo 620 (gEgo y:) self)
			)
			(101
				(proc98_6 1)
				(self dispose:)
			)
			(200
				(proc98_4 140 3161 4358 1011 915)
				(gEgo setMotion: MoveTo 35 (gEgo y:) self)
			)
			(201
				(proc98_4 140 897 3153 3155)
				(= temp1 [local37 (= temp0 (Random 0 2))])
				(rndSfx number: temp1 setLoop: 1 loop: 1 play: setVol: 127)
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance eatRosieInBlack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(wereBear
					view: 3153
					x: 169
					y: 108
					setLoop: 0
					cel: 0
					setCycle: 0
				)
				(= ticks 20)
			)
			(1
				(wereBear cel: 5)
				(= ticks 20)
			)
			(2
				(wereBear cycleSpeed: 6 setCycle: CT 7 1 self)
			)
			(3
				(wereBear cel: 8)
				(localproc_2 1 self)
			)
			(4
				(if (== local45 8)
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 1 8 2 1 self) ; "(TRYING TO BE FRIENDLY BUT SCARED)H--hi there!"
				else
					(= cycles 2)
				)
			)
			(5
				((ScriptID 13 0) ; aEgoTalker
					client: gEgo
					mouth: 0
					view: -1
					loop: -1
					clientCel: -2
					mouth_x: -999
					mouth_y: -999
					hide_mouth: 0
				)
				(wereBear
					view: 3153
					x: 169
					y: 108
					setLoop: 0
					cel: 14
					setPri: 120
				)
				(sfx number: 3152 setLoop: 1 loop: 1 play: setVol: 127)
				(wereBear cycleSpeed: 4 setCycle: CT 16 1 self)
			)
			(6
				(wereBear cel: 17)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= cycles 1)
			)
			(7
				(wereBear cel: 18)
				(gEgo z: 1000)
				(UpdateScreenItem wereBear)
				(UpdateScreenItem gEgo)
				(FrameOut)
				(sfx2 number: 1003 setLoop: 1 loop: 1 play: self setVol: 127)
			)
			(8
				(wereBear setCycle: End self)
			)
			(9
				(localproc_2 1 self)
			)
			(10
				(= next rosieDeadScr)
				(self dispose:)
			)
		)
	)
)

(instance rosieRunsAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(gEgo
					normalize: 7 9022
					illegalBits: 0
					ignoreActors: 1
					setHeading: 270 self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 8371
					setCycle: Fwd
					x: 193
					y: 122
					setStep: 12 12
					setLoop: 1 1
					setMotion: MoveTo -35 123 self
				)
				(localproc_2 1)
			)
			(3
				(gCurRoom newRoom: 4550)
			)
		)
	)
)

(instance valRunsAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wereBear
					view: 3151
					setLoop: 5 1
					cel: 0
					x: 163
					y: 108
					cycleSpeed: 4
				)
				(gEgo
					view: 801
					setLoop: 0 1
					setCycle: Fwd
					x: 231
					y: 112
					z: 0
					setStep: 8 3
					setScaler: Scaler 100 65 135 80
					setMotion: MoveTo 466 82 self
				)
				(localproc_2 1)
				(= ticks local50)
			)
			(1
				(wereBear cycleSpeed: 2 setCycle: End)
			)
			(2
				(gEgo
					setCycle: 0
					normalize: 0
					illegalBits: 0
					ignoreActors: 1
				)
				(wereBear view: 996 z: 0)
				(localproc_3)
				(= cycles 2)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(localproc_5)
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance throwPellet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_0)
				(proc98_4 128 3154)
				(wereBear
					view: 3154
					setCycle: 0
					x: 196
					y: 121
					setLoop: 1 1
					cel: 0
				)
				(gEgo
					view: 3154
					cel: 0
					setCycle: 0
					setLoop: 0 1
					x: 199
					y: 124
					cycleSpeed: 6
					setScaler: 0
					setScale: 0
				)
				(proc98_3 128 9022 3153 31500)
				(proc98_4 140 841 3163 842)
				(= ticks 60)
			)
			(1
				(gEgo setCycle: CT 5 1 self)
			)
			(2
				(= ticks 90)
			)
			(3
				(gEgo cel: 6)
				(= ticks 10)
			)
			(4
				(gEgo cel: 7)
				(= ticks 10)
			)
			(5
				(gEgo cel: 8)
				(sfx number: 842 setLoop: 1 loop: 1 play: setVol: 90)
				(UpdateScreenItem gEgo)
				(FrameOut)
				(= cycles 1)
			)
			(6
				(wereBear setScript: cryLikeABaby self)
				(gEgo cycleSpeed: 8 cel: 9 setCycle: CT 12 1 self)
			)
			(7
				(= ticks 60)
			)
			(8
				(gEgo cel: 13 setCycle: CT 17 1 self)
			)
			(9
				(gEgo cel: 0)
			)
			(10
				(wereBear cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance cryLikeABaby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfx2 number: 841 setLoop: 1 loop: 1 play: setVol: 127)
				(wereBear cel: 1)
				(= ticks 60)
			)
			(1
				(bearSfx number: 3163 setLoop: 1 loop: 1 play: setVol: 127)
				(wereBear cel: 2)
				(= ticks 60)
			)
			(2
				(wereBear cel: 3)
				(= ticks 60)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance rosieBearComesOut of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc98_5)
				(= local41 1)
				(= local47 0)
				(music2 setVol: 120)
				(if (IsFlag 151)
					(gEgo x: 208 y: 124)
				else
					(gEgo x: 210 y: 120)
				)
				(gEgo setMotion: 0 setHeading: 310 self)
			)
			(1
				(if (IsFlag 151)
					(gEgo view: 3153 x: 209 y: 124 setLoop: 1 cel: 0)
				)
				(music2 setVol: 115)
				(sfx number: 3152 setLoop: 1 loop: 1 play: setVol: 127)
				(wereBear
					view: 33151
					x: 170
					y: 109
					setLoop: 1
					cel: 0
					setPri: 10
					init:
				)
				(= ticks 90)
			)
			(2
				(music2 setVol: 110)
				(localproc_2 1)
				(wereBear cel: 1)
				(= ticks 60)
			)
			(3
				(wereBear cel: 2)
				(= ticks 60)
			)
			(4
				(wereBear cel: 3 setPri: -1)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= ticks 30)
			)
			(5
				(wereBear setLoop: 2 cel: 0)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= ticks 10)
			)
			(6
				(wereBear cel: 1)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(bearSfx number: 3163 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 180)
			)
			(7
				(wereBear cycleSpeed: 8 setCycle: End self)
			)
			(8
				(if (not (IsFlag 151))
					(= next eatRosie_NOT_Black)
					(self dispose:)
				else
					((ScriptID 19 0) code: EastExitCode) ; eastFeat
					((ScriptID 19 1) code: WestExitCode) ; westFeat
					(proc98_6)
					(= register 15)
					(= cycles 2)
				)
			)
			(9
				(-- register)
				(cond
					(local46
						(proc98_5)
						(= next rosieRunsAway)
						(self dispose:)
					)
					((== local45 37)
						(proc98_5)
						(self setScript: throwPellet self)
					)
					((== local45 86)
						(proc98_5)
						(sfx number: 12 setLoop: 1 loop: 1 play: setVol: 127)
						(= next useSling)
						(self dispose:)
					)
					((or local45 (not register))
						(proc98_5)
						(= cycles 2)
					)
					(else
						(= temp0 -1)
						(cond
							((bearSfx handle:)
								(switch (Random 1 2)
									(1
										(= temp0 8)
									)
									(2
										(= temp0 14)
									)
								)
							)
							((not (Random 0 4))
								(wereBear
									view: 33151
									x: 170
									y: 109
									setLoop: 2 1
									cel: (Random 2 4)
								)
							)
							((not (Random 0 4))
								(wereBear
									view: 3154
									x: 196
									y: 121
									setLoop: 1 1
									cel: 0
								)
							)
							(else
								(switch (Random 1 20)
									(1
										(= temp0 0)
									)
									(2
										(= temp0 (Random 5 7))
									)
									(3
										(= temp0 (Random 9 13))
									)
									(4
										(= temp0 8)
										(localproc_2 1)
									)
									(5
										(= temp0 14)
										(localproc_2 1)
									)
								)
							)
						)
						(if (!= temp0 -1)
							(wereBear
								view: 3153
								x: 169
								y: 108
								setLoop: 0 1
								cel: temp0
							)
						)
						(-- state)
						(= ticks (Random 30 90))
					)
				)
			)
			(10
				(= next eatRosieInBlack)
				(self dispose:)
			)
		)
	)
)

(instance useSling of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local40 1)
				(= local41 1)
				(localproc_4)
				(= cycles 2)
			)
			(1
				(wereBear view: 31555 x: 126 y: 114 setLoop: 1 cel: 0)
				(gEgo
					view: 3155
					x: 209
					y: 124
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(2
				(sfx number: 3162 setLoop: 1 loop: 1 play: setVol: 127)
				(wereBear cycleSpeed: 6 setCycle: CT 5 1)
				(gEgo setCycle: CT 8 1 self)
			)
			(3
				(wereBear setCycle: CT 7 1)
				(gEgo setCycle: CT 11 1 self)
			)
			(4
				(sfx stop:)
				(sfx2 number: 854 setLoop: 1 loop: 1 play: setVol: 127)
				(wereBear setCycle: End self)
				(gEgo setCycle: End self)
			)
			(5)
			(6
				(wereBear hide:)
				(gEgo
					normalize: 3 9022
					illegalBits: 0
					ignoreActors: 1
					setMotion: PolyPath 246 107 self
				)
				(= cycles 40)
			)
			(7
				(useSlingEyes init:)
			)
			(8
				(sfx number: 3161 setLoop: 1 loop: 1 play: 40 0)
				(gEgo setHeading: 270 self)
			)
			(9
				(useSlingEyes setCycle: End self)
			)
			(10
				(gEgo setHeading: 90 self)
				(useSlingEyes dispose:)
			)
			(11
				(gEgo
					view: 8371
					setLoop: 0 1
					cel: 0
					moveSpeed: 4
					cycleSpeed: 6
					setCycle: Walk
					setScaler: Scaler 100 65 135 80
					setMotion: MoveTo 294 93 self
				)
			)
			(12
				(gEgo setMotion: MoveTo 345 91 self)
			)
			(13
				(sfx stop:)
				(sfx2 number: 3152 setLoop: 1 loop: 1 play: setVol: 127)
				(wereBear
					view: 3156
					setLoop: 1 1
					cel: 0
					x: 285
					y: 64
					show:
					setCycle: CT 7 1 self
				)
			)
			(14
				(ClearFlag 151)
				(wereBear cycleSpeed: 6 cel: 8 setCycle: CT 10 1 wereBear)
				(gEgo
					view: 3156
					setLoop: 2
					cel: 1
					x: 341
					y: 97
					setCycle: CT 5 1 self
				)
			)
			(15
				(gEgo put: 54) ; Veil
				(gEgo put: 63) ; Sling
				(gEgo get: 61 1) ; Woolen_Stocking
				(gEgo
					normalize: 0 837
					illegalBits: 0
					ignoreActors: 1
					setScaler: Scaler 100 65 135 80
					moveSpeed: 4
					cycleSpeed: 6
					posn: 370 90
					setMotion: PolyPath 524 87 self
				)
				(music2 fade:)
				(proc98_5 2)
			)
			(16
				(gEgo
					normalize: 0
					illegalBits: 0
					ignoreActors: 1
					setHeading: 180 self
				)
			)
			(17
				(SetFlag 560)
				(localproc_5)
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance valBearComesOut of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc98_5)
				(= local47 0)
				(proc98_0 0)
				(proc98_4 128 31511 3151 31512)
				(if (not local48)
					(gEgo setMotion: MoveTo 212 110 self)
				else
					(= cycles 2)
				)
			)
			(1
				(wereBear
					view: local43
					setLoop: 5 1
					z: 0
					x: 171
					y: 64
					setPri: 10
					cel: 0
				)
				(if (not (gCast contains: wereBear))
					(wereBear init: show:)
				else
					(wereBear show:)
				)
				(= cycles 2)
			)
			(2
				(gEgo setMotion: 0 setHeading: 310 self)
			)
			(3
				(wereBear cycleSpeed: 4 setCycle: End self)
				(sfx number: 3152 setLoop: 1 loop: 1 play: setVol: 127)
				(proc98_4 140 3154 3163)
			)
			(4
				(wereBear
					view: 3151
					setLoop: 1 1
					cel: 0
					setPri: 10
					x: 170
					y: 109
				)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= ticks 30)
			)
			(5
				(wereBear cel: 1)
				(gEgo
					view: 3151
					setLoop: 6
					x: 212
					y: 110
					cel: 0
					setScaler: 0
					setScale: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(rndSfx number: 3154 setLoop: 1 loop: 1 play: self setVol: 127)
				(UpdateScreenItem gEgo)
				(UpdateScreenItem wereBear)
				(FrameOut)
			)
			(6)
			(7
				(gEgo view: 996 z: 1000 setLoop: 0 cel: 0 setCycle: 0)
				(wereBear cel: 2)
				(UpdateScreenItem wereBear)
				(UpdateScreenItem gEgo)
				(FrameOut)
				(= ticks local50)
			)
			(8
				(wereBear setPri: -1 cel: 3)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= ticks local50)
			)
			(9
				(wereBear view: 31511 setLoop: 0 1 cel: 0 x: 169 y: 107)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= ticks local50)
			)
			(10
				(wereBear cel: 1)
				(bearSfx number: 3163 setLoop: 1 loop: 1 play: setVol: 127)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(= ticks 120)
			)
			(11
				(proc98_3 140 3154)
				(proc98_3 128 3151)
				((ScriptID 19 0) code: EastExitCode) ; eastFeat
				((ScriptID 19 1) code: WestExitCode) ; westFeat
				(wereBear cel: 2)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(if (IsFlag 559)
					(= register 1)
					(= cycles 2)
				else
					(= register 15)
					(proc98_6)
					(self cue:)
				)
			)
			(12
				(bearSfx stop:)
				(-- register)
				(switch (Random 1 2)
					(1
						(wereBear view: 31512 setLoop: 0 1 cel: (Random 0 2))
					)
					(2
						(wereBear view: 31511 setLoop: 0 1 cel: (Random 3 4))
					)
				)
				(UpdateScreenItem wereBear)
				(FrameOut)
				(cond
					(local46
						(proc98_5)
						(= next valRunsAway)
						(self dispose:)
					)
					(local45
						(proc98_5)
						(= cycles 2)
					)
					((not register)
						(proc98_5)
						(= cycles 2)
					)
					(
						(and
							(localproc_0)
							(== (wereBear view:) 31512)
							(== (wereBear cel:) 2)
						)
						(localproc_2 1)
						(-- state)
						(= ticks 240)
					)
					(else
						(-- state)
						(= ticks (Random 30 90))
					)
				)
			)
			(13
				(bearSfx stop:)
				(proc98_3 140 3051 845)
				(proc98_4 140 3153 4102)
				(= cycles 2)
			)
			(14
				(wereBear
					view: 31512
					setLoop: 0
					cel: 0
					cycleSpeed: 4
					setCycle: CT 6 1 self
				)
				(sfx number: 3152 setLoop: 1 loop: 1 play: setVol: 127)
			)
			(15
				(= cycles 2)
			)
			(16
				((ScriptID 13 0) ; aEgoTalker
					view: (wereBear view:)
					loop: 2
					clientCel: 6
					client: wereBear
				)
				(cond
					((== local45 8)
						(gMessager say: 1 8 0 0 self) ; "(SCARED)S-STOP! There's no need to--"
					)
					((!= local45 999)
						(gMessager say: 1 0 1 0 self) ; "(SCARED)Now just a moment, sir. could I interest you in--"
					)
					(else
						(= cycles 2)
					)
				)
			)
			(17
				((ScriptID 13 0) ; aEgoTalker
					client: gEgo
					mouth: 0
					view: -1
					loop: -1
					clientCel: -2
					mouth_x: -999
					mouth_y: -999
					hide_mouth: 0
				)
				(wereBear cel: 7)
				(rndSfx number: 4551 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 180)
			)
			(18
				(leEyes view: 996 z: 1000)
				(wereBear view: 996 z: 1000)
				(gEgo view: 996 z: 1000)
				((= local0 (Plane new:))
					setRect: 0 0 319 (gThePlane bottom:)
					back: 0
					picture: -1
					priority: 1000
					init:
				)
				(if (or local68 (proc98_9))
					(self setScript: munchScript self)
				else
					(= cycles 2)
				)
			)
			(19
				(bearSfx stop:)
				(sfx stop:)
				(rndSfx stop:)
				(music2 setVol: 0 stop:)
				(gKqMusic1 setVol: 0 stop:)
				(local0 dispose:)
				(= local0 0)
				(= local41 1)
				(EgoDead 63 self 1)
			)
			(20
				(= local41 0)
				(ClearFlag 5)
				(if (not (IsFlag 559))
					(gEgo
						normalize: 5 800
						illegalBits: 0
						ignoreActors: 1
						z: 0
						x: 500
						y: 92
						loop: 8
						cel: 5
						heading: 225
						setScaler: Scaler 100 65 135 80
						init:
					)
					(localproc_3)
				else
					(gEgo
						x: 75
						y: 130
						setMotion: 0
						heading: 90
						loop: 8
						cel: 0
						normalize: 0 800
						illegalBits: 0
						ignoreActors: 1
						setScaler: Scaler 100 65 135 80
						init:
					)
					(localproc_4)
				)
				(localproc_5)
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance putOnSalve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(if (not (IsFlag 218))
					(gMessager say: 2 72 3 1 self) ; "(THINKS TO HERSELF)Oh! That's right. The salesman said to add animal fur to the salve for it to work."
				else
					(proc98_4 140 872 1463 1464)
					(SetFlag 559)
					(sfx number: 12 setLoop: 1 loop: 1 play: setVol: 127)
					(++ state)
					(gEgo setMotion: PolyPath 500 78 self)
				)
			)
			(1
				(proc98_6 1)
				(self dispose:)
			)
			(2
				(= local40 1)
				(localproc_3)
				(gEgo setSpeed: 12 setHeading: 180 self)
			)
			(3
				(proc98_4 140 25170 3156)
				(proc98_4 128 3158 3163)
				(= cycles 2)
			)
			(4
				(proc98_3 128 800)
				(= local41 1)
				(gKqMusic1 setVol: 120)
				(gEgo
					view: 3158
					setScaler: 0
					setScale: 0
					x: 496
					y: 80
					setLoop: 0
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(5
				(sfx number: 3156 setLoop: 1 loop: 1 play: setVol: 127)
				(gEgo cel: 6 setCycle: CT 14 1 self)
			)
			(6
				(gKqMusic1 setVol: 90)
				(sfx2 number: 25170 setLoop: 1 loop: 1 play: 127 self)
				(lidOnFloor setPri: (+ (gEgo priority:) 1) init:)
			)
			(7
				(proc98_3 140 3156 2517)
				(proc98_4 140 31561 31562)
				(= cycles 2)
			)
			(8
				(gKqMusic1 setVol: 85)
				(= register 2)
				(gEgo setCycle: CT 15 1 self)
			)
			(9
				(gKqMusic1 setVol: 80)
				(sfx number: 31561 play: self)
				(gEgo setCycle: CT 22 1 self)
			)
			(10
				(gKqMusic1 setVol: 75)
				(sfx number: 31562 setLoop: -1 loop: -1 play: setVol: 127)
				(gEgo setCycle: ROsc 2 22 27 self)
			)
			(11
				(sfx number: 0 setLoop: 1 loop: 0 stop:)
				(proc98_3 140 31561 31562)
				(proc98_4 140 3051 845 839 843)
				(gEgo cel: 28 setCycle: CT 30 1 self)
			)
			(12
				(gKqMusic1 setVol: 70)
				(sfx number: 3051 setLoop: 1 loop: 1 play: setVol: 127)
				(boxOnFloor setPri: (+ (gEgo priority:) 1) init:)
				(gEgo cel: 31)
				(= ticks 30)
			)
			(13
				(gKqMusic1 setVol: 60)
				(gEgo put: 65) ; Were-beast_Salve
				(gEgo cel: 32)
				(= cycles 2)
			)
			(14
				((ScriptID 13 0) clientCel: 32) ; aEgoTalker
				(gMessager say: 2 72 4 1 self) ; "Oh! I feel so strange!"
			)
			(15
				((ScriptID 13 0) ; aEgoTalker
					client: gEgo
					mouth: 0
					view: -1
					loop: -1
					clientCel: -2
					mouth_x: -999
					mouth_y: -999
					hide_mouth: 0
				)
				(gKqMusic1 setVol: 55)
				(sfx number: 859 setLoop: -1 loop: -1 play: setVol: 127)
				(gEgo cel: 33)
				(= ticks 10)
			)
			(16
				(sfx2 number: 845 setLoop: 1 loop: 1 play: setVol: 127)
				(gEgo cel: 37)
				(= ticks 30)
			)
			(17
				(sfx2 number: 839 setLoop: 1 loop: 1 play: setVol: 127)
				(gEgo cel: 38)
				(= ticks 30)
			)
			(18
				(gEgo cel: 37)
				(switch (Random 1 3)
					(1
						(= register 872)
					)
					(2
						(= register 1463)
					)
					(3
						(= register 1464)
					)
				)
				(rndSfx number: register setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 90)
			)
			(19
				(sfx2 number: 0 setLoop: 1 stop:)
				(gEgo cel: 36 setCycle: CT 42 1 self)
			)
			(20
				(gEgo setCycle: CT 39 -1 self)
			)
			(21
				(gEgo setCycle: CT 42 1 self)
			)
			(22
				(= register 4)
				(gEgo setCycle: CT 46 1 self)
			)
			(23
				(gEgo cel: 45)
				(= ticks 10)
			)
			(24
				(if (not (sfx2 handle:))
					(sfx2 number: 3157 setLoop: 1 loop: 1 play: setVol: 127)
				)
				(gEgo cel: 46)
				(if (-- register)
					(-= state 2)
				)
				(= ticks 10)
			)
			(25
				(proc98_3 140 3051 816 845 839 843 842)
				(gEgo cel: 47)
				(= ticks 10)
			)
			(26
				(gEgo setCycle: End self)
				(sfx setLoop: 1 fade:)
			)
			(27
				(gEgo setLoop: 3 1)
				((ScriptID 13 0) clientCel: 0) ; aEgoTalker
				(gMessager say: 2 72 4 2 self) ; "(AS A JACKALOPE)Ee hee hee hee hee!"
				(gKqMusic1 fade:)
			)
			(28
				(proc98_4 140 2484 2510)
				((ScriptID 13 0) ; aEgoTalker
					client: gEgo
					mouth: 0
					view: -1
					loop: -1
					clientCel: -2
					mouth_x: -999
					mouth_y: -999
					hide_mouth: 0
				)
				(sfx number: 3158 setLoop: -1 loop: -1 play: setVol: 127)
				(= ticks 10)
			)
			(29
				(gEgo
					view: 3159
					x: 404
					y: 83
					setLoop: 0
					cel: 0
					setSpeed: 4
					setCycle: CT 2 1 self
				)
			)
			(30
				(switch (Random 1 4)
					(1
						(= register 816)
					)
					(2
						(= register 2484)
					)
					(3
						(= register 2510)
					)
					(4
						(= register 842)
					)
				)
				(rndSfx number: register setLoop: 1 loop: 1 play: setVol: 127)
				(gEgo cel: 3 setCycle: CT 6 1 self)
				(UpdateScreenItem gEgo)
				(FrameOut)
			)
			(31
				(gEgo x: 440 y: 85 cel: 7)
				(= cycles 2)
			)
			(32
				(gEgo cel: 8)
				(= cycles 2)
			)
			(33
				(gEgo x: 371 y: 102 cel: 7 setScaler: Scaler 125 132 91 90)
				(= cycles 2)
			)
			(34
				(= local47 0)
				(gEgo view: 996 z: 1000 setScaler: 0 setScale: 0)
				(UpdateScreenItem gEgo)
				(FrameOut)
				(proc98_3 128 3158 3163)
				(= ticks 30)
			)
			(35
				(proc98_4 128 3160 3161 3162)
				(wereBear
					view: 3163
					x: 145
					y: 136
					setLoop: 1
					cel: 0
					setPri: 175
					init:
				)
				(UpdateScreenItem wereBear)
				(localproc_4)
				(bearSfx number: 3161 setLoop: 1 loop: 1 play: setVol: 127)
				(wereBear cycleSpeed: 6 setCycle: End self)
			)
			(36
				(gEgo
					view: 3160
					x: 169
					y: 137
					z: 0
					setLoop: 0
					cel: 0
					setCycle: 0
					setPri: 180
				)
				(wereBear
					view: 3161
					x: 145
					y: 136
					setLoop: 0
					cel: 0
					setCycle: 0
				)
				(sfx2 number: 4102 setLoop: -1 loop: -1 play: setVol: 127)
				(= ticks 10)
			)
			(37
				(gEgo cel: 1)
				(= ticks 10)
			)
			(38
				(wereBear cel: 1)
				(= ticks 10)
			)
			(39
				(wereBear cel: 2)
				(gEgo cel: 2)
				(= ticks 10)
			)
			(40
				(wereBear cel: 3)
				(= ticks 10)
			)
			(41
				(wereBear cel: 4)
				(gEgo cel: 3)
				(= ticks 10)
			)
			(42
				(wereBear cel: 5)
				(= local10 5)
				(= local11 3)
				(= ticks 10)
			)
			(43
				(++ local10)
				(++ local11)
				(wereBear cel: local10)
				(gEgo cel: local11)
				(if (< local10 10)
					(-- state)
				)
				(= ticks 10)
			)
			(44
				(wereBear view: 3162 setLoop: 0 1 cel: 0)
				(gEgo cel: 9)
				(= local10 0)
				(= local11 9)
				(= ticks 10)
			)
			(45
				(if (== (++ local11) 11)
					(wereBear cycleSpeed: 24 setCycle: End)
				)
				(gEgo cel: local11)
				(if (< local11 16)
					(-- state)
				)
				(if (== local11 15)
					(rndSfx number: 1208 setLoop: 1 loop: 1 play: setVol: 127)
				)
				(= ticks 10)
			)
			(46
				(sfx2 fade:)
				(gEgo cel: 17)
				(= ticks 10)
			)
			(47
				(gEgo cel: 18)
				(= ticks 10)
			)
			(48
				(gKqMusic1 fade:)
				(rndSfx fade:)
				(gEgo setCycle: End self)
			)
			(49
				(if (or (rndSfx handle:) (gKqMusic1 handle:))
					(-- state)
				)
				(= ticks 30)
			)
			(50
				(SetFlag 208)
				(gCurRoom newRoom: 4550)
			)
		)
	)
)

