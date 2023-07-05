;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 532)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PPath)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	party 0
)

(local
	[local0 9] = [535 0 2 4 26 38 22 26 27]
	[local9 3] = [-1 {Sheriff's Man} 19]
	[local12 3] = [-1 {Jack} 19]
	[local15 6] = [1530 9 1 2 1 0]
	[local21 7] = [1530 12 2 1 1 2 0]
	[local28 4] = [1530 23 1 0]
	[local32 4] = [1530 16 1 0]
	[local36 9] = [1530 17 3 2 3 3 3 1 0]
	[local45 4] = [1530 113 1 0]
	[local49 4] = [1530 105 1 0]
	[local53 4] = [1530 130 1 0]
	[local57 39] = [186 101 187 109 191 114 192 118 -32768 182 162 178 168 174 172 165 176 159 182 153 196 153 239 -32768 186 165 181 170 174 172 165 176 159 182 153 196 153 239 -32768]
	local96
)

(instance party of Code
	(properties)

	(method (init)
		(sheriff init: stopUpd:)
		((ScriptID 530 1) approachVerbs: 0) ; keeper
		((ScriptID 530 2) setCel: ((ScriptID 530 2) lastCel:) approachVerbs: 0) ; gate, gate
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 168 129 142 129 167 140 160 150 188 150 188 165 153 165 137 189 164 189 165 184 186 184 189 177 201 177 201 159 225 159 244 170 265 178 246 163 287 152 234 156 226 149 204 150 206 129 216 109 241 109 241 105 212 105 204 114 174 114 174 125
					yourself:
				)
		)
		(man1 init: approachVerbs: 5 3) ; Talk, Do
		(man2 init: stopUpd:)
		(man3 init: addToPic:)
		(man4 init: addToPic:)
		(man5 init: addToPic:)
		(man6 init: addToPic:)
		(man7 init: addToPic:)
		(man8 init: addToPic:)
		(wench1 init: setCycle: Fwd)
		(wench2 init: stopUpd:)
		(gCurRoom setScript: enter)
		(pubSound play:)
	)
)

(instance enter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(dick setScript: escape self)
				(gEgo posn: 192 99 setLoop: 2 setMotion: PPath @local57)
			)
			(1
				(man1 view: 753 setCycle: Walk setMotion: MoveTo 192 111 self)
				((ScriptID 530 1) addToPic:) ; keeper
				((ScriptID 530 2) addToPic:) ; gate
			)
			(2
				(gAddToPics doit:)
				((ScriptID 530 1) actions: vbKeeper) ; keeper
				((ScriptID 530 2) actions: vbGate) ; gate
				(man1 setHeading: 180 self)
			)
			(3
				(man1 addToPic:)
				(HandsOn)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (>= (gEgo y:) 142)
			(gEgo setMotion: 0 setScript: prayOrDie)
			(self dispose:)
		)
	)
)

(instance escape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(hal
					init:
					posn: 168 195
					setCycle: Walk
					setMotion: PolyPath 153 239 hal
				)
				(hob
					init:
					posn: 188 180
					setCycle: Walk
					setMotion: PolyPath 153 239 hob
				)
				(dick
					init:
					posn: 190 160
					setCycle: Walk
					setMotion: PolyPath 152 187 self
				)
			)
			(1
				(dick setMotion: MoveTo 152 239 self)
			)
			(2
				(wench2 setScript: makeOut)
				(man2 setScript: drinking)
				(dick dispose:)
			)
		)
	)
)

(instance prayOrDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sheriff setCycle: End self)
			)
			(1
				(Face gEgo sheriff self)
			)
			(2
				(= cycles 1)
			)
			(3
				(Converse @local15 12 999 self) ; "Brother, blesh me...hic!"
			)
			(4
				(self setScript: changeLaughter self 0)
			)
			(5
				(= local96 1)
				(man2 setCycle: Beg setScript: 0)
				(wench2 setScript: 0 setLoop: 0)
				(wench1 setCel: (wench2 lastCel:) setCycle: CT 3 1 wench1)
				(HandsOn)
			)
			(6
				(sheriff setCycle: Beg sheriff)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and local96 (gEgo mover:))
			(= next die)
			(self dispose:)
		)
	)
)

(instance bless of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local96 0)
				(SetScore 10)
				(gEgo view: 531 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(1
				(Converse @local21 12 999 self) ; "Very well. May God give you all that you deserve and may I live to see it. Amen."
			)
			(2
				(gPennies put: 1)
				(NormalEgo)
				(wench1 setScript: changeLaughter 0 1)
				(= ticks 30)
			)
			(3
				(if (>= (gGame detailLevel:) (man2 detailLevel:))
					(man2 setScript: drinking)
				)
				(if (>= (gGame detailLevel:) (wench2 detailLevel:))
					(wench2 setScript: makeOut)
				)
				(wench1 setLoop: 1 setCycle: Fwd)
				(= cycles 1)
			)
			(4
				(gEgo setMotion: PolyPath 196 156 self)
			)
			(5
				(gEgo setMotion: PolyPath 155 189 self)
			)
			(6
				(gEgo setHeading: 180 setMotion: MoveFwd 40 self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance die of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(HandsOff)
				(gEgo setMotion: 0)
				(Converse @local32 12 0 self) ; "Shay, I'm talk--hic!...talking t'you, Monk!"
			)
			(2
				(Converse 3 @local36 12 0 999 1 @local9 2 self) ; "Are you deaf?"
			)
			(3
				(= gDeathNum 28)
				(gRgnMusic stop:)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance drinking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(client setCycle: CT 2 1 self)
			)
			(2
				(client setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance makeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wench2 setCycle: End self)
			)
			(1
				(wench2 setLoop: 2 setCycle: End self)
			)
			(2
				(wench2 setCycle: Beg self)
				(-= state 2)
			)
		)
	)
)

(instance changeLaughter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 0)
					(pubSound number: 541 setLoop: 0 play: self)
					(gRgnMusic number: 538 setLoop: 0 play:)
					(= cycles 1)
				else
					(pubSound number: 540 setLoop: 0 play: self)
					(gRgnMusic number: 530 setLoop: -1 play:)
					(= cycles 1)
				)
			)
			(1
				(= ticks 1000)
			)
			(2
				(= ticks 0)
				(if (== register 1)
					(pubSound number: 539 setLoop: -1 play:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sheriff of Prop
	(properties
		x 169
		y 160
		approachX 190
		approachY 175
		lookStr 77
		view 531
		loop 1
		priority 12
		signal 18448
		cycleSpeed 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(if local96
					(prayOrDie setScript: bless prayOrDie)
				else
					(Say 1530 0 1) ; "I may be a bold outlaw, but that is bolder than I care to be. I'll be glad enough if I can pass him unnoticed."
				)
			)
			(3 ; Do
				(if local96
					(Converse @local28 12) ; "Hurry it up, Brother. Jush give me a bleshing."
				else
					(Say 1530 112 1) ; "That would be utterly foolish."
				)
			)
			(4 ; Inventory
				(cond
					((== invItem 0) ; bucks
						(Converse @local53 12) ; "Keeper your silver, Brother. I'm feeling generoush tonight."
					)
					(local96
						(gEgo setScript: die)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (cue)
		(self addToPic:)
	)
)

(instance hal of Actor
	(properties
		view 434
		signal 24576
	)

	(method (cue)
		(self dispose:)
	)
)

(instance hob of Actor
	(properties
		view 434
		signal 24576
	)

	(method (cue)
		(self dispose:)
	)
)

(instance dick of Actor
	(properties
		view 434
		signal 24576
		illegalBits 0
	)
)

(instance man1 of Actor
	(properties
		x 211
		y 112
		approachX 192
		approachY 116
		lookStr 81
		view 754
		loop 2
		signal 24576
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Converse 1 @local45 @local12 1) ; "Keep moving, Monk. I don't like having you around right now."
			)
			(3 ; Do
				(Converse 1 @local49 @local12 1) ; "Don't you lay hands on me, Monk. I've no love for your kind."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance man2 of Prop
	(properties
		x 95
		y 131
		view 531
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2 ; Look
					(Say 1530 78 1) ; "The Sheriff's men are having a thorough carouse."
				)
				(5 ; Talk
					(Say 1530 115 1) ; "The man's attention is elsewhere."
				)
				(3 ; Do
					(Say 1530 111 1) ; "Why tempt fate? I'm in enough danger already."
				)
				(Unknown_Class_6635
					species
					theVerb
				)
			)
		)
	)
)

(instance man3 of Actor
	(properties
		x 133
		y 139
		lookStr 78
		view 754
		signal 26624
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1530 78 1) ; "The Sheriff's men are having a thorough carouse."
			)
			(5 ; Talk
				(Say 1530 117 1) ; "Talking to these drunken soldiers is far too great a risk."
			)
			(3 ; Do
				(Say 1530 111 1) ; "Why tempt fate? I'm in enough danger already."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance man4 of View
	(properties
		x 219
		y 173
		view 754
		loop 1
		signal 16384
	)

	(method (doVerb)
		(man3 doVerb: &rest)
	)
)

(instance man5 of View
	(properties
		x 128
		y 187
		view 754
		signal 16384
	)

	(method (doVerb)
		(man3 doVerb: &rest)
	)
)

(instance man6 of View
	(properties
		x 75
		y 156
		view 531
		cel 6
	)

	(method (doVerb)
		(man3 doVerb: &rest)
	)
)

(instance man7 of View
	(properties
		x 44
		y 185
		view 754
		cel 3
	)

	(method (doVerb)
		(man3 doVerb: &rest)
	)
)

(instance man8 of View
	(properties
		x 227
		y 122
		view 531
		signal 16384
	)

	(method (doVerb)
		(man3 doVerb: &rest)
	)
)

(instance wench1 of Prop
	(properties
		x 108
		y 140
		view 532
		loop 1
		priority 13
		signal 16400
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1530 83 1) ; "Nice legs."
			)
			(5 ; Talk
				(Say 1530 109 1) ; "That would draw far too much attention to me."
			)
			(3 ; Do
				(Say 1530 108 1) ; "That would be most unseemly for a monk."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self setLoop: 3)
	)
)

(instance wench2 of Prop
	(properties
		x 157
		y 127
		view 532
		signal 16384
		cycleSpeed 10
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1530 82 1) ; "Good, there's nothing like a wanton wench to keep a man distracted."
			)
			(5 ; Talk
				(Say 1530 114 1) ; "They're having too much fun to talk."
			)
			(3 ; Do
				(Say 1530 106 1) ; "I suspect this soldier wouldn't share his doxie with me."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vbKeeper of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Say 1530 38 1) ; "This is not the time to chat with the Innkeeper."
			)
			(3 ; Do
				(return 0)
			)
			(2 ; Look
				(return 0)
			)
			(4 ; Inventory
				(if (== invItem 0) ; bucks
					(Say 1530 131 1) ; "Ale can wait. I wish only to escape from here as quickly as possible."
				else
					(return 1)
				)
			)
			(else
				(return 1)
			)
		)
	)
)

(instance vbGate of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1530 39 1) ; "One of the Sheriff's lackeys stands between me and the door to the ale cellar."
			)
			(3 ; Do
				(Say 1530 84 1) ; "There's no more safety for me that way."
			)
			(else
				(return 0)
			)
		)
	)
)

(instance pubSound of Sound
	(properties
		flags 1
		number 539
		loop -1
	)
)

