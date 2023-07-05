;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use rgCastle)
(use Print)
(use Conversation)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	rm820 0
	noWayOut 1
	roomConv 2
	dungeonDoor 3
	flame 4
	wallReflection 5
)

(local
	local0
	local1
)

(instance rm820 of CastleRoom
	(properties
		noun 3
		picture 820
		style 10
		horizon 0
		vanishingX 186
		vanishingY 92
		minScaleSize 89
		maxScaleSize 113
		minScaleY 130
		maxScaleY 144
	)

	(method (init)
		(LoadMany rsVIEW 825 822)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 10 166 10 174 301 174 301 161 280 147 147 147 147 132 95 132
					yourself:
				)
		)
		((ScriptID 1015 6) x: 19 y: 41) ; tlkGuardDog1
		((ScriptID 1015 7) x: 19 y: 77) ; tlkGuardDog2
		(gFeatures add: bed torch gargoyle eachElementDo: #init)
		(super init: &rest)
		(flame setCycle: Fwd init:)
		(wallReflection setCycle: RandCycle init:)
		(dungeonDoor cel: 3 setPri: 10 init: stopUpd:)
		(extraView addToPic:)
		(ant init: setScript: antScript)
		(gEgo
			init:
			reset: 0
			posn: 43 143
			setPri: 9
			setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
		)
		((gEgo scaler:) doit:)
		(if ((ScriptID 80 0) tstFlag: #rFlag1 8192) ; rgCastle
			(if (gCast contains: (ScriptID 80 5)) ; guard1
				((ScriptID 81 0) resetGuard: (ScriptID 80 5) 1) ; RgBasement, guard1
				((ScriptID 80 5) dispose:) ; guard1
			)
			(if (gCast contains: (ScriptID 80 6)) ; guard2
				((ScriptID 81 0) resetGuard: (ScriptID 80 6) 2) ; RgBasement, guard2
				((ScriptID 80 6) dispose:) ; guard2
			)
			((ScriptID 81 0) clrFlag: #rFlag1 1 2) ; RgBasement
			(self setScript: (ScriptID 821 0)) ; throwInDungeon
			(gGlobalSound fadeTo: 824 -1)
			(= local0 1)
		else
			(self setScript: enterDungeon)
			(if
				(and
					(OneOf ((ScriptID 80 0) dungeonEntered:) 1 2) ; rgCastle
					(not ((ScriptID 80 0) tstFlag: #rFlag1 32768)) ; rgCastle
				)
				(gGlobalSound fadeTo: 820 -1)
				(if (not (gEgo has: 17)) ; handkerchief
					(dungeonDoor approachX: 111)
				)
				(enterDungeon next: (ScriptID 822 0)) ; boyGhostScript
			else
				(gGlobalSound fadeTo: 824 -1)
			)
		)
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 2) ; Talk
				(OneOf ((ScriptID 80 0) dungeonEntered:) 1 2) ; rgCastle
				(not ((ScriptID 80 0) tstFlag: #rFlag1 32768)) ; rgCastle
			)
			(gMessager say: 3 2 20 1) ; "There's no one here to talk to except the ghost."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(gEgo setPri: -1)
		(super dispose: &rest)
		(DisposeScript 991)
		(DisposeScript 964)
	)
)

(instance enterDungeon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(dungeonDoor approachX:)
						(dungeonDoor approachY:)
						self
				)
			)
			(2
				(dungeonDoor setCycle: Beg self)
			)
			(3
				(gGlobalSound4 number: 822 loop: 1 play:)
				(dungeonDoor setPri: -1 stopUpd:)
				(if
					(or
						((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
						((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
					)
					(gMessager say: 1 0 7 1 self) ; "Alexander hears the guard dog leave the basement. It seems he's safe enough for the moment."
				else
					(= cycles 2)
				)
				(if (gCast contains: (ScriptID 80 5)) ; guard1
					((ScriptID 81 0) resetGuard: (ScriptID 80 5) 1) ; RgBasement, guard1
					((ScriptID 80 5) dispose:) ; guard1
				)
				(if (gCast contains: (ScriptID 80 6)) ; guard2
					((ScriptID 81 0) resetGuard: (ScriptID 80 6) 2) ; RgBasement, guard2
					((ScriptID 80 6) dispose:) ; guard2
				)
				((ScriptID 81 0) clrFlag: #rFlag1 1 2) ; RgBasement
			)
			(4
				(if (not next)
					(gGame handsOn:)
				else
					(= next 0)
					((ScriptID 822 1) init:) ; boyGhost
				)
				(gEgo reset: 0)
				(self dispose:)
			)
		)
	)
)

(instance exitDungeon of Script
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(if (and (== state 1) (& temp0 $4000))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dungeonDoor hide:)
				(gEgo
					normal: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					view: 821
					loop: 4
					cel: 0
					posn: 56 109
					setCycle: CT 2 1 self
				)
			)
			(1
				(gGlobalSound4 number: 821 loop: 1 play:)
				(dungeonDoor setPri: 10 cel: 3)
				(gEgo setCycle: End self)
			)
			(2
				(dungeonDoor show: stopUpd:)
				(gGlobalSound4 stop:)
				(gEgo
					posn: (dungeonDoor approachX:) (dungeonDoor approachY:)
					reset: 1
					setPri: 9
					setMotion: MoveTo 0 143 self
				)
			)
			(3
				(gEgo hide:)
				(dungeonDoor setCycle: Beg self)
			)
			(4
				(gGlobalSound4 number: 822 loop: 1 play: self)
				(gEgo setPri: -1)
			)
			(5
				(gCurRoom newRoom: 710)
			)
		)
	)
)

(instance antScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(+= state (* (Random 0 1) 3))
				(ant hide: setPri: 15 ignoreActors: setCycle: Walk)
				(= seconds (Random 7 25))
			)
			(1
				(ant show:)
				(if (= register (Random 0 1))
					(ant
						setLoop: 6
						posn: 220 201 0
						setMotion: MoveTo 172 167 self
					)
				else
					(ant
						setLoop: 5
						posn: 106 195 0
						setMotion: MoveTo 155 169 self
					)
				)
			)
			(2
				(= seconds (Random 1 10))
			)
			(3
				(= state -1)
				(ant setPri: 14)
				(if register
					(ant
						setLoop: 8
						posn: 164 195 28
						setMotion: MoveTo 164 213 self
					)
				else
					(ant
						setLoop: 7
						posn: 162 195 24
						setMotion: MoveTo 162 209 self
					)
				)
			)
			(4
				(ant
					show:
					setLoop: 5
					posn: 0 189 0
					setMotion: MoveTo 44 172 self
				)
			)
			(5
				(= seconds (Random 2 10))
			)
			(6
				(= state -1)
				(ant loop: 7 setMotion: MoveTo 88 197 self)
			)
		)
	)
)

(instance noWayOut of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 200])
		(switch (= state newState)
			(0
				(ant setScript: 0)
				(gGame handsOff:)
				(gGlobalSound fadeTo: 823 1)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 90 144 self)
			)
			(2
				(gEgo
					view: 821
					normal: 0
					setPri: 12
					setScale: 0
					scaleX: 128
					scaleY: 128
					posn: 93 144
					loop: 5
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3
				(gGlobalSound4 number: 825 setLoop: -1 play:)
				(gEgo loop: 6 cel: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(gGlobalSound4 stop:)
				(gEgo setCycle: 0)
				(= cycles 3)
			)
			(5
				(gMessager say: 1 0 2 1 self) ; "Just as Alexander realizes that he has no possible means of escape, he hears the sound of wedding music playing somewhere in the castle."
			)
			(6
				(gMessager say: 1 0 2 2 self) ; "Confound this dungeon! I'll never be able to stop the wedding now!"
			)
			(7
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 98 10)
				(Message msgNEXT @temp1)
				(Display @temp1 dsCOORD 30 11 dsWIDTH 260 dsCOLOR 16 dsFONT gUserFont dsALIGN alCENTER)
				(Display @temp1 dsCOORD 29 10 dsWIDTH 260 dsCOLOR 47 dsFONT gUserFont dsALIGN alCENTER)
				(gEgo
					view: 8901
					loop: 0
					cel: 0
					normal: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					posn: 160 43
					setMotion: 0
					show:
				)
				(gGlobalSound number: 970 loop: 1 play:)
				(= cycles 2)
			)
			(8
				(gGame setCursor: gNormalCursor)
				(repeat
					(switch
						(= temp0
							(Print
								window: DeathWindow
								addText: {Please select:} 60 0
								posn: 70 130
								addButton: 1 {Restore} 0 15
								addButton: 2 {Restart} 70 15
								addButton: 3 {Quit} 140 15
								init:
							)
						)
						(1
							(gGame restore:)
						)
						(2
							(gGame restart: 1)
						)
						(3
							(= gQuit 1)
							(break)
						)
					)
				)
			)
		)
	)
)

(instance doorLocked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 90 144 self)
			)
			(1
				(gEgo
					view: 821
					normal: 0
					setPri: 12
					setScale: 0
					scaleX: 128
					scaleY: 128
					posn: 93 144
					loop: 5
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 6 cel: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(3
				(gEgo setCycle: 0)
				(= cycles 3)
			)
			(4
				(gMessager say: 5 5 15 0 self) ; "The dungeon door is locked."
			)
			(5
				(gEgo loop: 5 cel: 2 cycleSpeed: 8 setCycle: Beg self)
			)
			(6
				(gEgo reset: 1 posn: 90 144)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance unlockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dungeonDoor hide:)
				(gEgo
					normal: 0
					setScale: 0
					view: 823
					loop: 0
					cel: 0
					cycleSpeed: 8
					posn: 56 109
					setCycle: CT 5 1 self
				)
			)
			(1
				(= cycles 50)
			)
			(2
				(gEgo cel: 6)
				(gGlobalSound3 number: 781 loop: 1 play: self)
			)
			(3
				(gMessager say: 5 35 15 0 self) ; "Alexander unlocks the door with his skeleton key."
			)
			(4
				(gEgo loop: 1 cel: 0 setCycle: End self)
				(gGlobalSound3 number: 821 loop: 1 play:)
			)
			(5
				((ScriptID 80 0) setFlag: #rFlag1 4096) ; rgCastle
				(gCurRoom newRoom: 710)
			)
		)
	)
)

(instance lookOutDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 90 144 self)
			)
			(1
				(gEgo
					view: 821
					normal: 0
					setPri: 12
					setScale: 0
					scaleX: 128
					scaleY: 128
					posn: 93 144
					loop: 5
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gMessager say: 7 1 0 0 self) ; "Alexander looks out the small window. The hallway is empty."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(gEgo reset: 1 posn: 90 144)
				(self dispose:)
			)
		)
	)
)

(instance extraView of View
	(properties
		onMeCheck 0
		view 821
		loop 3
		signal 16400
	)

	(method (init)
		(switch ((ScriptID 80 0) dungeonEntered:) ; rgCastle
			(3
				(self cel: 1 x: 211 y: 125 noun: 8)
			)
			(else
				(self cel: 0 x: 159 y: 108 noun: 9 onMeCheck: 26505)
			)
		)
		(super init: &rest)
	)
)

(instance flame of Prop
	(properties
		x 116
		y 76
		noun 11
		view 821
	)

	(method (doVerb theVerb)
		(torch doVerb: theVerb)
	)
)

(instance wallReflection of Prop
	(properties
		x 115
		y 72
		onMeCheck 0
		view 821
		loop 1
		signal 16400
		cycleSpeed 12
	)
)

(instance dungeonDoor of Prop
	(properties
		x 56
		y 109
		noun 5
		sightAngle 45
		approachX 91
		approachY 145
		approachDist 2
		view 821
		loop 2
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 35 2) ; Do, skeletonKey, Talk
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
				(== (gTheIconBar curInvIcon:) (gInventory at: 44)) ; skeletonKey
			)
			(= approachX 82)
			(= approachY 144)
		else
			(= approachX 91)
			(= approachY 145)
		)
		(-= temp0 nsLeft)
		(-= temp1 nsTop)
		(if (and (<= 5 temp0 15) (<= 11 temp1 24))
			(= noun 7)
		else
			(= noun 5)
		)
		(return (super onMe: param1))
	)

	(method (doVerb theVerb)
		(if (== noun 5)
			(switch theVerb
				(35 ; skeletonKey
					(cond
						((not local0)
							(gMessager say: noun theVerb 14) ; "The door is not locked."
						)
						(((ScriptID 80 0) tstFlag: #rFlag1 8192) ; rgCastle
							((ScriptID 80 0) setFlag: #rFlag1 4096) ; rgCastle
							(= local0 0)
							(gCurRoom setScript: unlockDoor)
						)
					)
				)
				(5 ; Do
					(if (not local0)
						(gCurRoom setScript: exitDungeon)
					else
						(gCurRoom setScript: doorLocked)
					)
				)
				(2 ; Talk
					(gMessager
						say:
							noun
							theVerb
							(+ 14 ((ScriptID 80 0) tstFlag: #rFlag1 8192)) ; rgCastle
					)
				)
				(else
					(if (== (gKq6ApproachCode doit: theVerb) -32768)
						(gMessager
							say:
								noun
								0
								(+ 14 ((ScriptID 80 0) tstFlag: #rFlag1 8192)) ; rgCastle
						)
					else
						(super doVerb: theVerb)
					)
				)
			)
		else
			(switch theVerb
				(2 ; Talk
					(if local0
						(gMessager say: noun theVerb 15) ; "Hello! Is anyone there? Could someone let me out?"
					else
						(gMessager say: noun theVerb 14) ; "The door does not reply."
					)
				)
				(1 ; Look
					(gCurRoom setScript: lookOutDoor)
				)
				(else
					(= noun 5)
					(self doVerb: theVerb)
				)
			)
		)
	)
)

(instance ant of Actor
	(properties
		x 149
		y 185
		noun 13
		view 820
		loop 8
	)
)

(instance bed of Feature
	(properties
		noun 8
		onMeCheck 2
	)
)

(instance torch of Feature
	(properties
		noun 11
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMessager say: noun theVerb (+ 14 local0))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gargoyle of Feature
	(properties
		x 56
		y 144
		noun 12
		onMeCheck 8
	)
)

(instance roomConv of Conversation
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(= caller 0)
	)
)

(instance DeathWindow of SysWindow
	(properties)

	(method (open)
		(= color 47)
		(= back 0)
		(super open: &rest)
	)
)

