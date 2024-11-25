;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use invCode)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm530 0
	offScreen 1
	spTalk2 2
	benTalker 16
	spTalk3 18
)

(local
	local0 = 1
	local1
	local2 = 1
	local3 = 1
	local4 = 1
	local5
)

(instance rm530 of ADRoom
	(properties
		noun 9
		picture 530
		horizon 75
		vanishingY -60
	)

	(method (init)
		(super init: &rest)
		(LoadMany rsVIEW 907 530 531 532 533)
		(gEgo normalize: init: view: 803 loop: 2 cel: 0 x: 186 y: 163)
		(gLongSong number: 520 loop: -1 flags: 1 play:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 319 124 207 123 212 131 60 128 53 136 152 136 119 180 98 183 48 170 37 137 0 136 0 152 28 154 38 176 16 189 319 189
					yourself:
				)
		)
		(gInventory addAfter: (gInventory at: 44) (invBifocals init: yourself:)) ; Wood_Cutting_c
		(oldBen init: cycleSpeed: 9 setCycle: Fwd)
		(leftGuy init: stopUpd:)
		(midGuy init: stopUpd:)
		(rightGuy init: stopUpd:)
		(chairs init: setOnMeCheck: 1 16384)
		(columns init: setOnMeCheck: 1 4096)
		(desks init: setOnMeCheck: 1 8192)
		(door init:)
		(paper init:)
		(waterglass init:)
		(gCurRoom setScript: sArriveOnScene)
	)

	(method (dispose)
		(gInventory delete: invBifocals)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(sFX number: 927 play:)
				(gMessager say: 9 84) ; "|c1|TRUE. On May 25, 1787, fifty-five delegates from twelve of the colonies met in the Philadelphia convention hall and spent the summer hammering out this country's constitution (Rhode Island refused to send any delegates).|c|"
			)
			(85 ; Talk
				(if (< (gEgo y:) 140)
					(gCurRoom setScript: sTalkOnRoom)
				else
					(gMessager say: 9 85) ; "Wow! This must be the Philadelphia convention hall! I can just smell the freedom in the air! On second thought, maybe it's just all the delegates..."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance sArriveOnScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(sFX number: 929 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize: 790 2)
				(= cycles 1)
			)
			(3
				(Face gEgo leftGuy self)
			)
			(4
				(= cycles 2)
			)
			(5
				(gMessager say: 10 0 12 0 self) ; "...Can't you see the value of Mr. Franklin's proposal? To limit suffrage to landowners would be to silence the most important population of America--the common, hardworking man!"
			)
			(6
				(rightGuy
					view: 531
					setLoop: 2
					cel: 0
					posn: 278 138
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 340 138 self
				)
				(midGuy
					view: 531
					setLoop: 3
					cel: 0
					posn: 171 137
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 340 137 self
				)
				(leftGuy
					view: 531
					setLoop: 1
					cel: 0
					posn: 207 133
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 340 133 self
				)
			)
			(7 0)
			(8 0)
			(9
				(rightGuy dispose:)
				(leftGuy dispose:)
				(midGuy dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkOnRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath (gEgo x:) 144 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 9 85 0 0 self) ; "Wow! This must be the Philadelphia convention hall! I can just smell the freedom in the air! On second thought, maybe it's just all the delegates..."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBenAwakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(= cycles 1)
			)
			(1
				(oldBen
					view: 531
					loop: 0
					cel: 0
					x: 81
					y: 167
					setCycle: End self
				)
			)
			(2
				(glasses init:)
				(glassesFeature init:)
				(= cycles 1)
			)
			(3
				(oldBen
					view: 532
					loop: 1
					cel: 0
					x: 83
					y: 165
					setCycle: End self
				)
			)
			(4
				(oldBen view: 535 loop: 1 stopUpd:)
				(= cycles 1)
			)
			(5
				(gMessager say: 1 85 2 1 4 self) ; "Um, Mr. Franklin?"
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveBifocals of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 424 1)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 48 165 self)
			)
			(2
				(gEgo setHeading: 90)
				(= cycles 4)
			)
			(3
				(gEgo
					view: 532
					loop: 2
					cel: 0
					posn: 60 164
					setCycle: End self
				)
				(oldBen hide:)
				(= gDictionaryWord 44)
			)
			(4
				(gMessager say: 1 72 0 1 self) ; "Here they are, Mr. Franklin."
			)
			(5
				(gEgo put: 45 posn: 48 165 normalize: 790 0)
				(oldBen
					show:
					view: 532
					loop: 3
					cel: 0
					x: 83
					y: 165
					setCycle: End self
				)
			)
			(6
				(oldBen view: 535 loop: 2 stopUpd:)
				(= cycles 1)
			)
			(7
				(gMessager say: 1 72 0 2 5 self) ; "Thank you, lad. My lands, you DO look familiar! Tell me, did I know your father?"
			)
			(8
				(gEgo setMotion: MoveTo 57 173 self)
			)
			(9
				(= local1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPickUpGlasses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 423 1)
				(gEgo get: 45)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 47 181 self)
			)
			(2
				(gEgo view: 805 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setCycle: Beg self)
				(glasses dispose:)
				(glassesFeature dispose:)
			)
			(4
				(gEgo normalize: 790 6)
				(= cycles 2)
			)
			(5
				(gMessager say: 2 7 8 0 self) ; "Found 'em!"
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveHerbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 427 2)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 131 166 self)
			)
			(2
				(gEgo
					view: 533
					loop: 1
					cel: 0
					posn: (- (gEgo x:) 6) (+ (gEgo y:) 1)
					setCycle: End self
				)
			)
			(3
				(gEgo stopUpd:)
				(= cycles 1)
			)
			(4
				(= gDictionaryWord 44)
				(gMessager say: 1 117 3 1 self) ; "Here you are, Ben. |r||c0|Gout|c||r|, huh? Now that's a disease you don't hear much about anymore."
			)
			(5
				(gMessager say: 1 117 3 2 self) ; "You're quite the strange one, aren't you, lad. I only WISH I'd never heard of gout!"
				(if (gEgo has: 2) ; Herb_Packet
					(gEgo put: 2) ; Herb_Packet
				else
					(gEgo put: 1) ; Herb_Cluster
				)
			)
			(6
				(gEgo normalize:)
				(oldBen
					view: 533
					loop: 2
					cel: 0
					posn: 92 163
					setCycle: CT 2 1 self
				)
			)
			(7
				(waterglass dispose:)
				(oldBen setCycle: End self)
			)
			(8
				(oldBen loop: 3 cel: 0 y: 158 setCycle: End self)
			)
			(9
				(oldBen view: 535 loop: 3 stopUpd:)
				(= cycles 1)
			)
			(10
				(gMessager say: 1 117 3 3 5 self) ; "There. That should make me feel better. Now it's home, I think. Just let me lean on you, lad, if you'd be so kind. I'm not the man I once was, you know."
			)
			(11
				(gEgo setMotion: PolyPath 103 180 self)
			)
			(12
				(Face gEgo oldBen)
				(oldBen
					view: 533
					loop: 4
					cel: 0
					posn: 87 169
					setCycle: End self
				)
			)
			(13
				(= cycles 2)
			)
			(14
				(gEgo hide:)
				(oldBen
					setLoop: 5
					cel: 0
					posn: 90 187
					setStep: 4 2
					setCycle: Walk
					setMotion: PolyPath 153 169 self
				)
			)
			(15
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance sDoPaperNoHerbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 425 1)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 805
					loop: 3
					cel: 0
					posn: 124 165
					setCycle: End self
				)
			)
			(2
				(paper x: 114 y: 133 setPri: 10)
				(deskHerbs init:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 790 1 posn: 134 164 stopUpd:)
				(= cycles 2)
			)
			(4
				(gMessager say: 8 7 9 0 self) ; "Let's see, I'll just check under these papers..."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoPaperYesHerbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 7 10 0 self) ; "It would be rude of Pepper to just grab Ben's papers."
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetHerbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 426 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 6 7 8 0 self) ; "Are these your herbs, Ben?"
			)
			(2
				(gEgo
					view: 805
					loop: 3
					cel: 0
					posn: 124 165
					setCycle: End self
				)
			)
			(3
				(deskHerbs dispose:)
				(gEgo get: 2 setCycle: Beg self) ; Herb_Packet
			)
			(4
				(gEgo normalize: 790 1 posn: 134 164)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkBen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 422 1)
				(= cycles 1)
			)
			(1
				(if (IsFlag 424)
					(gGame points: 478 1)
					(= cycles 2)
				else
					(self cue:)
				)
			)
			(2
				(cond
					(local0
						(client setScript: sBenAwakes)
					)
					((not local1)
						(gMessager say: 1 85 4) ; "Um, Ben, I--"
					)
					(local2
						(gMessager say: 1 85 1) ; "Gosh, Ben, how's the Constitution coming along?"
						(= local2 0)
					)
					(local3
						(gMessager say: 1 85 5) ; "Don't worry, Ben. You'll come up with a good constitution. I just know it."
						(= local3 0)
					)
					(local4
						(gMessager say: 1 85 6) ; "You look tired, Ben. You should take it easy."
						(= local4 0)
					)
					(else
						(gMessager say: 1 85 7) ; "Are you sure you're okay, Ben?"
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDoBen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 422 1)
				(= cycles 1)
			)
			(1
				(if local0
					(client setScript: sBenAwakes)
				else
					(gMessager say: 1 7 1) ; "Pepper doesn't want to bother Ben by touching him."
				)
				(self dispose:)
			)
		)
	)
)

(instance oldBen of Actor
	(properties
		x 74
		y 167
		noun 1
		approachX 110
		approachY 182
		_approachVerbs 10
		view 535
		signal 20480
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 6 84) ; Look, Trivia
			(if local0
				(= temp0 2)
			else
				(= temp0 1)
			)
		)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: sDoBen)
			)
			(6 ; Look
				(gMessager say: 1 6 temp0)
			)
			(84 ; Trivia
				(sFX number: 927 play:)
				(gMessager say: 1 84 temp0)
			)
			(85 ; Talk
				(gCurRoom setScript: sTalkBen)
			)
			(72 ; invBifocals
				(gCurRoom setScript: sGiveBifocals)
			)
			(23 ; Herb_Cluster
				(if (and local1 (not local0))
					(gCurRoom setScript: sGiveHerbs)
				else
					(gMessager say: 1 117 4) ; "What's that? I can't see what you're holding up. Where are those blasted BIFOCALS?"
				)
			)
			(24 ; Herb_Packet
				(if (and local1 (not local0))
					(gCurRoom setScript: sGiveHerbs)
				else
					(gMessager say: 1 117 4) ; "What's that? I can't see what you're holding up. Where are those blasted BIFOCALS?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftGuy of Actor
	(properties
		x 207
		y 130
		view 530
		loop 2
	)
)

(instance midGuy of Actor
	(properties
		x 174
		y 137
		view 530
		loop 4
		cel 6
		signal 16384
	)
)

(instance rightGuy of Actor
	(properties
		x 280
		y 138
		view 530
		loop 3
	)
)

(instance glasses of View
	(properties
		x 66
		y 165
		noun 2
		approachX 47
		approachY 181
		_approachVerbs 9
		view 534
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 2 6 8) ; "Ben's bifocals have fallen on the floor."
			)
			(7 ; Do
				(gCurRoom setScript: sPickUpGlasses)
			)
			(84 ; Trivia
				(gMessager say: 2 84) ; "|c1|TRUE. Ben Franklin not only wore bifocals, he invented them. He noticed that he had trouble focusing on objects that were far away from him, yet he had to hold books away from his eyes to see them properly.|c|"
				(sFX number: 927 play:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invBifocals of TWInvItem
	(properties
		loop 6
		cel 4
		message 72
		noun 2
		modNum 530
	)
)

(instance chairs of Feature
	(properties
		noun 3
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 21)
		(super doVerb: theVerb)
	)
)

(instance columns of Feature
	(properties
		noun 4
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 68)
		(super doVerb: theVerb)
	)
)

(instance desks of Feature
	(properties
		noun 5
	)
)

(instance deskHerbs of View
	(properties
		x 109
		y 138
		noun 6
		approachX 134
		approachY 164
		_approachVerbs 9
		view 534
		cel 1
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(cond
					(local0
						(gMessager say: 6 7 2) ; "Pepper shouldn't mess with Ben's stuff while he's asleep."
					)
					((and local1 (not local0))
						(gCurRoom setScript: sGetHerbs)
					)
					(else
						(gMessager say: 1 117 4) ; "What's that? I can't see what you're holding up. Where are those blasted BIFOCALS?"
					)
				)
			)
			(84 ; Trivia
				(gMessager say: 6 84) ; "|c1|TRUE. Many different remedies for gout were tried in the 18th century. A few were successful in reducing the symptoms, but there was no actual cure at this time in history. Gout was often caused by drinking too much wine.|c|"
				(sFX number: 927 play:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Feature
	(properties
		x 313
		y 87
		noun 7
		nsTop 56
		nsLeft 308
		nsBottom 119
		nsRight 319
		sightAngle 40
	)
)

(instance paper of View
	(properties
		x 106
		y 137
		noun 8
		approachX 134
		approachY 164
		_approachVerbs 9
		view 534
		priority 11
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(cond
					(local0
						(gMessager say: 6 7 2 0) ; "Pepper shouldn't mess with Ben's stuff while he's asleep."
					)
					((or (gEgo has: 1) (gEgo has: 2)) ; Herb_Cluster, Herb_Packet
						(gCurRoom setScript: sDoPaperYesHerbs)
					)
					(local5
						(gMessager say: 8 7 11) ; "Pepper doesn't want to handle Ben's papers anymore. She's afraid she'll mess them up."
					)
					(else
						(gCurRoom setScript: sDoPaperNoHerbs)
						(= local5 1)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterglass of View
	(properties
		x 115
		y 133
		noun 11
		view 534
		cel 3
		priority 10
		signal 16
	)
)

(instance glassesFeature of Feature
	(properties
		x 70
		y 166
		noun 2
		nsTop 154
		nsLeft 56
		nsBottom 176
		nsRight 85
		sightAngle 40
	)

	(method (doVerb theVerb)
		(glasses doVerb: theVerb)
	)
)

(instance offScreen of BalloonTalker
	(properties
		x 4
		y 93
		talkWidth 170
		tailPosn 1
	)
)

(instance spTalk2 of BalloonTalker
	(properties
		x 55
		y 90
		talkWidth 160
		tailPosn 1
	)
)

(instance spTalk3 of BalloonTalker
	(properties
		x 124
		y 98
		talkWidth 150
		tailPosn 1
	)

	(method (init)
		(super init:)
		(rightGuy setCycle: Fwd)
	)

	(method (dispose)
		(rightGuy setCycle: 0)
		(super dispose:)
	)
)

(instance benTalker of BalloonTalker
	(properties
		x 66
		y 110
		talkWidth 150
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

