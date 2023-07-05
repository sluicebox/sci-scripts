;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1500)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Dune)
(use DuneMover)
(use Print)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1500 0
	spirit 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm1500 of KQRoom
	(properties
		picture 1500
	)

	(method (init)
		(if (not global312)
			(if (Random 0 1)
				(self picture: 1110)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 136 320 136 320 113 319 65 272 77 232 77 178 82 142 80 115 88 66 87 46 72 0 75
							yourself:
						)
				)
			else
				(self picture: 1115)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 136 319 136 319 76 254 82 199 92 138 95 98 92 35 95 0 85
							yourself:
						)
				)
			)
		)
		(super init: &rest)
		(gGame handsOn:)
		(gEgo init: normalize:)
		(Load rsMESSAGE 1500)
		(Load rsVIEW 9101)
		(if
			(and
				(== gChapter 1)
				(not (and (== global313 0) (== global314 2)))
				(not (and (== global313 4) (== global314 4)))
				(not (IsFlag 17))
				(not (IsFlag 18))
				(Random 0 1)
			)
			(spirit init:)
		)
		(if global312
			(desertNorth init:)
		)
		(desertSouth init:)
		(desertEast init:)
		(desertWest init:)
		(if global312
			(duneManager add: dune1 dune2 dune3 dune4 eachElementDo: #init)
		)
		(if (!= gPrevRoomNum 1600)
			(if (and (not (IsFlag 18)) (IsFlag 17))
				(spirit init:)
				(self setScript: wander)
			else
				(self setScript: walkIn)
			)
		else
			(self setScript: walkIn)
		)
		(if
			(and
				(<= ((ScriptID 0 7) seconds:) 0) ; desertDeathTimer
				(<= ((ScriptID 0 8) seconds:) 0) ; stormDeathTimer
			)
			((ScriptID 0 7) setReal: (ScriptID 0 7) 120) ; desertDeathTimer, desertDeathTimer
		)
		(if (IsFlag 5)
			(ClearFlag 5)
		)
		(if global312
			(gCast eachElementDo: #perform duneSetupCode)
		)
		(if (== gPrevRoomNum 26)
			(gKqMusic1
				number: 1320
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
	)

	(method (cue)
		(super cue:)
		(if (and (not (IsFlag 47)) (IsFlag 128))
			(if (gEgo mover:)
				(gEgo setMotion: 0)
			)
			(self setScript: dieOfThirst)
		else
			(if (gEgo mover:)
				(gEgo setMotion: 0)
			)
			(if (== gValOrRoz -3) ; Roz
				(self setScript: dieOfThirst)
			else
				(Load rsVIEW 1503)
				(self setScript: dieFromStorm)
			)
		)
	)

	(method (notify)
		(duneManager setup: gEgo (duneManager curDune:))
	)

	(method (dispose)
		(gEgo setScale: 0 enableHotspot:)
		(if (and (!= picture 1110) (!= picture 1115))
			(duneManager release: dispose:)
		)
		(if (or (== gNewRoomNum 1250) (== gNewRoomNum 1100) (== gNewRoomNum 30))
			((ScriptID 0 7) seconds: -1 client: 0 delete: dispose:) ; desertDeathTimer
			((ScriptID 0 8) seconds: -1 client: 0 delete: dispose:) ; stormDeathTimer
		)
		(super dispose:)
	)
)

(instance dieOfThirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 865) ; WAVE
				(= ticks 30)
			)
			(1
				(gEgo
					view: (if (== gValOrRoz -3) 8411 else 8051) ; Roz
					setLoop: 0
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(gKqSound1 number: 865 setLoop: 1 play: self)
				(gEgo setCel: 4)
			)
			(3
				(if (IsFlag 46)
					(EgoDead 5 self)
				else
					(EgoDead 1 self)
				)
			)
			(4
				(gEgo hide:)
				(if (gCast contains: spirit)
					(spirit setMotion: 0 hide:)
				)
				(UpdatePlane (gThePlane picture: -1 back: 0 yourself:))
				(ClearFlag 46)
				(ClearFlag 128)
				((ScriptID 0 7) seconds: -1 client: 0 delete: dispose:) ; desertDeathTimer
				(= global312 100)
				(= global313 100)
				(if (IsFlag 389)
					(gCurRoom newRoom: 1600)
				else
					(gCurRoom newRoom: 1250)
				)
			)
		)
	)
)

(instance dieFromStorm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 878 setLoop: -1 play:)
				(if global312
					(storm
						init:
						ignoreActors: 1
						setCycle: Fwd
						setLoop: 0 1
						setMotion: DuneMover (gEgo x:) (gEgo y:) self
					)
				else
					(storm
						init:
						ignoreActors: 1
						setCycle: Fwd
						setLoop: 0 1
						setMotion: PolyPath (gEgo x:) (gEgo y:) self
					)
				)
			)
			(1
				(if (== gValOrRoz -4) ; Val
					(gEgo view: 1503 setLoop: 0 setCel: 0 setCycle: End self)
				else
					(Prints {You get buried by the storm.})
					(self cue:)
				)
			)
			(2
				(storm dispose:)
				(EgoDead 6 self)
			)
			(3
				(gKqSound1 setLoop: 1 stop:)
				(gEgo normalize:)
				(if global312
					(duneManager setup: gEgo)
				)
				((ScriptID 0 8) seconds: -1 client: 0 delete: dispose:) ; stormDeathTimer
				((ScriptID 0 8) setReal: (ScriptID 0 8) 120) ; stormDeathTimer, stormDeathTimer
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wander of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch global314
					(1
						(gEgo
							posn: (gEgo x:) 130
							setMotion: DuneMover (gEgo x:) 115 self
						)
					)
					(3
						(gEgo
							posn: (gEgo x:) 30
							setMotion: DuneMover (gEgo x:) 50 self
						)
					)
					(2
						(gEgo
							posn: 10 (gEgo y:)
							setMotion: DuneMover 25 (gEgo y:) self
						)
					)
					(4
						(gEgo
							posn: 315 (gEgo y:)
							setMotion: DuneMover 300 (gEgo y:) self
						)
					)
				)
			)
			(1
				(cond
					((!= global312 4)
						(if (< global312 4)
							(spirit setMotion: PolyPath 125 150 self)
						else
							(spirit setMotion: PolyPath 125 10 self)
						)
					)
					((!= global313 3)
						(if (< global313 3)
							(spirit setMotion: PolyPath 318 70 self)
						else
							(spirit setMotion: PolyPath 1 70 self)
						)
					)
				)
			)
			(2
				(spirit dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkOffScreen of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch global314
					(1
						(gEgo setMotion: DuneMover (gEgo x:) 46 self)
					)
					(3
						(if
							(and
								(!= (gCurRoom picture:) 1110)
								(!= (gCurRoom picture:) 1115)
							)
							(gEgo setMotion: DuneMover (gEgo x:) 175 self)
						else
							(gEgo setMotion: PolyPath (gEgo x:) 175 self)
						)
					)
					(2
						(if global312
							(if
								(>
									(gEgo y:)
									(= temp0 (dune4 findRidge: 320))
								)
								(= temp0 (gEgo y:))
							)
							(gEgo setMotion: DuneMover 319 temp0 self)
						else
							(gEgo setMotion: PolyPath 319 (gEgo y:) self)
						)
					)
					(4
						(if global312
							(if (> (gEgo y:) (= temp0 (dune4 findRidge: 0)))
								(= temp0 (gEgo y:))
							)
							(gEgo setMotion: DuneMover 0 temp0 self)
						else
							(gEgo setMotion: PolyPath 1 (gEgo y:) self)
						)
					)
				)
			)
			(1
				(switch global314
					(3
						(gEgo setMotion: MoveTo (gEgo x:) 193 self)
					)
					(2
						(gEgo setMotion: MoveTo 335 (gEgo y:) self)
					)
					(4
						(gEgo setMotion: MoveTo -13 (gEgo y:) self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if register
					(gCurRoom newRoom: register)
				else
					(= gCurRoomNum 1)
					(gCurRoom newRoom: 1500)
				)
			)
		)
	)
)

(instance freshH2O of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 1511
					setLoop: (if (< (gEgo x:) (spirit x:)) 2 else 3)
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(SetFlag 17)
				(gMessager sayRange: 1 28 0 1 2 self) ; "I wish to give this to you, traveller."
			)
			(2
				(spirit
					view: 1507
					posn: (spirit x:) (- (spirit y:) 4)
					setLoop: (if (< (gEgo x:) (spirit x:)) 0 else 1)
					setCel: 0
					setCycle: End self
				)
				(gEgo setCycle: End)
			)
			(3
				(spirit setCycle: Beg self)
			)
			(4
				(gEgo put: 16 get: 2 setCel: 8 setCycle: CT 5 -1 self) ; Fresh_Water, Clay_Pot
			)
			(5
				(spirit
					view: 9101
					posn: (spirit x:) (+ (spirit y:) 4)
					setLoop: (if (< (spirit x:) (gEgo x:)) 0 else 1)
					setCel: 0
					ignoreActors: 1
					setLoop: -1
					setLooper: gGrooper
					setCycle: StopWalk -1
				)
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo normalize:)
				(if global312
					(duneManager setup: gEgo)
				)
				(gMessager sayRange: 1 28 0 3 5 self) ; "Aah. I thought my thirst would torture me forever. How can I thank you?"
			)
			(7
				(spirit xStep: 7 setSpeed: 11)
				(cond
					((!= global312 4)
						(if (< global312 4)
							(if global312
								(spirit
									setMotion: DuneMover (spirit x:) 175 self
								)
							else
								(spirit
									setMotion: PolyPath (spirit x:) 175 self
								)
							)
						else
							(spirit setMotion: DuneMover (spirit x:) 30 self)
						)
					)
					((!= global313 3)
						(cond
							((< global313 3)
								(if global312
									(spirit setMotion: DuneMover 318 70 self)
								else
									(spirit setMotion: PolyPath 318 70 self)
								)
							)
							(global312
								(spirit setMotion: DuneMover 1 70 self)
							)
							(else
								(spirit setMotion: PolyPath 1 70 self)
							)
						)
					)
				)
				(= ticks 240)
			)
			(8
				(gEgo setSpeed: (spirit setSpeed:))
				(cond
					((!= global312 4)
						(if (< global312 4)
							(if global312
								(gEgo setMotion: DuneMover (gEgo x:) 170)
							else
								(gEgo setMotion: PolyPath (gEgo x:) 170)
							)
						else
							(gEgo setMotion: DuneMover (gEgo x:) 40)
						)
					)
					((!= global313 3)
						(cond
							((< global313 3)
								(if global312
									(gEgo setMotion: DuneMover 298 70)
								else
									(gEgo setMotion: PolyPath 298 70)
								)
							)
							(global312
								(gEgo setMotion: DuneMover 20 70)
							)
							(else
								(gEgo setMotion: PolyPath 20 70)
							)
						)
					)
				)
			)
			(9
				(gCurRoom newRoom: 1600)
			)
		)
	)
)

(instance saltH2O of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 ((ScriptID 0 7) seconds:)) ; desertDeathTimer
				((ScriptID 0 7) client: 0 delete: dispose:) ; desertDeathTimer
				(if (> ((ScriptID 0 8) seconds:) 0) ; stormDeathTimer
					(= local3 ((ScriptID 0 8) seconds:)) ; stormDeathTimer
					((ScriptID 0 8) client: 0 delete: dispose:) ; stormDeathTimer
				)
				(Load 140 943) ; WAVE
				(gEgo
					put: 15 ; Salt_Water
					view: 1511
					setLoop: (if (< (gEgo x:) (spirit x:)) 2 else 3)
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gMessager sayRange: 1 27 3 1 2 self) ; "Here. This is for you."
			)
			(2
				(spirit
					view: 1507
					setLoop: (if (< (gEgo x:) (spirit x:)) 0 else 1)
					setCel: 0
					setCycle: End self
				)
				(gEgo setCycle: End)
			)
			(3
				(spirit setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(if global312
					(duneManager setup: gEgo)
				)
				(spirit
					setLoop: (if (< (gEgo x:) (spirit x:)) 2 else 3)
					setCel: 0
					setCycle: CT 9 1 self
				)
				((ScriptID 7001 3) ; spiritTalker
					client: spirit
					view: 1507
					loop: (+ (spirit loop:) 20)
				)
			)
			(5
				(gKqSound1 number: 943 setLoop: 1 play:)
				(pot
					init:
					x:
						(if (< (gEgo x:) (spirit x:))
							(- (spirit x:) 100)
						else
							(+ (spirit x:) 100)
						)
					y: (- (spirit y:) 18)
					setPri: (spirit priority:)
				)
				(spirit setCycle: End self)
			)
			(6
				(gMessager sayRange: 1 27 3 3 5 self) ; "Bah! You bring me salt water? What manner of heartless joke is this?"
			)
			(7
				(spirit
					view: 9101
					setLoop: (if (< (spirit x:) (gEgo x:)) 0 else 1)
					setCel: 0
					ignoreActors: 1
					setLoop: -1
					setLooper: gGrooper
					xStep: 7
					setSpeed: 11
					setCycle: StopWalk -1
				)
				(cond
					((<= (spirit x:) 40)
						(if global312
							(spirit setMotion: DuneMover 0 100 self)
						else
							(spirit setMotion: PolyPath 0 100 self)
						)
					)
					((>= (spirit x:) 280)
						(if global312
							(spirit setMotion: DuneMover 319 100 self)
						else
							(spirit setMotion: PolyPath 319 100 self)
						)
					)
					(global312
						(spirit setMotion: DuneMover (spirit x:) 185 self)
					)
					(else
						(spirit setMotion: PolyPath (spirit x:) 185 self)
					)
				)
			)
			(8
				(cond
					((<= (spirit x:) 40)
						(spirit setMotion: MoveTo -10 100 self)
					)
					((>= (spirit x:) 280)
						(spirit setMotion: MoveTo 335 100 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(9
				((ScriptID 0 7) setReal: (ScriptID 0 7) (+ local2 5)) ; desertDeathTimer, desertDeathTimer
				(if (and (== gValOrRoz -4) local3) ; Val
					((ScriptID 0 8) setReal: (ScriptID 0 8) (+ local3 5)) ; stormDeathTimer, stormDeathTimer
				)
				((ScriptID 7001 3) view: 39101) ; spiritTalker
				(SetFlag 303)
				(spirit dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance secondSaltGive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 ((ScriptID 0 7) seconds:)) ; desertDeathTimer
				((ScriptID 0 7) client: 0 delete: dispose:) ; desertDeathTimer
				(if (> ((ScriptID 0 8) seconds:) 0) ; stormDeathTimer
					(= local3 ((ScriptID 0 8) seconds:)) ; stormDeathTimer
					((ScriptID 0 8) client: 0 delete: dispose:) ; stormDeathTimer
				)
				(gMessager say: 1 27 4 1 self) ; "This is for you."
			)
			(1
				(gEgo
					view: 1511
					setLoop: (if (< (gEgo x:) (spirit x:)) 2 else 3)
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(2
				(gMessager say: 1 27 4 2 self) ; "Do not toy with me. I can smell the salt from here."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(spirit xStep: 7 setSpeed: 11)
				(cond
					((<= (spirit x:) 40)
						(if global312
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: DuneMover 0 100 self
							)
						else
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: PolyPath 0 100 self
							)
						)
					)
					((>= (spirit x:) 280)
						(if global312
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: DuneMover 319 100 self
							)
						else
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: PolyPath 319 100 self
							)
						)
					)
					(global312
						(spirit
							view: 9101
							ignoreActors: 1
							setMotion: DuneMover (spirit x:) 185 self
						)
					)
					(else
						(spirit
							view: 9101
							ignoreActors: 1
							setMotion: PolyPath (spirit x:) 185 self
						)
					)
				)
			)
			(5
				(cond
					((<= (spirit x:) 40)
						(spirit setMotion: MoveTo -10 100 self)
					)
					((>= (spirit x:) 280)
						(spirit setMotion: MoveTo 335 100 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				((ScriptID 0 7) setReal: (ScriptID 0 7) (+ local2 5)) ; desertDeathTimer, desertDeathTimer
				(if (and (== gValOrRoz -4) local3) ; Val
					((ScriptID 0 8) setReal: (ScriptID 0 8) (+ local3 5)) ; stormDeathTimer, stormDeathTimer
				)
				(spirit dispose:)
				(gEgo normalize:)
				(if global312
					(duneManager setup: gEgo)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(= register
						(if (not (IsFlag 305))
							(gCast contains: spirit)
						)
					)
					(Load rsSOUND 1611)
					(SetFlag 305)
				)
				(switch global314
					(1
						(if
							(or
								(== (gCurRoom picture:) 1110)
								(== (gCurRoom picture:) 1115)
							)
							(spirit posn: 160 100)
						else
							(spirit posn: 160 75)
						)
						(gEgo posn: (mod (gEgo x:) 320) 130)
						(if global312
							(gEgo
								setMotion:
									DuneMover
									(mod (gEgo x:) 320)
									115
									self
							)
						else
							(gEgo
								setMotion:
									PolyPath
									(mod (gEgo x:) 320)
									115
									self
							)
						)
					)
					(3
						(spirit posn: 160 110)
						(gEgo posn: (mod (gEgo x:) 320) 40)
						(if global312
							(gEgo
								setMotion:
									DuneMover
									(mod (gEgo x:) 320)
									55
									self
							)
						else
							(gEgo
								setMotion:
									PolyPath
									(mod (gEgo x:) 320)
									55
									self
							)
						)
					)
					(2
						(spirit posn: 265 110)
						(if (< (gEgo y:) 90)
							(gEgo posn: 10 90)
						else
							(gEgo posn: 10 (gEgo y:))
						)
						(if global312
							(if (< (gEgo y:) (dune4 findRidge: (gEgo x:)))
								(gEgo
									y: (+ (dune4 findRidge: (gEgo x:)) 5)
								)
							)
							(gEgo setMotion: DuneMover 40 (gEgo y:) self)
						else
							(gEgo setMotion: PolyPath 40 (gEgo y:) self)
						)
					)
					(4
						(spirit posn: 55 110)
						(if (< (gEgo y:) 90)
							(gEgo posn: 315 90)
						else
							(gEgo posn: 315 (gEgo y:))
						)
						(if global312
							(if (< (gEgo y:) (dune4 findRidge: (gEgo x:)))
								(gEgo
									y: (+ (dune4 findRidge: (gEgo x:)) 5)
								)
							)
							(gEgo setMotion: DuneMover 280 (gEgo y:) self)
						else
							(gEgo setMotion: PolyPath 280 (gEgo y:) self)
						)
					)
				)
			)
			(1
				(if (gCast contains: spirit)
					(spirit setScript: leadOffScreen)
				)
				(if global312
					(duneManager setup:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leadOffScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(spirit xStep: 7 setSpeed: 11)
				(switch global314
					(1
						(if global312
							(spirit setMotion: DuneMover 319 100 self)
						else
							(spirit setMotion: PolyPath 319 100 self)
						)
					)
					(3
						(if global312
							(spirit setMotion: DuneMover 160 135 self)
						else
							(spirit setMotion: PolyPath 160 135 self)
						)
					)
					(2
						(if global312
							(spirit setMotion: DuneMover 319 110 self)
						else
							(spirit setMotion: PolyPath 319 110 self)
						)
					)
					(4
						(if global312
							(spirit setMotion: DuneMover 0 125 self)
						else
							(spirit setMotion: PolyPath 0 110 self)
						)
					)
				)
			)
			(1
				(gGame handsOff:)
				(if
					(and
						(== global314 3)
						(not (OneOf (gCurRoom picture:) 1110 1115))
					)
					(spirit setMotion: DuneMover 160 185 self)
				else
					(switch global314
						(2
							(spirit setMotion: MoveTo 335 (spirit y:) self)
						)
						(4
							(spirit setMotion: MoveTo -15 (spirit y:) self)
						)
						(else
							(self cue:)
						)
					)
				)
			)
			(2
				(gGame handsOn:)
				(spirit dispose:)
				(self dispose:)
			)
		)
	)
)

(instance stopSpirit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (spirit mover:)
					(spirit setScript: 0 setMotion: 0)
				)
				(if (IsFlag 331)
					(spirit setHotspot: 8 10 27 28) ; Do, Exit, Salt_Water, Fresh_Water
				else
					(spirit setHotspot: 8 10 27 28 5) ; Do, Exit, Salt_Water, Fresh_Water, Golden_Comb
				)
				(proc11_3 spirit gEgo self)
			)
			(1
				(gMessager say: 1 8 2 1 self) ; "Sir!"
			)
			(2
				(if (and (dune2 onMe: spirit) global312)
					(= local5 36)
				else
					(= local5 55)
				)
				(cond
					((< (gEgo x:) (spirit x:))
						(if global312
							(gEgo
								setMotion:
									DuneMover
									(- (spirit x:) local5)
									(spirit y:)
									self
							)
						else
							(gEgo
								setMotion:
									PolyPath
									(- (spirit x:) local5)
									(spirit y:)
									self
							)
						)
					)
					(global312
						(gEgo
							setMotion:
								DuneMover
								(+ (spirit x:) local5)
								(spirit y:)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(+ (spirit x:) local5)
								(spirit y:)
								self
						)
					)
				)
			)
			(3
				(proc11_3 gEgo spirit)
				(= local4
					(Abs
						(-
							(GetAngle
								(gEgo x:)
								(gEgo y:)
								(spirit x:)
								(spirit y:)
							)
							(spirit heading:)
						)
					)
				)
				(if (and global312 (> local4 (spirit sightAngle:)))
					(proc11_3 spirit gEgo self)
				else
					(self cue:)
				)
				(= local2 ((ScriptID 0 7) seconds:)) ; desertDeathTimer
				((ScriptID 0 7) client: 0 delete: dispose:) ; desertDeathTimer
				(if (> ((ScriptID 0 8) seconds:) 0) ; stormDeathTimer
					(= local3 ((ScriptID 0 8) seconds:)) ; stormDeathTimer
					((ScriptID 0 8) client: 0 delete: dispose:) ; stormDeathTimer
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(gMessager say: 1 8 2 2 self) ; "What do you want?"
				(SetFlag 322)
			)
			(6
				(gEgo disableHotspot:)
				(gGame handsOn:)
				(= local1 1)
				(= seconds 10)
			)
			(7
				(gEgo enableHotspot:)
				(gGame handsOff:)
				(spirit xStep: 7 setSpeed: 11)
				(cond
					((<= (spirit x:) 40)
						(if global312
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: DuneMover 0 100 self
							)
						else
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: PolyPath 0 100 self
							)
						)
					)
					((>= (spirit x:) 280)
						(if global312
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: DuneMover 319 100 self
							)
						else
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: PolyPath 319 100 self
							)
						)
					)
					(global312
						(spirit
							view: 9101
							ignoreActors: 1
							setMotion: DuneMover 160 185 self
						)
					)
					(else
						(spirit
							view: 9101
							ignoreActors: 1
							setMotion: PolyPath 160 185 self
						)
					)
				)
			)
			(8
				(cond
					((<= (spirit x:) 40)
						(spirit setMotion: MoveTo -10 100 self)
					)
					((>= (spirit x:) 280)
						(spirit setMotion: MoveTo 335 100 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(9
				((ScriptID 0 7) setReal: (ScriptID 0 7) (+ local2 5)) ; desertDeathTimer, desertDeathTimer
				(if (and (== gValOrRoz -4) local3) ; Val
					((ScriptID 0 8) setReal: (ScriptID 0 8) (+ local3 5)) ; stormDeathTimer, stormDeathTimer
				)
				(spirit dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstTalk of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(= local2 ((ScriptID 0 7) seconds:)) ; desertDeathTimer
					((ScriptID 0 7) client: 0 delete: dispose:) ; desertDeathTimer
					(if (> ((ScriptID 0 8) seconds:) 0) ; stormDeathTimer
						(= local3 ((ScriptID 0 8) seconds:)) ; stormDeathTimer
						((ScriptID 0 8) client: 0 delete: dispose:) ; stormDeathTimer
					)
					(Load rsVIEW 8281)
					(Load 140 1611) ; WAVE
					(if (spirit mover:)
						(spirit setMotion: 0)
					)
					(proc11_3 gEgo spirit self)
				)
				(1
					(proc11_3 spirit gEgo)
					(gMessager say: 1 8 1 1 self) ; "Excuse me! Sir?"
				)
				(2
					(cond
						((< (gEgo x:) (spirit x:))
							(if global312
								(gEgo
									setMotion:
										DuneMover
										(- (spirit x:) 55)
										(spirit y:)
										self
								)
							else
								(gEgo
									setMotion:
										PolyPath
										(- (spirit x:) 55)
										(spirit y:)
										self
								)
							)
						)
						(global312
							(gEgo
								setMotion:
									DuneMover
									(+ (spirit x:) 55)
									(spirit y:)
									self
							)
						)
						(else
							(gEgo
								setMotion:
									PolyPath
									(+ (spirit x:) 55)
									(spirit y:)
									self
							)
						)
					)
				)
				(3
					(= local4
						(Abs
							(-
								(GetAngle
									(gEgo x:)
									(gEgo y:)
									(spirit x:)
									(spirit y:)
								)
								(gEgo heading:)
							)
						)
					)
					(if (and global312 (> local4 (spirit sightAngle:)))
						(proc11_3 spirit gEgo)
					)
					(proc11_3 gEgo spirit self)
				)
				(4
					(gKqSound1 number: 1611 loop: 1 play:)
					(gEgo
						view: 8281
						setLoop: (if (< (gEgo x:) (spirit x:)) 0 else 1)
						setCel: 0
						setCycle: End self
					)
				)
				(5
					(gEgo setCycle: Beg self)
				)
				(6
					(gEgo normalize:)
					(if global312
						(duneManager setup: gEgo)
					)
					(gMessager sayRange: 1 8 1 2 10 self) ; "What do you want of me?"
				)
				(7
					(spirit xStep: 7 setSpeed: 11)
					(cond
						((<= (spirit x:) 40)
							(if global312
								(spirit
									view: 9101
									ignoreActors: 1
									setMotion: DuneMover 0 100 self
								)
							else
								(spirit
									view: 9101
									ignoreActors: 1
									setMotion: PolyPath 0 100 self
								)
							)
						)
						((>= (spirit x:) 280)
							(if global312
								(spirit
									view: 9101
									ignoreActors: 1
									setMotion: DuneMover 319 100 self
								)
							else
								(spirit
									view: 9101
									ignoreActors: 1
									setMotion: PolyPath 319 100 self
								)
							)
						)
						(global312
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: DuneMover (spirit x:) 185 self
							)
						)
						(else
							(spirit
								view: 9101
								ignoreActors: 1
								setMotion: PolyPath (spirit x:) 185 self
							)
						)
					)
				)
				(8
					(cond
						((<= (spirit x:) 40)
							(spirit setMotion: MoveTo -10 100 self)
						)
						((>= (spirit x:) 280)
							(spirit setMotion: MoveTo 335 100 self)
						)
						(else
							(self cue:)
						)
					)
				)
				(9
					((ScriptID 0 7) setReal: (ScriptID 0 7) (+ local2 5)) ; desertDeathTimer, desertDeathTimer
					(if (and (== gValOrRoz -4) local3) ; Val
						((ScriptID 0 8) setReal: (ScriptID 0 8) (+ local3 5)) ; stormDeathTimer, stormDeathTimer
					)
					(SetFlag 302)
					(spirit dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					((ScriptID 0 7) setReal: (ScriptID 0 7) (+ local2 5)) ; desertDeathTimer, desertDeathTimer
					(if (and (== gValOrRoz -4) local3) ; Val
						((ScriptID 0 8) setReal: (ScriptID 0 8) (+ local3 5)) ; stormDeathTimer, stormDeathTimer
					)
					(SetFlag 302)
					(spirit looper: 0 setLoop: 0 dispose:)
					(gEgo normalize:)
					(if global312
						(duneManager setup: gEgo)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getThePot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo ignoreActors: 1)
				(cond
					((< (gEgo x:) (pot x:))
						(if global312
							(gEgo
								setMotion:
									DuneMover
									(- (pot x:) 20)
									(+ (pot y:) 6)
									self
							)
						else
							(gEgo
								setMotion:
									PolyPath
									(- (pot x:) 20)
									(+ (pot y:) 6)
									self
							)
						)
					)
					(global312
						(gEgo
							setMotion:
								DuneMover
								(+ (pot x:) 20)
								(+ (pot y:) 6)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(+ (pot x:) 20)
								(+ (pot y:) 6)
								self
						)
					)
				)
			)
			(1
				(if (< (gEgo x:) (pot x:))
					(gEgo view: 8061 setLoop: 0 setCel: 0 setCycle: End self)
				else
					(gEgo view: 8061 setLoop: 1 setCel: 0 setCycle: End self)
				)
			)
			(2
				(pot dispose:)
				(gEgo get: 2 setCycle: Beg self) ; Clay_Pot
			)
			(3
				(gEgo normalize:)
				(if global312
					(duneManager setup: gEgo)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance spirit of Actor
	(properties
		noun 1
		sightAngle 20
		x 190
		y 70
		view 9101
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			ignoreActors: 1
			setLoop: -1
			setLooper: gGrooper
			setCycle: StopWalk -1
		)
		((ScriptID 7001 3) view: 39101 client: self) ; spiritTalker
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (spirit script:)
					(self setScript: 0)
				)
				(cond
					(local1
						(stopSpirit seconds: 20)
						(gMessager say: noun theVerb 3 0) ; "Please help me, sir. You see, I've lost my daughter, and--"
					)
					((IsFlag 302)
						(gCurRoom setScript: stopSpirit)
					)
					(else
						(gCurRoom setScript: firstTalk)
					)
				)
			)
			(28 ; Fresh_Water
				(if local1
					(stopSpirit dispose:)
				)
				(gCurRoom setScript: freshH2O)
			)
			(27 ; Salt_Water
				(if local1
					(stopSpirit dispose:)
				)
				(if (IsFlag 303)
					(gCurRoom setScript: secondSaltGive)
				else
					(gCurRoom setScript: saltH2O)
					(saltH2O next: getThePot)
				)
			)
			(5 ; Golden_Comb
				(if local1
					(SetFlag 331)
					(stopSpirit seconds: 30)
					(gMessager say: noun theVerb 3 0 0 1500) ; "This comb belongs to my daughter. She is a lovely girl with long, blonde hair. Have you seen her?"
					(self deleteHotVerb: 5) ; Golden_Comb
				)
			)
		)
	)
)

(instance storm of Actor
	(properties
		y 75
		view 1500
	)
)

(instance pot of View
	(properties
		x 108
		y 42
		view 1600
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: getThePot)
			)
		)
	)
)

(instance desertEast of ExitFeature
	(properties
		nsLeft 300
		nsRight 320
		nsBottom 140
		sightAngle 360
		approachX 315
		approachY 85
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(++ global313)
				(= global314 2)
				(roomManager doit:)
			)
		)
	)

	(method (handleEvent event)
		(self approachX: 315 approachY: (event y:))
		(super handleEvent: event)
	)
)

(instance desertWest of ExitFeature
	(properties
		nsRight 20
		nsBottom 140
		sightAngle 360
		approachX 5
		approachY 85
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(-- global313)
				(= global314 4)
				(roomManager doit:)
			)
		)
	)

	(method (handleEvent event)
		(self approachX: 5 approachY: (event y:))
		(super handleEvent: event)
	)
)

(instance desertNorth of ExitFeature
	(properties
		nsRight 320
		nsBottom 40
		sightAngle 360
		y 1
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(-- global312)
				(= global314 1)
				(roomManager doit:)
			)
		)
	)

	(method (handleEvent event)
		(self approachX: (event x:) approachY: 50)
		(super handleEvent: event)
	)
)

(instance desertSouth of ExitFeature
	(properties
		nsLeft 21
		nsTop 128
		nsRight 289
		nsBottom 135
		sightAngle 360
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(++ global312)
				(= global314 3)
				(roomManager doit:)
			)
		)
	)

	(method (handleEvent event)
		(self approachX: (event x:) approachY: 130)
		(super handleEvent: event)
	)
)

(instance roomManager of Code
	(properties)

	(method (doit)
		(cond
			((and (== global314 2) (== global313 1) (== global312 0))
				(gCurRoom setScript: walkOffScreen 0 1100)
			)
			((and (== global314 2) (== global313 1) (== global312 1))
				(gCurRoom setScript: walkOffScreen 0 1250)
			)
			((and (== global314 2) (== global313 2) (== global312 3))
				(gCurRoom setScript: walkOffScreen 0 1600)
			)
			((and (== global314 1) (== global313 1) (== global312 1))
				(gCurRoom setScript: walkOffScreen 0 1250)
			)
			((and (== global314 1) (== global313 2) (== global312 1))
				(gCurRoom setScript: walkOffScreen 0 1250)
			)
			((and (== global314 1) (== global313 2) (== global312 3))
				(gCurRoom setScript: walkOffScreen 0 1600)
			)
			((and (== global314 1) (== global313 3) (== global312 1))
				(gCurRoom setScript: walkOffScreen 0 1250)
			)
			((and (== global314 4) (== global313 3) (== global312 1))
				(gCurRoom setScript: walkOffScreen 0 1250)
			)
			((and (== global314 4) (== global313 3) (== global312 0))
				(gCurRoom setScript: walkOffScreen 0 1100)
			)
			((and (== global314 4) (== global313 2) (== global312 3))
				(gCurRoom setScript: walkOffScreen 0 1600)
			)
			((and (== global314 3) (== global313 2) (== global312 3))
				(gCurRoom setScript: walkOffScreen 0 1600)
			)
			(else
				(gCurRoom setScript: walkOffScreen)
			)
		)
	)
)

(instance mySound1 of Sound ; UNUSED
	(properties)
)

(instance duneManager of DuneHandler
	(properties)

	(method (addToFront)
		(if oldWalkHandler
			(oldWalkHandler addToFront: &rest)
		else
			(super addToFront: &rest)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(or
				(event claimed:)
				(oldWalkHandler handleEvent: event)
				(self checkDunes: event)
				(and
					(event y: (+ (dune4 findRidge: (event x:)) 5))
					(self checkDunes: event)
				)
			)
			(= temp0 1)
		)
		(return temp0)
	)
)

(instance dune1 of Dune
	(properties)

	(method (init)
		(super init: &rest)
		(= roomPoly
			((Polygon new:)
				type: PBarredAccess
				init: 58 110 92 110 104 120 104 124 85 126 58 118
				yourself:
			)
		)
		(= ridgeValleyPoly
			((Polygon new:)
				type: PTotalAccess
				init: 0 111 35 101 78 95 118 92 139 90 176 90 219 93 266 98 306 106 320 109 320 128 265 121 173 114 113 114 59 117 0 127
				yourself:
			)
		)
		(self
			setPri: 134 128
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 0 186 319 186 320 109 310 107 288 102 266 98 245 96 211 92 177 89 151 90 126 91 107 93 75 95 53 98 27 103 0 111
					yourself:
				)
		)
	)
)

(instance dune2 of Dune
	(properties
		duneScaleSize 97
	)

	(method (init)
		(super init: &rest)
		(= roomPoly
			((Polygon new:) type: PBarredAccess init: 188 84 202 84 202 90 188 90 yourself:)
		)
		(= ridgeValleyPoly
			((Polygon new:)
				type: PTotalAccess
				init: 0 83 63 83 77 83 115 76 163 65 220 57 245 56 278 58 320 61 320 89 176 89 133 93 91 99 0 99
				yourself:
			)
		)
		(self
			setPri: 100 95
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 0 111 34 101 72 95 110 93 133 90 167 90 212 92 280 100 320 109 320 61 282 59 247 55 200 60 160 66 76 83 0 83
					yourself:
				)
		)
	)
)

(instance dune3 of Dune
	(properties
		duneScaleSize 64
	)

	(method (init)
		(super init: &rest)
		(= roomPoly 0)
		(= ridgeValleyPoly
			((Polygon new:)
				type: PTotalAccess
				init: 0 57 21 51 44 48 75 48 116 52 158 58 198 62 286 70 320 70 320 83 190 83 123 75 59 74 25 75 0 77
				yourself:
			)
		)
		(self
			setPri: 82 79
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 0 83 66 83 87 81 128 72 161 65 191 61 153 57 112 51 76 48 44 48 19 51 0 57
					yourself:
				)
		)
	)
)

(instance dune4 of Dune
	(properties
		duneScaleSize 32
	)

	(method (init)
		(super init: &rest)
		(= roomPoly 0)
		(= ridgeValleyPoly
			((Polygon new:)
				type: PTotalAccess
				init: 0 25 34 17 71 11 104 9 128 9 153 12 194 23 246 33 302 38 320 39 320 55 269 51 205 42 157 28 122 23 77 24 37 31 0 41
				yourself:
			)
		)
		(self
			setPri: 0 -1
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 0 60 26 52 73 51 125 57 152 60 188 64 212 61 245 58 282 62 320 64 320 39 291 37 247 33 209 27 174 17 142 10 113 8 86 10 71 11 34 17 0 25
					yourself:
				)
		)
	)
)

(instance duneSetupCode of Code
	(properties)

	(method (doit param1)
		(if (param1 isKindOf: Actor)
			(gWalkHandler setup: param1)
		)
	)
)

