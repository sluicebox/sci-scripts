;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Talker)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm41 0
)

(local
	[local0 16] = [92 156 133 155 141 162 139 174 119 184 98 188 67 179 50 166]
	local16
	local17
)

(instance rm41 of SQRoom
	(properties
		lookStr {Ulence Flats is a typical example of some of the frontier settlements that sprang up in the early days of Outer Zone exploration. Unfortunately, this attracted many unsavory quick-buckazoid types. Caution is advised.}
		picture 41
		horizon 138
		north 46
		east 42
		west 40
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 170 288 169 271 175 203 171 208 161 191 160 182 167 162 163 165 160 211 122 149 115 163 155 153 161 138 156 138 155 141 150 131 146 123 142 97 140 125 105 319 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 146 65 151 40 172 0 172
					yourself:
				)
		)
		(cond
			((and (IsFlag 14) (not (IsFlag 15)))
				(ClearFlag 14)
				(= local16 1)
			)
			((and (IsFlag 14) (>= global171 1))
				(++ global171)
				(= local17 100)
			)
		)
		(switch gPrevRoomNum
			(north
				(= style 10)
				(gEgo init: posn: 83 (+ horizon 5))
			)
			(east
				(= style 11)
				(gEgo x: 300)
				(gEgo init:)
				(HandsOn)
			)
			(west
				(= style 12)
				(gEgo x: 20)
				(gEgo init:)
				(HandsOn)
			)
			(43
				(gEgo init: hide:)
				(if (== (gEgo view:) 32)
					(Load rsSOUND 403)
					(self setScript: fallDown)
				else
					(if
						(and
							(>= gBuckazoidCount 130)
							(not (IsFlag 63))
							(not (IsFlag 67))
						)
						(mugger init:)
					)
					(self setScript: comeFromBar)
				)
			)
			(else
				(= style 8)
				(gEgo normal: 0 init:)
				(guy init: stopUpd:)
				(gLongSong number: 600 loop: -1 flags: 1 play:)
				(SetFlag 14)
				(SetScore 25 153)
				(self setScript: getOutaSkimmer)
			)
		)
		(if (IsFlag 14)
			(skimmerPoly points: @local0 size: 8)
			(self addObstacle: skimmerPoly)
			(skimmer init: stopUpd:)
		)
		(self setRegions: 702) ; ulenceRegion
		(super init:)
		(barSign init: setCycle: Osc)
		(rocketSign init: setCycle: Fwd)
		(radar init: setCycle: Fwd)
		(shuttle init:)
		(pickleShip init:)
		(tallRocket init:)
		(barFront init:)
		(barSigns init:)
		(if (and (IsFlag 33) (== gPrevRoomNum 43))
			((ScriptID 702 1) posn: 120 184) ; robot
		)
	)

	(method (doit)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0002)
				(self setScript: intoBar)
			)
			(local16
				(Print 41 0) ; "My, my. It would appear that your skimmer has become the property of another. I wonder who forgot to remove the key?"
				(= local16 0)
			)
			((and local17 (not (-- local17)))
				(if (!= (gLongSong number:) 600)
					(gLongSong number: 600 loop: -1 play: 30 fade: 127 15 10 0)
				)
				(self setScript: sellSkimmerForJet)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 41 1) ; "Nothing to do there."
			)
			(5 ; Talk
				(Print 41 2) ; "Hi. My name's Roger. What's yours?"
			)
			(12 ; Smell
				(Print 41 3) ; "The ground here smells exactly like the ground anywhere else on this planet."
			)
			(11 ; Taste
				(Print 41 4) ; "Don't lick the ground. You're libel to get more than you bargained for."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance comeFromBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo show: posn: 160 158 setMotion: MoveTo 142 166 self)
			)
			(1
				(if (gCast contains: mugger)
					(client setScript: muggerPloy)
				else
					(self cue:)
				)
			)
			(2
				(NormalEgo 0 1 61)
				(gEgo loop: 5 heading: 225)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance intoBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 160 161 self)
			)
			(1
				(if (and (IsFlag 33) (not (IsFlag 66)))
					(Print 41 5) ; "Because it has treads, your robot cannot negotiate the steps leading down into the bar. It will wait here for you (provided nobody steals it)."
					(SetFlag 66)
				)
				(gEgo setHeading: 50 self)
			)
			(2
				(gEgo
					setPri: 11
					xStep: 2
					setLoop: 6
					setMotion: MoveTo 184 174 self
				)
			)
			(3
				(gCurRoom newRoom: 43)
			)
		)
	)
)

(instance fallDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mugger init: stopUpd:)
				(gEgo
					show:
					view: 32
					posn: 160 158
					setMotion: MoveTo 142 166 self
				)
			)
			(1
				(gEgo setLoop: 4 cel: 0 cycleSpeed: 16 setCycle: CT 2 1 self)
			)
			(2
				(gSoundEffects number: 403 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(= seconds 3)
			)
			(4
				(gCurRoom drawPic: 99 -32762)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(5
				(Print 41 6) ; "You stagger out of the bar after ignoring the bartender's advice. You're so sledged that you don't even notice that you're about to become prime prey for the many parasitic life forms in the area. You quickly pass out due to your low Keronian Ale tolerance."
				(= gBuckazoidCount 0)
				(gEgo put: 9 put: 1 put: 10 put: 2 put: 15) ; Skimmer_Key, keyCard, buckazoid, Gadget, Widget
				(mugger dispose:)
				(skimmer dispose:)
				(= seconds 6)
			)
			(6
				(if (IsFlag 14)
					(EgoDead 945 0 0 41 7) ; "While your body tries to sleep it off you lose every possession you own, including your skimmer. Soon, your body is stripped for parts. Obviously, you don't make it through the night."
				else
					(EgoDead 945 0 0 41 8) ; "While your body tries to sleep it off you lose every possession you own. Soon, your body is stripped for parts. Obviously, you don't make it through the night."
				)
			)
		)
	)
)

(instance getOutaSkimmer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 28
					posn: 122 162
					setLoop: 0
					cel: 0
					setPri: 14
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(NormalEgo 0 1 61)
				(gEgo
					posn: 136 185
					heading: 90
					loop: 0
					setMotion: MoveTo 146 181 self
				)
			)
			(2
				(= cycles 20)
			)
			(3
				(if (== global171 0)
					(++ global171)
					(Print 41 9) ; "After a truly stone-crushing journey, you have miraculously arrived safely in Ulence Flats. And just in time too, because the skimmer's power cell has been drained. It will take some time to recharge itself."
					(Print 41 10) ; "This place isn't quite what you had expected. It is semi-bleak at best."
					(= cycles 20)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(4
				(Print 41 11) ; "An odd-looking fellow is lounging against the wall of a nearby building, watching you with a great deal of interest."
				(guy
					ignoreActors: 1
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 227 215 self
				)
			)
			(5
				(guy setLoop: 1 cel: 3)
				(gEgo setHeading: 150)
				(= cycles 40)
			)
			(6
				(guy setMotion: MoveTo 126 188 self)
			)
			(7
				(guy setLoop: 6 cel: 0)
				(gEgo setHeading: 245)
				(= cycles 30)
			)
			(8
				(guy setLoop: 1 setMotion: MoveTo 56 193 self)
			)
			(9
				(guy setLoop: 4 cel: 0)
				(= cycles 45)
			)
			(10
				(guy setMotion: MoveTo 68 185 self)
			)
			(11
				(guy setLoop: 2 setMotion: MoveTo 96 189 self)
			)
			(12
				(guy setLoop: 0 setMotion: MoveTo 182 181 self)
			)
			(13
				(guy setLoop: 2 cel: 5)
				(= cycles 16)
			)
			(14
				(guy ignoreActors: 0 setLoop: 6 cel: 0)
				(gEgo setHeading: 90)
				(= cycles 22)
			)
			(15
				(guyTalker init: guyBust guyEye guyMouth 141 0 0 0 self) ; "Say, pal - I couldn't help noticing your skimmer. It's a genuine '86 Pleiades GL. I've been looking everywhere for one of these babies."
			)
			(16
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if
					(Print ; "How'd ya like to unload it for the unheard-of price of 25 buckazoids?"
						41
						12
						#at
						12
						-1
						#button
						{You've got a deal!}
						1
						#button
						{No way!}
						0
					)
					(client setScript: sellSkimmerForMoney)
				else
					(guyTalker x: 70 say: 141 1 0 1 self) ; "Fine. Be that way."
				)
			)
			(17
				(guy setLoop: 0 setMotion: MoveTo 340 188 self)
			)
			(18
				(guy dispose:)
				(gLongSong client: self fade:)
			)
			(19
				(gLongSong number: 601 loop: -1 flags: 1 play:)
				(= local17 400)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sellSkimmerForMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guy setLoop: 6 cel: 0 setCycle: End self)
			)
			(1
				(gEgo
					view: 28
					setLoop: 4
					cel: 0
					cycleSpeed: 14
					setCycle: CT 1 1 self
				)
			)
			(2
				(if (gEgo has: 9) ; Skimmer_Key
					(guyTalker say: 141 2 0 1 self) ; "Glad we could do business. I'll just take that key. Thank you kindly. Hope your stay in Ulence Flats is an interesting one."
				else
					(guyTalker say: 141 3 0 1 self) ; "Glad we could do business. Hope your stay in Ulence Flats is an interesting one."
				)
			)
			(3
				(+= gBuckazoidCount 25)
				(gEgo put: 9) ; Skimmer_Key
				(SetFlag 15)
				(ClearFlag 14)
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo 0 1 61)
				(gEgo loop: 0)
				(guy setCycle: Beg self)
			)
			(5
				(guy
					ignoreActors: 1
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 136 185 self
				)
			)
			(6
				(guy
					setPri: 14
					posn: 122 162
					setLoop: 8
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(7
				(skimmer dispose:)
				((gCurRoom obstacles:) delete: skimmerPoly)
				(guy
					setLoop: 9
					cel: 0
					cycleSpeed: 12
					moveSpeed: 4
					setCycle: End self
				)
			)
			(8
				(gLongSong2 number: 439 loop: -1 play: hold: 1)
				(guy setStep: 10 8 setMotion: MoveTo 170 202 self)
			)
			(9
				(gLongSong number: 601 loop: -1 play:)
				(gLongSong2 fade: hold: 0)
				(guy dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sellSkimmerForJet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guy
					init:
					ignoreActors: 1
					ignoreHorizon: 1
					posn: 144 134
					setLoop: 1
					setCycle: Walk
					setStep: 4 2
					setMotion: MoveTo 104 133 self
				)
			)
			(1
				(guy setLoop: 7 cel: 0)
				(= seconds 2)
			)
			(2
				(guyEye loop: 5 nsLeft: 35 nsTop: 29)
				(guyMouth loop: 3 nsLeft: 37 nsTop: 40)
				(guyTalker
					loop: 1
					posn: 108 25
					nsLeft: 8
					nsTop: 6
					init: guyBust guyEye guyMouth 141 4 0 0 self ; "Okay, buddy - you drive a hard bargain. This is my final offer and I'm only making it 'cause I can see you need it pretty bad."
				)
			)
			(3
				(guyTalker say: 141 5 0 0 self) ; "I'll make it 30 buckazoids and I'll throw in this swell jetpack. It was previously owned by a little old Thark who only flew it back and forth to Phleebhut on Sunday. It works great in zero gravity. You'll love it."
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if
					(Print ; "Do we have a deal, or don't we?"
						41
						13
						#at
						113
						14
						#button
						{It's a deal!}
						1
						#button
						{No way!}
						0
					)
					(= ticks 4)
				else
					(client setScript: noTwice)
				)
			)
			(5
				(guyTalker say: {"Great!"} 0 0 1 self)
			)
			(6
				(gEgo setMotion: PolyPath 64 133 self)
			)
			(7
				(gEgo setHeading: 90 self)
			)
			(8
				(guy
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 6
					cel: 0
					setCycle: End self
				)
			)
			(9
				(gEgo
					view: 28
					setLoop: 4
					cel: 0
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(10
				(guy setCycle: Beg self)
			)
			(11
				(guyMouth nsLeft: 26 nsTop: 40 loop: 2)
				(guyEye nsLeft: 39 nsTop: 29 loop: 4)
				(if (gEgo has: 9) ; Skimmer_Key
					(guyTalker
						loop: 0
						init: guyBust guyEye guyMouth 141 7 0 0 self ; "Glad we could do business. I'll just take that key. Thank you kindly."
					)
				else
					(guyTalker
						loop: 0
						init: guyBust guyEye guyMouth 141 8 0 0 self ; "Glad we could do business."
					)
				)
			)
			(12
				(guyTalker say: 141 9 0 1 self) ; "In addition, I'd like you to have these coupons good for discounts and free merchandise from some of our local merchants. As a representative of the Ulence Flats Chamber of Commerce, I hope you enjoy your visit to our friendly little community."
			)
			(13
				(guy
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 6
					cel: 0
					setCycle: End self
				)
			)
			(14
				(gEgo
					view: 28
					setLoop: 3
					cel: 0
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(15
				(guy setCycle: Beg self)
			)
			(16
				(NormalEgo 0 1 61)
				(gEgo cycleSpeed: 8 loop: 0 get: 11 get: 18 get: 17 put: 9) ; Jetpack, Droids-B-Us_coupon, Bar_Coupon, Skimmer_Key
				(SetScore 5 154)
				(+= gBuckazoidCount 30)
				(SetFlag 15)
				(ClearFlag 14)
				(guy
					cycleSpeed: 8
					ignoreActors: 1
					setLoop: 2
					setCycle: Walk
					posn: 103 139
					setMotion: MoveTo 147 174 self
				)
			)
			(17
				(gEgo setMotion: MoveTo 68 140)
				(guy setLoop: 3 setMotion: MoveTo 137 187 self)
			)
			(18
				(guy
					setPri: 14
					posn: 122 162
					setLoop: 8
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(19
				(skimmer dispose:)
				((gCurRoom obstacles:) delete: skimmerPoly)
				(gLongSong2 number: 439 loop: -1 play: hold: 1)
				(guy setLoop: 9 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(20
				(guy setStep: 10 8 moveSpeed: 2 setMotion: MoveTo 170 202 self)
			)
			(21
				(gLongSong number: 601 loop: -1 play:)
				(gLongSong2 fade: hold: 0)
				(guy dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance noTwice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guyTalker say: 141 6 0 1 self) ; "Fine. Be that way."
			)
			(1
				(guy setLoop: 0 setMotion: MoveTo 164 134 self)
			)
			(2
				(HandsOn)
				(guy dispose:)
				(self dispose:)
			)
		)
	)
)

(instance getOnSkimmer of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 28
					posn: 122 162
					setLoop: 0
					cel: 5
					setPri: 14
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance bendOverSkimmer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(skimmer approachX:)
						(skimmer approachY:)
						self
				)
			)
			(1
				(gEgo view: 28 loop: 1 cel: 0 setCycle: Osc 1 self)
			)
			(2
				(if register
					(Print 41 14) ; "It's no use. The sand skimmer's power cells still haven't charged themselves."
				else
					(Print 41 15) ; "You remove the skimmer's key from its dashboard."
				)
				(NormalEgo 0 1 61)
				(gEgo loop: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance muggerPloy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 40)
				(gEgo setMotion: MoveTo 143 180)
				(mugger
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 256 184 self
				)
			)
			(1
				(mugger setLoop: 1 setMotion: MoveTo 204 184 self)
			)
			(2
				(mugger setLoop: 8 cel: 0)
				(gEgo setHeading: 45 self)
			)
			(3
				(= seconds 2)
			)
			(4
				(muggerTalker
					init: muggerBust muggerEyes muggerMouth 141 10 0 0 self ; "Say there, pal. It's come to my attention that you're in the market for some transportation."
				)
			)
			(5
				(muggerTalker say: 141 11 0 1 self) ; "I may be able to help. If you'll follow me, I'd like to show you a fine little piece of machinery that'll knock your eyes out."
				(mugger setCycle: Osc 2 self)
			)
			(6
				(mugger setLoop: 2 cel: 0)
				(= cycles 3)
			)
			(7
				(mugger
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 339 180 self
				)
			)
			(8
				(mugger dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance guy of Actor
	(properties
		x 289
		y 170
		view 431
		loop 3
		cel 3
		cycleSpeed 6
		xStep 4
		moveSpeed 6
	)
)

(instance mugger of Actor
	(properties
		x 286
		y 174
		description {alien wolf-creature}
		lookStr {This being is about the size of a humanoid but has some odd features. He seems to have a friendly-looking mug.}
		view 432
		loop 3
		cycleSpeed 6
		xStep 4
		moveSpeed 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 41 16) ; "You sure know how to push things."
			)
			(5 ; Talk
				(Print 41 17) ; "He wants cash, not conversation."
			)
			(12 ; Smell
				(Print 41 18) ; "He won't take kindly to that."
			)
			(11 ; Taste
				(Print 41 18) ; "He won't take kindly to that."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rocketSign of Prop
	(properties
		x 181
		y 66
		description {rocket sign}
		view 141
		priority 10
		signal 16
		cycleSpeed 2
		detailLevel 3
	)

	(method (doVerb)
		(barSigns doVerb: &rest)
	)
)

(instance barSign of Prop
	(properties
		x 174
		y 110
		description {rocket sign}
		view 141
		loop 1
		priority 10
		signal 16
		cycleSpeed 4
		detailLevel 2
	)

	(method (doVerb)
		(barSigns doVerb: &rest)
	)
)

(instance skimmer of View
	(properties
		x 122
		y 162
		description {sand skimmer}
		approachX 132
		approachY 180
		view 141
		loop 2
		priority 13
		signal 16400
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 15)
					(Print 41 19) ; "You already have the keys."
				else
					(gEgo get: 9) ; Skimmer_Key
					(SetFlag 15)
					(gCurRoom setScript: bendOverSkimmer 0 0)
				)
			)
			(2 ; Look
				(if (IsFlag 15)
					(Print 41 20) ; "The sand skimmer is a one-passenger mode of transportation and it looks like it has skimmed quite a bit of sand in its time. On its control panel is a small readout, currently dark, and a keyhole without a key in it."
				else
					(Print 41 21) ; "The sand skimmer is a one-passenger mode of transportation and it looks like it has skimmed quite a bit of sand in its time. On its control panel is a small readout, currently dark, and a keyhole with a key in it."
				)
			)
			(4 ; Inventory
				(switch invItem
					(9 ; Skimmer_Key
						(gCurRoom setScript: bendOverSkimmer 0 1)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(5 ; Talk
				(Print 41 22) ; "Alas, it does not respond."
			)
			(12 ; Smell
				(Print 41 23) ; "It smells warm after the long ride."
			)
			(11 ; Taste
				(Print 41 24) ; "You take a quick look, notice it hasn't been cleaned in awhile, and change your mind."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance radar of Prop
	(properties
		x 83
		y 164
		description {force field sensor}
		lookStr {The settlement of Ulence Flats is surrounded by these force field generators. They repel undesirables, such as the Grell, which thrive below the sands. It will allow only airborne vehicles in or out.}
		view 141
		loop 3
		priority 15
		signal 16400
		cycleSpeed 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 41 25) ; "I wouldn't mess with them if I were you."
			)
			(5 ; Talk
				(Print 41 26) ; "No answer is forthcoming."
			)
			(12 ; Smell
				(Print 41 25) ; "I wouldn't mess with them if I were you."
			)
			(11 ; Taste
				(Print 41 25) ; "I wouldn't mess with them if I were you."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance shuttle of Feature
	(properties
		description {shuttle craft}
		onMeCheck 4
		lookStr {This appears to be a long-range shuttle, perhaps from a large starship. It looks vaguely familiar somehow.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 41 27) ; "You decide it would be better not to tamper with it."
			)
			(5 ; Talk
				(Print 41 28) ; "Like most spaceships in your experience, this one won't talk to you."
			)
			(12 ; Smell
				(Print 41 29) ; "Smelling this ship seems like a giant waste of time."
			)
			(11 ; Taste
				(Print 41 30) ; "There's not much point in licking the ship - it's already quite clean."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pickleShip of Feature
	(properties
		description {pickle ship}
		onMeCheck 16
		lookStr {This ship is a real classic - a WalWood WarpBlaster ZX with the original paint job. You've only seen these on old postcards.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 41 31) ; "You really don't want to get handprints all over a valuable antique like this one."
			)
			(5 ; Talk
				(Print 41 32) ; "Your shout produces no response. The ship is empty."
			)
			(12 ; Smell
				(Print 41 33) ; "You're a nosy little beggar, aren't you?"
			)
			(11 ; Taste
				(Print 41 34) ; "Didn't your mother tell you not to go licking other people's spaceships?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tallRocket of Feature
	(properties
		description {tall rocket ship}
		onMeCheck 8
		lookStr {This one's a genuine antique from the twenty-fourth-and-a-half century.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 41 35) ; "Better not - it'd probably fall over."
			)
			(5 ; Talk
				(Print 41 36) ; "You shout in the direction of the ship, but no one answers."
			)
			(12 ; Smell
				(Print 41 37) ; "It mainly smells like the dust that's been accumulating on it for the past fifty years."
			)
			(11 ; Taste
				(Print 41 38) ; "What a revolting idea!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barFront of Feature
	(properties
		description {bar}
		onMeCheck 32
		lookStr {There is a rounded structure here with a door on one side. It is typical of some of the prefab structures constructed in frontier areas years ago.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance barSigns of Feature
	(properties
		description {Rocket Bar's sign}
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 41 39) ; "The sign is very unusual. It looks as though the whole building has been constructed around the wreckage of a crashed spaceship."
				(Print 41 40) ; "Or maybe the traffic around here is just really awful."
			)
			(3 ; Do
				(Print 41 41) ; "The naked wiring you can see from here makes touching the sign seem unwise."
			)
			(5 ; Talk
				(Print 41 42) ; "The Rocket Bar sign has nothing to say to you."
			)
			(12 ; Smell
				(Print 41 43) ; "You detect the scent of neon and zapped bugs."
			)
			(11 ; Taste
				(Print 41 44) ; "That doesn't seem either intelligent or appetizing."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance guyTalker of Talker
	(properties
		x 15
		y 75
		nsTop 58
		nsLeft 205
		view 506
	)
)

(instance guyBust of View
	(properties
		view 506
		cel 1
	)
)

(instance guyMouth of Prop
	(properties
		nsTop 40
		nsLeft 26
		view 506
		loop 2
		cycleSpeed 12
	)
)

(instance guyEye of Prop
	(properties
		nsTop 29
		nsLeft 39
		view 506
		loop 4
		cycleSpeed 30
	)
)

(instance muggerTalker of Talker
	(properties
		x 7
		y 46
		nsTop 5
		nsLeft 207
		view 515
	)
)

(instance muggerBust of View
	(properties
		view 515
		cel 1
	)
)

(instance muggerMouth of Prop
	(properties
		nsTop 44
		nsLeft 19
		view 515
		loop 2
		cycleSpeed 8
	)
)

(instance muggerEyes of Prop
	(properties
		nsTop 32
		nsLeft 15
		view 515
		loop 1
		cycleSpeed 16
	)
)

(instance skimmerPoly of Polygon
	(properties
		type PBarredAccess
	)
)

