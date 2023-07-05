;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2460)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use ROsc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm2460 0
	male1Talker 1
	male2Talker 2
	fem1Talker 3
	fem2Talker 4
)

(instance rm2460 of KQRoom
	(properties
		picture 2460
	)

	(method (init)
		(Load rsMESSAGE 2450)
		(super init:)
		((ScriptID 7001 1) client: malicia clientCel: -1) ; maliciaTalker
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 110 63 118 73 33 96 45 101 66 92 102 85 202 85 253 86 296 93 319 89 319 73 292 72 250 65 200 65 162 63 152 52 85 52
					yourself:
				)
		)
		(gEgo setScale: 0 setScaler: Scaler 100 48 102 36 init: normalize: 4)
		(exitFeat init:)
		(if (not (IsFlag 377))
			(bath init:)
		)
		(troll1 init:)
		(troll2 init:)
		(bubbles init:)
		(Load rsSOUND 24600)
		(gKqSound1 number: 24600 setLoop: -1 play:)
		(cond
			((and (IsFlag 86) (not (IsFlag 55)) (not (IsFlag 352)))
				(SetFlag 352)
				(ClearFlag 86)
				(self setScript: malToon)
			)
			((and (IsFlag 87) (not (IsFlag 55)) (not (IsFlag 355)))
				(SetFlag 355)
				(enterRoom next: sulfurToon)
				(self setScript: enterRoom)
			)
			(else
				(self setScript: enterRoom)
			)
		)
	)

	(method (dispose)
		(if (IsFlag 353)
			(SetFlag 381)
		)
		(gKqSound1 stop:)
		(super dispose: &rest)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 127 62 setMotion: MoveTo 147 74 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sinkAndBeReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(troll2
					view: 2462
					loop: 2
					cel: 0
					posn: 237 107
					setCycle: End self
				)
				(troll1 view: 2462 loop: 0 cel: 0 posn: 96 105)
				(male2Talker clientCel: -1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance malToon of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load rsVIEW 2462)
					(Load rsSOUND 812)
					(gEgo
						normalize: 5
						posn: 94 40
						setMotion: MoveTo 73 70 self
					)
					(malicia init: cel: (malicia lastCel:))
				)
				(1
					(gEgo setHeading: 90 self)
				)
				(2
					(gEgo setLoop: 0 1)
					(troll2 setLoop: 3 cel: 0 posn: 241 109 setCycle: End self)
				)
				(3
					(troll2
						setLoop: 4
						cel: 0
						posn: 233 111
						setCycle: CT 3 1 self
					)
				)
				(4
					(gKqSound1 number: 2474 loop: 1 play: self)
					(troll2 setCycle: CT 10 1 self)
				)
				(5 0)
				(6
					(troll2 setCycle: End self)
				)
				(7
					(troll2
						view: 2462
						loop: 1
						cel: 0
						posn: 231 109
						setCycle: End self
					)
				)
				(8
					(troll1 view: 2462 loop: 0 cel: 0 posn: 96 105)
					(malicia
						setLoop: 5
						cel: 0
						posn: 207 91
						setCycle: CT 3 1 self
					)
				)
				(9
					(malicia cel: 4)
					(dog init: setPri: 100)
					(= cycles 1)
				)
				(10
					(gMessager say: 0 0 13 1 self 2450) ; "(DISGUSTED)Revolting beast!"
				)
				(11
					(dog setCycle: Fwd)
					(gMessager say: 0 0 13 2 self 2450) ; "Barf! Barf!"
				)
				(12
					(dog dispose:)
					(malicia
						view: 2462
						setLoop: 7 1
						cel: 0
						posn: 165 80
						setPri: 50
						setCycle: End self
					)
				)
				(13
					(malicia
						setLoop: 9 1
						cel: 0
						posn: 195 86
						setCycle: Fwd
						cycleSpeed: 14
						setMotion: MoveTo 9 45 self
					)
				)
				(14
					(malicia dispose:)
					(gMessager say: 0 0 13 3 self 2450) ; "(TEASING)Geez, Hogarth, ya nearly got yaself fried!"
				)
				(15
					(troll2 loop: 2 cel: 0 posn: 237 107 setCycle: End self)
				)
				(16
					(gMessager say: 0 0 13 4 self 2450) ; "(HUFFY)Aw, I'm not scared a dat nasty wench. I could break her in half like a carrot."
				)
				(17
					(troll1
						view: 2462
						loop: 3
						cel: 0
						posn: 99 106
						setCycle: End self
					)
				)
				(18
					(male2Talker clientCel: -2)
					(troll1 cel: (- (troll1 cel:) 2))
					(gMessager say: 0 0 13 5 self 2450) ; "(MISCHIEVOUSLY)Well dat's good, cause she's right behind you."
				)
				(19
					(troll2
						view: 2462
						loop: 4
						cel: 0
						posn: 219 108
						setCycle: CT 8 1 self
					)
				)
				(20
					(troll2 setCycle: End self)
					(gKqSound1 number: 812 setLoop: 1 play:)
				)
				(21
					(troll1
						view: 2462
						loop: 6
						cel: 0
						posn: 100 107
						setCycle: End self
					)
					(troll2 loop: 5 cel: 0 posn: 217 113 setCycle: End)
				)
				(22
					(gMessager say: 0 0 13 6 self 2450) ; "Haw haw haw haw!"
					(troll1 setCycle: ROsc 100 14 16)
				)
				(23
					(troll1
						view: 2462
						loop: 3
						cel: 5
						posn: 99 106
						setCycle: Beg self
					)
				)
				(24
					(gMessager say: 0 0 13 7 self 2450) ; "(WOUNDED)Dat was not funny, Blotar."
					(troll1 view: 2462 loop: 0 cel: 0 posn: 96 105)
					(male2Talker clientCel: -1)
				)
				(25
					(troll2
						view: 2462
						loop: 1
						cel: 7
						posn: 231 109
						setCycle: Beg self
					)
				)
				(26
					(troll2 view: 2462 loop: 2 cel: 8 posn: 237 107)
					(gEgo
						normalize: 0
						setPri: 50
						setMotion: MoveTo 160 77 self
					)
				)
				(27
					(gEgo setPri: -1 setHeading: 180 self)
				)
				(28
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(ClearFlag 539)
			(gEgo posn: 160 77 normalize: 2)
			(malicia dispose:)
			(dog dispose:)
			(troll2 view: 2462 loop: 2 cel: 8 posn: 237 107)
			(troll1 view: 2462 loop: 0 cel: 0 posn: 96 105)
			(male2Talker clientCel: -1)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sulfurToon of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(ClearFlag 539)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(SetFlag 355)
					(gGame handsOff: 1)
					(gMessager say: 0 0 17 0 self 2450) ; "(CHATTY)...You know, Winnie, I've had so much trouble sleeping lately. Blotar snores like a dragon with heartburn."
				)
				(1
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance femFirst of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(troll1 setCycle: 0 setLoop: 2 cel: 0)
			(ClearFlag 539)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gMessager sayRange: 6 8 12 1 3 self 2450) ; "Excuse me, good ladies, but would you happen to know anything about Malicia?"
				)
				(1
					(troll1 setLoop: 2 cel: 0 setCycle: End self)
				)
				(2
					(troll1 setLoop: 4 cel: 0 setCycle: Fwd)
					(gMessager say: 6 8 12 4 self 2450) ; "Boo hoo hoo hoo!"
				)
				(3
					(troll1
						setLoop: 2
						cel: (troll1 lastCel:)
						setCycle: Beg self
					)
				)
				(4
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance femPost of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(troll1 setCycle: 0 setLoop: 2 cel: 0)
			(troll2 setCycle: 0 setLoop: 3 cel: 0)
			(ClearFlag 539)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(fem1Talker hide_mouth: 1)
					(fem2Talker hide_mouth: 1)
					(gMessager say: 6 8 16 1 self 2450) ; "(CAUTIOUSLY)Excuse me. Ladies?"
				)
				(1
					(troll1 setLoop: 2 cel: 0 setCycle: End self)
				)
				(2
					(troll1 setLoop: 4 cel: 0 setCycle: Fwd)
					(gMessager say: 6 8 16 2 self 2450) ; "(OVERCOME WITH EMOTION)Ooooooh! Weddings ALWAYS make me cry! Boo hoo hoo hoo!"
				)
				(3
					(troll1
						setLoop: 2
						cel: (troll1 lastCel:)
						setCycle: Beg self
					)
				)
				(4
					(troll2 setLoop: 3 cel: 0 setCycle: End self)
				)
				(5
					(troll2 setLoop: 5 cel: 0 setCycle: Fwd)
					(gMessager say: 6 8 16 3 self 2450) ; "(OVERCOME WITH EMOTION)Aaaaaw! Boo hoo hoo hoo!"
				)
				(6
					(troll2
						setLoop: 3
						cel: (troll2 lastCel:)
						setCycle: Beg self
					)
				)
				(7
					(gMessager say: 6 8 16 4 self 2450) ; "Oh, never mind!"
				)
				(8
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance maleTrollSleeping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(male1Talker hide_mouth: 1)
				(male2Talker hide_mouth: 1)
				(if (IsFlag 55)
					(gMessager say: register 8 18 1 self 2450)
				else
					(gMessager say: register 8 14 1 self 2450)
				)
			)
			(1
				(if (== register 4)
					(troll1 setCycle: Fwd)
				else
					(troll2 setCycle: Fwd)
				)
				(if (IsFlag 55)
					(gMessager say: register 8 18 2 self 2450)
				else
					(gMessager say: register 8 14 2 self 2450)
				)
			)
			(2
				(if (== register 4)
					(troll1 setCycle: Beg)
				else
					(troll2 setCycle: Beg)
				)
				(male1Talker hide_mouth: 0)
				(male2Talker hide_mouth: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance postMalTalk of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(troll2
				view: 2462
				loop: 1
				cel: (troll2 lastCel:)
				posn: 231 109
				setCycle: 0
			)
			(ClearFlag 539)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gMessager say: 5 8 15 0 self 2450) ; "Pardon me, sirs, but who was that tall, imposing woman?"
				)
				(1
					(troll2
						view: 2462
						loop: 1
						cel: 0
						posn: 231 109
						setCycle: End self
					)
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance bubbles of Prop
	(properties
		x 90
		y 94
		view 2464
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)

	(method (onMe)
		(return 0)
	)
)

(instance malicia of Actor
	(properties
		x 281
		y 91
		view 2461
		loop 2
	)
)

(instance dog of Prop
	(properties
		x 195
		y 53
		view 2461
		loop 6
	)
)

(instance exitFeat of ExitFeature
	(properties
		approachX 110
		approachY 52
	)

	(method (init)
		(super init: &rest)
		(self
			exitDir: 5
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 57 0 232 0 219 29 198 43 167 58 97 62 93 57 83 52
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom newRoom: 2450)
	)
)

(instance bath of Feature
	(properties
		sightAngle 5
		x 165
		y 200
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 95 115 150 124 214 118 221 87 148 87
					yourself:
				)
		)
	)

	(method (doVerb)
		(SetFlag 377)
		(gMessager say: 2 8 12 0 0 2450) ; "(THINKS TO HERSELF)Yech! Troll soup!"
		(self dispose:)
	)
)

(class MudTroll of Prop
	(properties
		male 0
	)

	(method (init)
		(super init: &rest)
		(= male (or (not (IsFlag 87)) (IsFlag 55)))
		(|= signal $1000)
	)

	(method (doVerb theVerb)
		(if male
			(self maleDoVerb: theVerb)
		else
			(self femaleDoVerb: theVerb)
		)
		(return 1)
	)

	(method (maleDoVerb)
		(cond
			((or (IsFlag 381) (IsFlag 55))
				(gCurRoom setScript: maleTrollSleeping 0 noun)
			)
			((and (IsFlag 352) (not (IsFlag 381)))
				(if (not (IsFlag 353))
					(SetFlag 353)
					(gCurRoom setScript: postMalTalk)
				else
					(gMessager say: 5 8 16 0 0 2450) ; "Isn't there anything more you could tell me about Malicia?"
					(self setHotspot: 0)
				)
			)
			(else
				(gCurRoom setScript: maleTrollSleeping 0 noun)
				(self setHotspot: 0)
			)
		)
	)

	(method (isFacingMe param1 &tmp temp0 temp1)
		(cond
			(argc
				(= temp0 param1)
			)
			((gCast contains: gEgo)
				(= temp0 gEgo)
			)
			(else
				(return 1)
			)
		)
		(if
			(>
				(= temp1
					(Abs
						(-
							(GetAngle (temp0 x:) (temp0 y:) x y)
							(temp0 heading:)
						)
					)
				)
				180
			)
			(= temp1 (- 360 temp1))
		)
		(return (<= temp1 sightAngle))
	)

	(method (femaleDoVerb)
		(if (not (IsFlag 354))
			(SetFlag 354)
			(gCurRoom setScript: femFirst)
		else
			(gCurRoom setScript: femPost)
			(self setHotspot: 0)
		)
	)
)

(instance troll1 of MudTroll
	(properties)

	(method (init)
		(self
			view: 2461
			loop: 0
			cel: 0
			setPri: 129
			sightAngle: 25
			setHotspot: 8 10 ; Do, Exit
		)
		(if (or (not (IsFlag 87)) (IsFlag 55))
			(self posn: 97 105)
			(gKqMusic1 number: 2475 setLoop: -1 play:)
		else
			(self view: 2463 posn: 113 107)
			(gKqMusic1 number: 2477 setLoop: -1 play:)
		)
		(super init: &rest)
		(if male
			(= noun 4)
		)
	)
)

(instance troll2 of MudTroll
	(properties)

	(method (init)
		(self
			view: 2461
			loop: 1
			cel: 0
			setPri: 129
			sightAngle: 25
			setHotspot: 8 10 ; Do, Exit
		)
		(if (or (not (IsFlag 87)) (IsFlag 55))
			(self posn: 247 106)
		else
			(self view: 2463 posn: 237 101)
		)
		(super init: &rest)
		(if male
			(= noun 3)
			(if (and (IsFlag 352) (not (IsFlag 353)) (not (IsFlag 55)))
				(self setScript: sinkAndBeReady)
			)
		)
	)
)

(instance male1Talker of KQTalker
	(properties
		modeless 2
		clientCel -1
	)

	(method (init)
		(= client troll2)
		(super init: &rest)
	)

	(method (say)
		(if (and (not (troll2 isFacingMe:)) (not (IsFlag 55)))
			(proc11_3 gEgo troll2)
		)
		(super say: &rest)
	)
)

(instance male2Talker of KQTalker
	(properties
		modeless 2
		clientCel -1
	)

	(method (init)
		(= client troll1)
		(super init: &rest)
	)

	(method (say)
		(if (and (not (troll1 isFacingMe:)) (not (IsFlag 55)))
			(proc11_3 gEgo troll1)
		)
		(super say: &rest)
	)
)

(instance fem1Talker of KQTalker
	(properties
		modeless 2
		clientCel -1
	)

	(method (init)
		(= client troll2)
		(super init: &rest)
	)

	(method (say)
		(if (not (troll2 isFacingMe:))
			(proc11_3 gEgo troll2)
		)
		(super say: &rest)
	)
)

(instance fem2Talker of KQTalker
	(properties
		modeless 2
		clientCel -1
	)

	(method (init)
		(= client troll1)
		(gKqSound1 stop:)
		(super init: &rest)
	)

	(method (dispose)
		(gKqSound1 number: 24600 setLoop: -1 play:)
		(super dispose: &rest)
	)

	(method (say)
		(if (not (troll1 isFacingMe:))
			(proc11_3 gEgo troll1)
		)
		(super say: &rest)
	)
)

