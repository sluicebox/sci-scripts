;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1300)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	endGameRm 0
)

(local
	local0
	local1 = -1
	local2 = 1
)

(procedure (localproc_0)
	(if (gCast contains: gEgo)
		(gCurRoom drawPic: 11903 0 1)
		(gEgo dispose:)
		(leber2 dispose:)
		(gabe dispose:)
		(vonGlower2 dispose:)
		(furnaceDoor2 dispose:)
		((ScriptID 0 4) loop: 15 mask:) ; inventoryButton
		(UpdateScreenItem (ScriptID 0 4)) ; inventoryButton
		(grace init:)
		(leber1 init:)
		(vonGlower1 init:)
		(furnaceDoor1 init:)
	else
		(gCurRoom drawPic: 11901 0 1)
		(grace dispose:)
		(leber1 dispose:)
		(vonGlower1 dispose:)
		(furnaceDoor1 dispose:)
		((ScriptID 0 4) loop: 0 mask:) ; inventoryButton
		(UpdateScreenItem (ScriptID 0 4)) ; inventoryButton
		(gEgo
			posn: 134 290
			heading: 135
			BAD_SELECTOR:
			init:
			view: 21930
			setLoop: 0 1
			cycleSpeed: 6
			setScale: 0
			setScript: (sFastFidget new:)
		)
		(Palette 1 (= global249 248)) ; PalLoad
		(gabe init:)
		(leber2 init:)
		(vonGlower2 init:)
		(furnaceDoor2 init:)
	)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0)
	(= temp0 (attackTimer seconds:))
	(attackTimer dispose: delete:)
	(cond
		((== argc 3)
			(PlayScene param1 param2 param3)
		)
		((== argc 2)
			(PlayScene param1 param2)
		)
		(else
			(PlayScene param1)
		)
	)
	(attackTimer setReal: sGlowerAttack temp0)
)

(instance endGameRm of ExitRoom ; "Wittelsbacher Theater: Furnace Room"
	(properties
		modNum 1190
		noun 17
		picture 11903
	)

	(method (init)
		(= gEgo GraceEgo)
		(gUser alterEgo: gEgo)
		(SetFlag 739)
		(Load 140 15012) ; WAVE
		((ScriptID 0 4) loop: 15 mask:) ; inventoryButton
		(UpdateScreenItem (ScriptID 0 4)) ; inventoryButton
		(ClearFlag 797)
		(grace init:)
		(leber1 init:)
		(vonGlower1 init:)
		(furnaceDoor1 init:)
		(closedFire2 init:)
		(Palette 2 0 255 0) ; PalIntensity
		(super init: &rest)
		(if (== gPrevRoomNum 666) ; uDie
			(gGk2Music number: 15000 setLoop: -1 play:)
			(proc11_13)
			(self cue:)
		else
			(PlayScene 930 self)
		)
		(gGk2Music setVol: 31)
	)

	(method (cue)
		(gCurRoom setScript: sGlowerAttack)
	)

	(method (newRoom newRoomNumber)
		(if local2
			(gCurRoom setScript: fadeScript 0 newRoomNumber)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance fadeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGk2Music fade: 0 20 10 1 self)
			)
			(1
				(= local2 0)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance sGlowerAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(attackTimer setReal: self 15)
			)
			(2
				(attackTimer dispose: delete:)
				(= local0 1)
				(if (gCast contains: gEgo)
					(if (IsFlag 797)
						(PlayScene 1930 0 666) ; uDie
					else
						(PlayScene 931 0 666) ; uDie
					)
					(self dispose:)
				else
					((gUser BAD_SELECTOR:) delete: grace)
					((gUser BAD_SELECTOR:) delete: leber1)
					((gUser BAD_SELECTOR:) delete: furnaceDoor1)
					(PlayScene 913)
					((leber1 script:) dispose:)
					(leber1 setCycle: 0)
					(cond
						((> (leber1 cel:) 6)
							(leber1 setCycle: CT 6 -1)
						)
						((< (leber1 cel:) 6)
							(leber1 setCycle: CT 6 1)
						)
					)
					(= cycles 1)
				)
			)
			(3
				(if (vonGlower1 script:)
					((vonGlower1 script:) dispose:)
				)
				(vonGlower1 setCycle: 0)
				(vonGlower1
					view: 23903
					setLoop: 0 1
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(cond
					((<= 0 local1 6)
						(if (IsFlag 797)
							(grace dispose:)
							(leber1 dispose:)
							(vonGlower1 dispose:)
							(furnaceDoor1 dispose:)
							(furnaceDoor1Open dispose:)
							(openFire2 dispose:)
							(gGk2Music stop:)
							(PlayScene 941 self -1)
						else
							(PlayScene 942 0 666) ; uDie
							(self dispose:)
						)
					)
					((> local1 6)
						(if (IsFlag 797)
							(PlayScene 1940 0 666) ; uDie
						else
							(PlayScene 940 0 666) ; uDie
						)
						(self dispose:)
					)
					(else
						(PlayScene 5930 0 666) ; uDie
						(self dispose:)
					)
				)
			)
			(5
				(switch (gGame printLang:)
					(351
						(gTopMessage
							BAD_SELECTOR: {Cap\a1tulo 6: Filme de Encerramento}
						)
					)
					(39
						(gTopMessage BAD_SELECTOR: {Capitolo 6: Scena Finale})
					)
					(else
						(gTopMessage BAD_SELECTOR: {Chapter Six: Ending Movie})
					)
				)
				(PlayScene 1010 self -1)
			)
			(6
				(gTopMessage BAD_SELECTOR: 0)
				(gCurRoom drawPic: -1)
				(= cycles 3)
			)
			(7
				(= local2 0)
				(gCurRoom newRoom: 92) ; endRoom
			)
		)
	)
)

(instance grace of Prop
	(properties
		modNum 1190
		x 172
		y 311
		view 20931
	)

	(method (init)
		(super init: &rest)
		(self setScript: (sFastFidget new:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gGame changeScore: 1138)
				(localproc_1 935)
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leber1 of Prop
	(properties
		modNum 1190
		x 81
		y 334
		view 20932
	)

	(method (init)
		(super init: &rest)
		(self setScript: (sFastFidget new:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(attackTimer dispose: delete:)
				(if (IsFlag 797)
					(PlayScene 1933 0 666) ; uDie
				else
					(PlayScene 933 0 666) ; uDie
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leber2 of Prop
	(properties
		modNum 1190
		sightAngle 360
		x 39
		y 360
		view 20930
	)

	(method (init)
		(super init: &rest)
		(self setScript: (sFastFidget new:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(attackTimer dispose: delete:)
				(PlayScene 934 0 666) ; uDie
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gabe of Prop
	(properties
		modNum 1190
		sightAngle 360
		x 308
		y 333
		view 22901
	)

	(method (init)
		(super init: &rest)
		(self setScript: (sFastFidget new:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gGame changeScore: 1139)
				(localproc_1 937)
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFastFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 240))
			)
			(1
				(client
					cel: 0
					setLoop: (Random 0 (NumLoops client))
					setCycle: End self
				)
			)
			(2
				(client cel: 0 show:)
				(self changeState: 0)
			)
		)
	)
)

(instance vonGlower1 of Prop
	(properties
		modNum 1190
		sightAngle 360
		x 473
		y 323
		view 22903
	)

	(method (init)
		(super init: &rest)
		(self setScript: sGlowerFidget)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if local0
					(gGame handsOff:)
					(= local1 (vonGlower1 cel:))
				else
					(attackTimer dispose: delete:)
					(if (IsFlag 797)
						(PlayScene 1938)
						(PlayScene 2938 0 666) ; uDie
					else
						(PlayScene 938)
						(PlayScene 2938 0 666) ; uDie
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sGlowerFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setLoop: 1 1 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance vonGlower2 of Prop
	(properties
		modNum 1190
		sightAngle 360
		x 461
		y 262
		view 23901
	)

	(method (init)
		(super init: &rest)
		(self setScript: sGlowerFidget)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 18 theVerb 0 0 0 modNum) ; "(CLICK ON VON GLOWER THE WOLF WHILE PLAYING GRACE)I can't attack him by myself!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance furnaceDoorOpen of View
	(properties
		modNum 1190
		sightAngle 360
		x 263
		y 200
		view 30936
	)

	(method (init)
		(super init: &rest)
		(openFire1 init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 16 theVerb 0 0 0 modNum) ; "(FINAL SCENE WITH WOVLES, TRY TO OPEN DOOR WHEN IT'S ALREADY OPEN, URGENT)It's already open!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(openFire1 dispose:)
	)
)

(instance openFire1 of Prop
	(properties
		x 281
		y 174
		view 20901
	)

	(method (init)
		(super init: &rest)
		(self setPri: 250)
		((gUser BAD_SELECTOR:) delete: self)
		(self setCycle: Fwd)
	)

	(method (onMe)
		(return 0)
	)
)

(instance closedFire1 of Prop
	(properties
		x 282
		y 171
		view 21901
	)

	(method (init)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
		(self setCycle: Fwd)
	)

	(method (onMe)
		(return 0)
	)
)

(instance furnaceDoor1Open of View
	(properties
		modNum 1190
		sightAngle 360
		x 280
		y 240
		view 30937
	)

	(method (init)
		(super init: &rest)
		(openFire2 init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(sfxWolfWhine play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(openFire2 dispose:)
	)
)

(instance openFire2 of Prop
	(properties
		x 295
		y 221
		view 20903
	)

	(method (init)
		(super init: &rest)
		(self setPri: 250)
		((gUser BAD_SELECTOR:) delete: self)
		(self setCycle: Fwd)
	)

	(method (onMe)
		(return 0)
	)
)

(instance closedFire2 of Prop
	(properties
		x 295
		y 222
		view 21903
	)

	(method (init)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
		(self setCycle: Fwd)
	)

	(method (onMe)
		(return 0)
	)
)

(instance furnaceDoor1 of GKFeature
	(properties
		modNum 1190
		x 339
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 291 148 388 148 388 226 291 226
					yourself:
				)
		)
		(super init: &rest)
		(cond
			((IsFlag 797)
				(furnaceDoor1Open init:)
				(closedFire1 dispose:)
			)
			((not (gCast contains: closedFire2))
				(closedFire2 init:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(sfxWolfWhine play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (IsFlag 797)
			(furnaceDoor1Open dispose:)
		else
			(closedFire2 dispose:)
		)
		(super dispose: &rest)
	)
)

(instance furnaceDoor2 of GKFeature
	(properties
		modNum 1190
		sightAngle 360
		x 331
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 94 384 90 385 169 271 177
					yourself:
				)
		)
		(if (IsFlag 797)
			(furnaceDoorOpen init:)
			(closedFire2 dispose:)
		else
			(closedFire1 init:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 797)
					(gMessager say: 16 theVerb 0 0 0 modNum) ; "(FINAL SCENE WITH WOVLES, TRY TO OPEN DOOR WHEN IT'S ALREADY OPEN, URGENT)It's already open!"
				else
					(SetFlag 797)
					(localproc_1 936)
					(furnaceDoorOpen init:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (IsFlag 797)
			(furnaceDoorOpen dispose:)
		else
			(closedFire1 dispose:)
		)
		(super dispose: &rest)
	)
)

(instance sfxWolfWhine of Sound
	(properties
		number 15012
	)
)

(instance attackTimer of Timer
	(properties)
)

