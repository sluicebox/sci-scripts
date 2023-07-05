;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use minoTrigger)
(use KQ6Room)
(use n913)
(use Conversation)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	local0
	local1
	local2
	local3
)

(instance myConv of Conversation ; UNUSED
	(properties)
)

(instance rm440 of KQ6Room
	(properties
		picture 440
		style 10
		walkOffEdge 1
		autoLoad 0
	)

	(method (cue)
		(if (and (not (IsFlag 1)) (not ((ScriptID 30 0) seenByMino:))) ; rLab
			(proc441_0)
		)
	)

	(method (init)
		(if (IsFlag 1)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 178 157 208 157 241 151 239 157 319 157 319 0 0 0 0 181 43 181 86 151 75 151 83 148 125 145 128 151 168 147
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 185 296 185 265 173 248 163 319 163 319 186 0 189
						yourself:
					)
			)
		else
			(Load rsSCRIPT 441)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 295 0 40 179 0 179 0 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 185 152 185 151 189 0 189
						yourself:
					)
			)
		)
		(super init: &rest)
		((ScriptID 30 0) cue:) ; rLab
		(flames setCycle: RandCycle init:)
		(gFeatures
			add: alter toLabExit exitSkull alterSkulls toCliffsExit
			eachElementDo: #init
		)
		(if (IsFlag 1)
			(= local0 7)
		else
			(proc441_1)
			(= local2 8)
			(= local0 6)
		)
		(gEgo init: reset: actions: egoDoMinotaurCode)
		(self setScript: walkIn)
	)

	(method (dispose)
		(actTimer dispose:)
		(DisposeScript 441)
		(super dispose:)
	)

	(method (doit)
		(cond
			((self script:))
			(
				(and
					(not ((ScriptID 30 0) seenByMino:)) ; rLab
					(not (IsFlag 1))
					(== (gEgo onControl: 1) 4)
				)
				(proc441_2)
			)
			((== (gEgo onControl: 1) 256)
				(self setScript: fallInPit)
			)
			((== (gEgo onControl: 1) 16384)
				(gCurRoom setScript: walkOut 0 0)
			)
			((== (gEgo onControl: 1) 8192)
				(if (IsFlag 1)
					(gCurRoom setScript: walkOut 0 1)
				else
					(gEgo setMotion: 0 posn: (+ (gEgo x:) 2) (gEgo y:))
					(gMessager say: 11 3 8 1) ; "!!!Do not print this. Comment msg only."
				)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1 ; Look
					(gMessager say: 2 1 local0 1)
					1
				)
				(5 ; Do
					(gMessager say: 2 5 local0 1)
					1
				)
				(2 ; Talk
					(cond
						((IsFlag 1)
							(gMessager say: 2 2 7 1) ; "The minotaur's lair is now silent and empty. There is no one here to talk to."
						)
						(((ScriptID 30 0) seenByMino:) ; rLab
							(gMessager say: 2 2 9 1) ; "Crying out for help would not do any good!"
						)
						(else
							(gMessager say: 2 2 8 0 self) ; "<Ahem> Excuse me."
						)
					)
					1
				)
				(else
					(gMessager say: 2 0 local0 1 self)
					1
				)
			)
		)
	)
)

(instance alter of Feature
	(properties
		x 60
		y 110
		noun 12
		onMeCheck 4096
	)
)

(instance toLabExit of Feature
	(properties
		x 10
		y 170
		noun 11
		onMeCheck 1024
	)
)

(instance toCliffsExit of Feature
	(properties
		x 330
		y 140
		noun 9
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1 local0 1 0 440)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alterSkulls of Feature
	(properties
		x 60
		y 110
		noun 13
		onMeCheck 2048
	)
)

(instance exitSkull of Feature
	(properties
		x 330
		y 140
		noun 10
		onMeCheck 512
	)
)

(instance flames of Prop
	(properties
		x 203
		y 147
		noun 6
		view 445
		priority 1
		signal 16400
		cycleSpeed 8
		detailLevel 3
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gPrevRoomNum 340)
					(gEgo posn: 310 160 setMotion: PolyPath 230 160 self)
				else
					(gEgo posn: -5 187 setMotion: MoveTo 38 184 self)
				)
			)
			(1
				(if (IsFlag 1)
					(self cue:)
				else
					(gGlobalSound number: 440 setLoop: -1 play:)
					(gEgo setHeading: 0)
					(SetFlag 161)
					(gGlobalSound4 number: 433 setLoop: 1 play:)
					(= cycles 10)
				)
			)
			(2
				(if (not (IsFlag 1))
					(if (IsFlag 142)
						(gMessager say: 1 0 19 0 self 440) ; "The minotaur is still struggling with the Winged Ones maiden."
					else
						(gMessager say: 1 0 1 0 self 440) ; "No! I beg of you, please don't hurt me!"
					)
				else
					(self cue:)
				)
			)
			(3
				(gGame handsOn:)
				(if (not (IsFlag 1))
					((ScriptID 30 0) setScript: actTimer) ; rLab
				)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gEgo setMotion: PolyPath 315 (gEgo y:) self)
				else
					(gEgo setMotion: MoveTo -15 (gEgo y:) self)
				)
			)
			(1
				(gGame handsOn:)
				(if register
					(gCurRoom newRoom: 340)
				else
					((ScriptID 30 0) prevEdgeHit: EDGE_LEFT) ; rLab
					(gCurRoom newRoom: 409)
				)
			)
		)
	)
)

(instance fallInPit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 441
					normal: 0
					setLoop: (if (< (gEgo x:) 185) 5 else 4)
					cel: 0
					setMotion: 0
					cycleSpeed: 2
				)
				(= cycles 6)
			)
			(1
				(gMessager say: 6 3 0 1 self) ; "Alexander, apparently confused by being in the deserted minotaur's lair, missteps into the fiery pit!"
			)
			(2
				(gMessager say: 6 3 0 2 self) ; "HHHOOOOTTTTTTTT!"
			)
			(3
				(gEgo
					setPri: (if (< (gEgo x:) 185) 2 else -1)
					setCycle: End
				)
				(gGlobalSound stop:)
				(gGlobalSound4 number: 442 setLoop: 1 play: self)
			)
			(4
				(= ticks 4)
			)
			(5
				(= seconds 2)
			)
			(6
				(EgoDead 15) ; "From the frying pan into the fire...."
			)
		)
	)
)

(instance actTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(gMessager say: 1 0 18 1 self) ; "Lady Celeste, looking desperately around the room for any possible means of escape, suddenly spots Alexander."
			)
			(2
				(proc441_0)
				(self dispose:)
			)
		)
	)
)

(instance egoDoMinotaurCode of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(return 0)
			)
			(1 ; Look
				(return 0)
			)
			(2 ; Talk
				(return 0)
			)
			(17 ; shield
				(if (IsFlag 1)
					(gMessager say: 3 17 7 1) ; "There's no more danger in the minotaur's lair. The shield is not necessary."
				else
					(gMessager say: 3 17 6 1) ; "That shield won't do much good in close combat against a minotaur! Alexander will have to think of something else."
				)
				(return 1)
			)
			(72 ; scarf
				(if (== (gCurRoom script:) (ScriptID 441 3)) ; minoTrigger
					((ScriptID 30 0) scarfOnMino: 1) ; rLab
					(gEgo view: 441 normal: 0 setLoop: 0 cel: 0)
					(UnLoad 128 900)
					((ScriptID 441 4) cycleSpeed: 6 setCycle: Fwd) ; minotaur
					((ScriptID 441 3) state: 19 register: 72 cue:) ; minoTrigger
					(gGame handsOff:)
					(gGame givePoints: 3)
				)
			)
			(else
				(if (not (IsFlag 1))
					(gMessager say: 3 0 6 1) ; "There's no time to mess with that now! That minotaur is dangerous!"
					(return 1)
				else
					(gMessager say: 0 0 184 1 0 899) ; "The minotaur's lair is no place to try that! Alexander can wait until he's somewhere a bit more comfortable!"
					(return 1)
				)
			)
		)
	)
)

