;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 826)
(include sci.sh)
(use Main)
(use fileScr)
(use Print)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	callTram 0
	getOffTram 1
	turnTramLeft 2
	turnTramRight 3
)

(local
	local0
)

(instance callTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 825 1) setMotion: 0) ; tram
				(LoadMany rsVIEW 88 90)
				(gGame handsOff:)
				(Face gEgo (ScriptID 825 1) self) ; tram
			)
			(1
				(cond
					((or (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 90)
					)
					((and (== register 2) (IsFlag 270))
						(gMessager say: 1 register 2 0 self 825)
					)
					(else
						(gMessager say: 1 register 0 0 self 825)
					)
				)
			)
			(2
				(gCurRoom
					addObstacle:
						(thePoly
							type: PBarredAccess
							init:
								((ScriptID 825 1) brLeft:) ; tram
								((ScriptID 825 1) brTop:) ; tram
								((ScriptID 825 1) brRight:) ; tram
								((ScriptID 825 1) brTop:) ; tram
								((ScriptID 825 1) brRight:) ; tram
								((ScriptID 825 1) brBottom:) ; tram
								((ScriptID 825 1) brLeft:) ; tram
								((ScriptID 825 1) brBottom:) ; tram
							yourself:
						)
				)
				(= cycles 2)
			)
			(3
				(gEgo
					ignoreActors: 1
					setMotion:
						PolyPath
						((ScriptID 825 1) x:) ; tram
						(- ((ScriptID 825 1) y:) 2) ; tram
						self
				)
			)
			(4
				((gCurRoom obstacles:) delete: thePoly)
				(thePoly dispose:)
				(= cycles 2)
			)
			(5
				(= local0 ((ScriptID 825 1) cycleSpeed:)) ; tram
				(gEgo state: (& (gEgo state:) $fffd) dispose:)
				((ScriptID 825 1) ; tram
					view: 88
					cycleSpeed: 12
					loop: (if (IsFlag 36) 0 else 1)
					setCel: 0
					setCycle: End self
				)
			)
			(6
				(gGame handsOn:)
				(gTheIconBar
					disableIcon:
						(ScriptID 0 3) ; icon0
						(ScriptID 0 5) ; icon2
						(ScriptID 0 6) ; icon3
						(ScriptID 0 9) ; icon6
					enableIcon: (ScriptID 0 7) (ScriptID 0 4) ; icon4, icon1
					curIcon: (ScriptID 0 7) ; icon4
					show:
				)
				(gGame
					setCursor: ((gTheIconBar curIcon:) getCursor:)
					changeScore: 2 270
				)
				((ScriptID 825 1) ; tram
					view: 90
					loop: (if (IsFlag 36) 0 else 1)
					cycleSpeed: local0
					moveSpeed: 1
					xStep: 4
				)
				(SetFlag 35)
				(= cycles 2)
			)
			(7
				(gMessager say: 1 0 5 0 self 825) ; "Hang on!"
			)
			(8
				(gCurRoom setScript: (ScriptID gCurRoomNum 1))
			)
		)
	)
)

(instance getOffTram of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0 [temp1 2] temp3)
		(switch (= state newState)
			(0
				((ScriptID 825 1) setMotion: 0) ; tram
				(LoadMany rsVIEW 88 82)
				(gGame handsOff:)
				(if (IsFlag 70)
					(gMessager say: 1 0 4 0 self 825) ; "We have reached the end of the line. Please watch your step getting off the tram."
				else
					(gMessager say: 1 2 1 0 self 825) ; "I'd like to get off here, please."
				)
			)
			(1
				((ScriptID 825 1) ; tram
					setMotion: 0
					view: 88
					loop: (if (IsFlag 36) 0 else 1)
					setCel: 3
					moveSpeed: 4
					xStep: 3
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					x: ((ScriptID 825 1) x:) ; tram
					y: (- ((ScriptID 825 1) y:) 2) ; tram
					state: (| $0002 (gEgo state:))
					init:
					normalize: 900
				)
				((ScriptID 825 1) view: 82) ; tram
				(ClearFlag 35)
				(= temp0 -1)
				(= temp3 ((ScriptID 825 0) currentRoom:)) ; theTramPath
				(if (!= ((ScriptID 825 0) currentRoom:) gCurRoomNum) ; theTramPath
					(while (!= temp3 gCurRoomNum)
						(while (!= ((ScriptID 825 0) at: (++ temp0)) 32767) ; theTramPath
						)
						(= temp3 ((ScriptID 825 0) at: (++ temp0))) ; theTramPath
					)
					((ScriptID 825 0) currentRoom: gCurRoomNum value: (++ temp0)) ; theTramPath
					(if (!= gCurRoomNum 820)
						((ScriptID 825 0) y: 128) ; theTramPath
					)
					(if (IsFlag 36)
						((ScriptID 825 0) next:) ; theTramPath
					)
				)
				(if (not (IsFlag 70))
					((ScriptID 825 1) ; tram
						view: 82
						setCycle: Walk
						setMotion: (ScriptID 825 0) ; theTramPath
					)
					(gTheIconBar
						enableIcon:
							(ScriptID 0 3) ; icon0
							(ScriptID 0 5) ; icon2
							(ScriptID 0 6) ; icon3
							(ScriptID 0 9) ; icon6
						show:
					)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance turnTramLeft of Script
	(properties)

	(method (doit)
		(cond
			((not (== state 4)))
			((gEgo inRect: 45 104 225 150))
			(else
				(self cue:)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 825 1) setMotion: 0) ; tram
				((ScriptID 825 2) stop:) ; tramSoundFx
				(= cycles 2)
			)
			(1
				((ScriptID 825 1) setMotion: MoveTo 90 126 self) ; tram
			)
			(2
				(gGame handsOff:)
				(ClearFlag 70)
				((ScriptID 825 1) view: 83 loop: 0 setCel: 6 setCycle: Beg self) ; tram
			)
			(3
				(cond
					((or (gGame script:) (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 90)
					)
					((gEgo inRect: 45 104 225 150)
						(gMessager say: 1 0 3 0 self 825) ; "Please step out of the way. I need to turn my tram around."
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(if (not (self script:))
					(self setScript: moveItScript)
				)
				(gGame handsOn:)
				(gEgo normalize: 900 2)
			)
			(5
				(self setScript: 0)
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(6
				((ScriptID 825 1) view: 80 loop: 0 setPri: -1 ignoreActors: 1) ; tram
				(curt
					init:
					show:
					setPri: 125
					setCycle: Walk
					setMotion: MoveTo 143 125 self
				)
			)
			(7
				(curt setPri: -1 hide:)
				((ScriptID 825 1) loop: 2 posn: 119 133 setCel: 0) ; tram
				(= cycles 2)
			)
			(8
				((ScriptID 825 1) cycleSpeed: 8 setCycle: End self) ; tram
			)
			(9
				(curt
					show:
					posn: 123 126
					loop: 2
					setCel: 1
					setCycle: Walk
					setMotion: MoveTo 148 126 self
				)
				((ScriptID 825 1) view: 80 loop: 1 cycleSpeed: 6 posn: 148 127) ; tram
			)
			(10
				(curt dispose:)
				((ScriptID 825 1) ; tram
					view: 83
					loop: 1
					setCel: 0
					setPri: -1
					setCycle: End self
				)
			)
			(11
				(SetFlag 36)
				((ScriptID 825 0) next:) ; theTramPath
				((ScriptID 825 1) ; tram
					view: 90
					setCycle: Walk
					setMotion: (ScriptID 825 0) ; theTramPath
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnTramRight of Script
	(properties)

	(method (doit)
		(cond
			((not (== state 4)))
			((gEgo inRect: 15 60 175 90))
			(else
				(self cue:)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 825 1) setMotion: 0) ; tram
				((ScriptID 825 2) stop:) ; tramSoundFx
				(= cycles 2)
			)
			(1
				((ScriptID 825 1) setMotion: MoveTo 133 85 self) ; tram
			)
			(2
				(ClearFlag 70)
				(gGame handsOff:)
				((ScriptID 825 1) view: 83 loop: 1 setCel: 6 setCycle: Beg self) ; tram
			)
			(3
				(cond
					((or (gGame script:) (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 90)
					)
					((gEgo inRect: 15 60 175 90)
						(gMessager say: 1 0 3 0 self 825) ; "Please step out of the way. I need to turn my tram around."
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(if (not (self script:))
					(self setScript: moveItScript)
				)
				(gGame handsOn:)
				(gEgo normalize: 900 2)
			)
			(5
				(self setScript: 0)
				(gGame handsOff:)
				(if (not (gCurRoom script:))
					(gEgo setHeading: 270 self)
				else
					(self cue:)
				)
			)
			(6
				((ScriptID 825 1) view: 80 loop: 1 ignoreActors: 1) ; tram
				(curt
					init:
					show:
					setPri: 80
					posn: 133 84
					setCycle: Walk
					setMotion: MoveTo 82 84 self
				)
			)
			(7
				(curt hide:)
				((ScriptID 825 1) loop: 2 setCel: 4 posn: 104 91) ; tram
				(= cycles 2)
			)
			(8
				((ScriptID 825 1) cycleSpeed: 12 setCycle: Beg self) ; tram
			)
			(9
				((ScriptID 825 1) view: 80 loop: 0 cycleSpeed: 6 posn: 75 85) ; tram
				(cond
					((IsFlag 71)
						(curt dispose:)
						((ScriptID 820 3) ; curtis
							init:
							approachX: 152
							approachY: 79
							approachVerbs: 42 43 ; match, match [ lit ]
							setLoop: 2
							setCel: 1
							show:
						)
						(gGame handsOn:)
						(self dispose:)
					)
					((and (not (IsFlag 160)) (IsFlag 205))
						(ClearFlag 36)
						((ScriptID 825 0) ; theTramPath
							currentRoom: 820
							value: 58
							endType: -1
							next:
						)
						((ScriptID 820 3) ; curtis
							init:
							approachX: 152
							approachY: 79
							approachVerbs: 42 43 ; match, match [ lit ]
							setLoop: 2
							setCel: 1
						)
						(curt dispose:)
						(gEgo setScript: (ScriptID 820 2)) ; takeABreak
						(self dispose:)
					)
					(else
						(curt
							show:
							posn: 128 84
							loop: 2
							setCel: 0
							setCycle: Walk
							setMotion: MoveTo 75 84 self
						)
					)
				)
			)
			(10
				(curt dispose:)
				((ScriptID 825 1) view: 83 loop: 0 setCel: 0 setCycle: End self) ; tram
			)
			(11
				(ClearFlag 36)
				((ScriptID 825 0) currentRoom: 820 value: 58 endType: -1 next:) ; theTramPath
				((ScriptID 825 1) ; tram
					view: 90
					setCycle: Walk
					setMotion: (ScriptID 825 0) ; theTramPath
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moveItScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(= state -1)
				(if
					(not
						(or (gGame script:) (gTalkers size:) (Print dialog:))
					)
					(gMessager say: 1 0 3 0 self 825) ; "Please step out of the way. I need to turn my tram around."
				else
					(self cue:)
				)
			)
		)
	)
)

(instance curt of Actor
	(properties
		x 90
		y 126
		view 81
	)
)

(instance thePoly of Polygon
	(properties)
)

