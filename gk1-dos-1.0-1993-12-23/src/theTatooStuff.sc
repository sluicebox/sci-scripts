;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use n013)
(use GKTeller)
(use PolyPath)
(use StopWalk)
(use Cursor)
(use Grooper)
(use Motion)
(use System)

(public
	theTatooStuff 0
	tellAboutGermany 1
	afterTheBody 2
	egoClimbLadder 3
)

(local
	local0
)

(instance theTatooStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 361)
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 187 125 self)
			)
			(1
				(Face gEgo (ScriptID 210 1) self) ; graceProp
			)
			(2
				(= cycles 2)
			)
			(3
				((ScriptID 210 4) dispose:) ; graceDoStuff
				((ScriptID 210 1) ; graceProp
					view: 2111
					setCel: 8
					setLoop: 0
					cycleSpeed: 8
					setCycle: CT 5 -1 self
				)
			)
			(4
				(graceTeller init: (ScriptID 210 1)) ; graceProp
				(if (IsFlag 54)
					(gMessager say: 1 30 12 0 self) ; "Come on, Grace. I really need that tattoo."
				else
					(SetFlag 54)
					(gMessager say: 1 30 11 0 self) ; "Will you do me a favor?"
				)
			)
			(5
				(graceTeller doVerb: 11)
			)
			(6
				(if (IsFlag 335)
					(self cue:)
				else
					(gMessager sayRange: 7 53 28 1 9 self) ; "(INSINUATING)Well, if you're jealous about my feelings for her...."
				)
			)
			(7
				(if (IsFlag 335)
					(graceTeller dispose:)
					((ScriptID 210 1) actions: 0) ; graceProp
					(= cycles 2)
				else
					(Load rsVIEW 223)
					((ScriptID 210 1) ; graceProp
						view: 208
						setCel: 7
						setLoop: 4
						setCycle: Beg self
					)
				)
			)
			(8
				(if (IsFlag 335)
					(gGame handsOn:)
					(gEgo normalize: 0 901 ignoreActors: 1)
					(self dispose:)
				else
					((ScriptID 210 1) actions: 0) ; graceProp
					((ScriptID 210 1) dispose:) ; graceProp
					((ScriptID 210 6) ; graceActor
						view: 223
						init:
						posn: 242 121
						setLooper: Grooper
						setCycle: StopWalk -1
						setMotion: PolyPath 271 104 self
					)
				)
			)
			(9
				((ScriptID 210 6) ; graceActor
					view: 225
					setCel: 0
					setLoop: 0
					setCycle: CT 2 1 self
				)
			)
			(10
				((ScriptID 210 20) dispose:) ; artSupplies
				((ScriptID 210 6) ; graceActor
					view: 225
					setCel: 3
					setLoop: 0
					setCycle: End self
				)
			)
			(11
				((ScriptID 210 6) ; graceActor
					view: 223
					setCycle: StopWalk -1
					setMotion: PolyPath 292 104 self
				)
			)
			(12
				((ScriptID 210 6) ; graceActor
					view: 220
					setCel: 0
					setLoop: 1
					posn: 289 108
					setCycle: End self
				)
				(gGkSound1 number: 215 setLoop: 1 play:)
			)
			(13
				(gMessager say: 7 53 28 10 self) ; "What'd I say?"
				((ScriptID 210 6) dispose:) ; graceActor
			)
			(14
				(gEgo
					getPoints: -999 3
					ignoreActors: 1
					setMotion: PolyPath 289 102 self
				)
			)
			(15
				(gEgo
					view: 220
					setCel: 0
					setLoop: 0
					posn: 289 108
					setCycle: End self
				)
				(gGkSound1 number: 215 setLoop: 1 play: self)
			)
			(16)
			(17
				(SetFlag 303)
				(self dispose:)
			)
		)
	)
)

(instance tellAboutGermany of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: StopWalk -1 setMotion: PolyPath 187 125 self)
			)
			(1
				((ScriptID 210 4) dispose:) ; graceDoStuff
				(Face gEgo (ScriptID 210 1) self) ; graceProp
			)
			(2
				(gMessager say: 11 0 61 0 self) ; "Guess what. I'm going to Germany."
			)
			(3
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(SetFlag 262)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance afterTheBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 311)
				((ScriptID 210 1) init: setCel: 4 setLoop: 2 setCycle: End self) ; graceProp
			)
			(1
				(gMessager say: 11 0 59 1 self) ; "(WORRIED)Where have you been? I was worried about you!"
			)
			(2
				(gEgo
					ignoreActors: 1
					setCycle: StopWalk -1
					setMotion: PolyPath 187 125 self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager sayRange: 11 0 59 2 11 self) ; "(SLIGHTLY IN PAIN)For good reason, apparently."
			)
			(5
				(SetFlag 356)
				(ClearFlag 311)
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(gEgo normalize: 0 901 ignoreActors:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoClimbLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gEgo inRect: 211 144 235 165)
					(gEgo setMotion: PolyPath 209 129 self)
				else
					(self cue:)
				)
			)
			(1
				(if (not (and (== (gEgo x:) 175) (== (gEgo y:) 98)))
					(gEgo setMotion: PolyPath 175 98 self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo
					posn: 170 98
					view: 2102
					setCel: 0
					setLoop: 0 1
					setCycle: End self
				)
				((ScriptID 210 4) dispose:) ; graceDoStuff
			)
			(3
				((ScriptID 210 1) ; graceProp
					view: 2111
					setCel: 8
					setLoop: 0
					cycleSpeed: 8
					setCycle: CT 5 -1 self
				)
			)
			(4
				(gMessager sayRange: 31 8 8 1 3 self 211) ; "(SPEAKING OF HIM CLIMBING A LADDER IN THE SHOP)If you try to look down my shirt one more time, I'm leaving."
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo posn: 175 98 normalize: 3 901 ignoreActors: 1)
				(= cycles 1)
			)
			(7
				(Face gEgo (ScriptID 210 1) self) ; graceProp
			)
			(8
				(gMessager say: 31 8 8 4 self 211) ; "!!!Blank msg"
			)
			(9
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(= cycles 2)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 213)
			)
		)
	)
)

(instance graceTeller of GKTeller
	(properties
		curNoun 8
		sayNoun 7
		verb 53
	)

	(method (showCases)
		(super
			showCases:
				26 ; It would be a good way for us to get...closer.
				(not (IsFlag 371))
				29 ; I'm going to a party tonight. Costume, you know.
				(not (IsFlag 372))
				71 ; Oh, come on! I need it for that costume party!
				(IsFlag 372)
				31 ; I can't tell you, Grace. It's a secret research thing.
				(and (not (IsFlag 373)) (IsFlag 371))
				32 ; It's a 'good luck' snake. It wards off evil.
				(not (IsFlag 374))
				25 ; I'm sure Malia would appreciate it.
				(and (not (IsFlag 376)) (IsFlag 375))
				30 ; All the world loves lovers, don't they?
				(not (IsFlag 375))
				27 ; I know you feel inferior to Malia but, you know, get over it.
				(not (IsFlag 377))
		)
	)

	(method (cue)
		(cond
			((== iconValue 26) ; It would be a good way for us to get...closer.
				(SetFlag 371)
				(SetFlag 335)
				(theTatooStuff cue:)
			)
			((== iconValue 29) ; I'm going to a party tonight. Costume, you know.
				(SetFlag 372)
				(self doVerb: 11)
			)
			((== iconValue 31) ; I can't tell you, Grace. It's a secret research thing.
				(SetFlag 373)
				(self doVerb: 11)
			)
			((== iconValue 25) ; I'm sure Malia would appreciate it.
				(SetFlag 376)
				(self doVerb: 11)
			)
			((== iconValue 30) ; All the world loves lovers, don't they?
				(SetFlag 375)
				(self doVerb: 11)
			)
			((== iconValue 27) ; I know you feel inferior to Malia but, you know, get over it.
				(SetFlag 377)
				(self doVerb: 11)
			)
			((== iconValue 32) ; It's a 'good luck' snake. It wards off evil.
				(SetFlag 374)
				(self doVerb: 11)
			)
			((== iconValue 71) ; Oh, come on! I need it for that costume party!
				(self doVerb: 11)
			)
			(else
				(SetFlag 335)
				(theTatooStuff cue:)
			)
		)
	)

	(method (sayMessage)
		(if (== iconValue 28) ; Well, if you're jealous about my feelings for her....
			(theTatooStuff cue:)
			(self dispose:)
		else
			(super sayMessage:)
		)
	)

	(method (doVerb theVerb)
		(if (== (gEgo script:) theTatooStuff)
			(SetCursor -2)
			(= local0 (gGame setCursor: myTellerCursor))
			(while 1
				(if (self respond:)
					(break)
				)
			)
			(gGame setCursor: local0)
			(SetCursor 0 0 319 155)
			(return 1)
		else
			(client doVerb: theVerb)
			(return 1)
		)
	)
)

(instance myTellerCursor of Cursor
	(properties
		view 999
	)
)

