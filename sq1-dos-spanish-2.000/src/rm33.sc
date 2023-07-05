;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use DScript)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm33 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm33 of SQRoom
	(properties
		picture 33
		style 11
		east 32
	)

	(method (init)
		(LoadMany rsVIEW 23 133 946)
		(gEgo init: illegalBits: 0)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 47 314 47 269 47 223 50 180 39 109 29 36 37 12 67 6 92 12 136 48 152 83 185 319 185 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 73 123 40 88 48 71 67 65 99 55 129 60 272 60 319 60 319 129 277 124 194 124 178 129 169 137 105 152 88 145
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 266 139 319 135 319 156 266 148
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 242 128 271 128 271 135 242 135
					yourself:
				)
		)
		(if (IsFlag 46)
			(laserEnd1 init: cel: 7)
			(laserEnd2 init: cel: 7)
		else
			(gLongSong2 number: 427 loop: -1 flags: 1 play:)
			(LoadMany rsSOUND 459 428 429 432 427)
			(laser init: setCycle: Fwd)
			(laserThing1 init:)
			(laserThing2 init:)
		)
		(super init:)
		(HandsOn)
	)

	(method (dispose)
		(gLongSong2 stop: flags: 0)
		(super dispose:)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0002)
				(= global166 2)
			)
			((& (gEgo onControl:) $0004)
				(= global166 1)
			)
			((and (& (gEgo onControl: 1) $0010) (not (IsFlag 46)))
				(self setScript: chopUpEgo)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Printf
					{You are in left-most room of this cavern. Standing sentinel at the juncture of the lower and upper pathways are two odd-looking units obviously placed there on purpose. %s.}
					(if (IsFlag 46)
						{They are no longer in operation thanks to you.}
					else
						{Something is being emitted by the devices.}
					)
					(if (IsFlag 46)
						{Ya no son operativas gracias a ti.}
					else
						{Los mecanismos est\a0n emitiendo algo.}
					)
				)
			)
			(3 ; Do
				(Print 33 0) ; "Nothing to do there."
			)
			(5 ; Talk
				(Print 33 1) ; "Having seen no other intelligent(?) being for so long, you decide to save your voice."
			)
			(12 ; Smell
				(Print 33 2) ; "You detect a bit of sulfur in the air from the adjoining chamber. Each inhalation packs a bit of an afterburn as an extra, added bonus."
			)
			(11 ; Taste
				(Print 33 3) ; "Nothing worth tasting there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance laserEnd1 of Prop
	(properties
		x 109
		y 113
		view 133
		loop 1
		priority 7
		signal 16400
		cycleSpeed 2
	)
)

(instance laserEnd2 of Prop
	(properties
		x 45
		y 152
		view 133
		loop 2
		priority 14
		signal 16400
		cycleSpeed 2
	)
)

(instance smoke1 of Prop
	(properties
		x 45
		y 152
		view 133
		loop 3
		signal 16384
		cycleSpeed 2
	)
)

(instance smoke2 of Prop
	(properties
		x 109
		y 108
		view 133
		loop 4
		signal 16384
		cycleSpeed 2
	)
)

(instance egoBlowItUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 110 170 self)
			)
			(1
				(gEgo setMotion: MoveTo 106 164 self)
			)
			(2
				(gEgo
					view: 23
					cycleSpeed: 2
					moveSpeed: 2
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(= cycles 4)
			)
			(4
				(laserEnd1 init: cycleSpeed: 5 setCycle: CT 3 1)
				(laserEnd2 init: cycleSpeed: 5 setCycle: CT 3 1 self)
			)
			(5
				(gSoundEffects number: 459 loop: 1 play: self)
			)
			(6
				(gSoundEffects number: 428 loop: 0 play:)
				(laser hide:)
				(gLongSong2 loop: 0 stop:)
				(gEgo setCycle: Beg self)
				(smoke1 init: cycleSpeed: 5 setCycle: End)
				(smoke2 init: cycleSpeed: 5 setCycle: End self)
			)
			(7
				(smoke1 dispose:)
				(smoke2 dispose:)
				(= cycles 1)
			)
			(8
				(laserEnd1 setCycle: End)
				(laserEnd2 setCycle: End self)
				(NormalEgo 1 1 61)
			)
			(9
				(SetScore 5 146)
				(Print 33 4) ; "You have quite cleverly turned the beam upon itself, frying and fusing it into a state of inoperability."
				(SetFlag 46)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance chopUpEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 (gEgo x:))
				(= local4 (gEgo y:))
				(User canControl: 0 canInput: 0)
				(gTheIconBar disable: 0 1 2 3 4 5 6 7)
				(gSoundEffects number: 429 loop: 1 play:)
				(gEgo setCycle: Walk setMotion: MoveTo 75 124 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					view: 23
					setLoop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(= cycles 30)
			)
			(4
				(gEgo setLoop: 2 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gEgo setCycle: End self)
				(gSoundEffects number: 432 loop: 1 play:)
			)
			(6
				(gSoundEffects stop:)
				(= cycles 10)
			)
			(7
				(self setScript: instantReplay self)
			)
			(8
				(= seconds 3)
			)
			(9
				(EgoDead 935 0 0 33 5) ; "You've found quite a number of forms to transform yourself into. This is the first time you've been wafer-style."
			)
		)
	)
)

(instance instantReplay of DScript
	(properties)

	(method (restore)
		(super restore: &rest)
		(= local0 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 40)
				(= local1 0)
			)
			(1
				(= local2 1)
				(gLongSong number: 472 loop: -1 play:)
				(viewBox init: stopUpd:)
				(heads init: stopUpd:)
				(mouth1 init:)
				(mouth2 init:)
				(= cycles 1)
			)
			(2
				(mouth1 setCycle: RandCycle 16)
				(Print 33 6 #dispose) ; "Well, Scott, it looks like Roger has done it yet another time."
				(= seconds 5)
			)
			(3
				(mouth2 setCycle: RandCycle 18)
				(Print 33 7 #dispose) ; "It sure seems that way. For those who might have missed that last move by Roger, or if, like me, you just want another look at it, let's roll it again."
				(= seconds 7)
			)
			(4
				(= cycles 15)
				(gModelessDialog dispose:)
			)
			(5
				(self
					save1:
						(Display ; "Instant Replay!!!"
							33
							8
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global136
							dsSAVEPIXELS
						)
				)
				(= cycles 10)
			)
			(6
				(self restore:)
				(= cycles 1)
			)
			(7
				(self
					save1:
						(Display ; "Instant Replay!!!"
							33
							8
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							165
							dsCOORD
							78
							40
							dsCOLOR
							global132
							dsSAVEPIXELS
						)
				)
				(++ local1)
				(= cycles 10)
			)
			(8
				(self restore:)
				(= cycles 4)
				(if (< local1 10)
					(= state 5)
				)
			)
			(9
				(= cycles 10)
			)
			(10
				(gEgo cycleSpeed: 4 setCycle: Beg self)
			)
			(11
				(gEgo setLoop: 1 cel: 4 setCycle: Beg self)
			)
			(12
				(= seconds 3)
			)
			(13
				(gEgo
					view: 23
					setLoop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(14
				(= cycles 20)
			)
			(15
				(gEgo setLoop: 2 cel: 0 setCycle: CT 1 1 self)
			)
			(16
				(gEgo setCycle: End self)
				(gSoundEffects number: 432 loop: 1 play:)
			)
			(17
				(gSoundEffects stop:)
				(= seconds 2)
			)
			(18
				(mouth2 setCycle: RandCycle 15)
				(Print 33 9 #dispose) ; "You've got to give some high marks for truly fine execution. We'll have to give it a strong 9.8."
				(= seconds 5)
			)
			(19
				(gModelessDialog dispose:)
				(= cycles 20)
			)
			(20
				(self dispose:)
			)
		)
	)
)

(instance laser of Prop
	(properties
		x 49
		y 155
		view 133
		loop 5
		cel 7
		signal 16384
	)

	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 56 64 -1)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 33 10) ; "The beams seem to form some sort of electronic barrier across the path."
			)
			(3 ; Do
				(Print 33 11) ; "Somehow you get the impression that you shouldn't do that. If you really insist, however, try getting closer."
			)
			(12 ; Smell
				(Print 33 12) ; "It's a good way to get that nose job you've often considered."
			)
			(11 ; Taste
				(Print 33 13) ; "You're quite attached to your tongue and would like to keep it that way."
			)
			(4 ; Inventory
				(switch invItem
					(6 ; Broken_Glass
						(self setScript: egoBlowItUp)
					)
					(else
						(Print 33 14) ; "That doesn't seem like the thing to do here, try something else."
					)
				)
			)
			(5 ; Talk
				(Print 33 15) ; "No result."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance laserThing1 of Feature
	(properties
		x 46
		y 164
		description {laser thing1}
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Printf
					{There are two metal units here which %s emitting beams of energy.}
					(if (IsFlag 46) {are no longer} else {appear to be})
					(if (IsFlag 46) {ya no est\a0n} else {parecen estar})
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance laserThing2 of Feature
	(properties
		x 109
		y 134
		z 12
		description {laser thing2}
		onMeCheck 32
		lookStr {}
	)

	(method (doVerb theVerb)
		(laserThing1 doVerb: theVerb &rest)
	)
)

(instance viewBox of View
	(properties
		x 227
		y 16
		view 946
		loop 3
		priority 12
		signal 16400
	)
)

(instance heads of View
	(properties
		x 226
		y 8
		view 946
		priority 13
		signal 16400
	)
)

(instance mouth1 of Prop
	(properties
		x 250
		y 36
		view 946
		loop 1
		priority 14
		signal 16400
		cycleSpeed 1
	)
)

(instance mouth2 of Prop
	(properties
		x 271
		y 39
		view 946
		loop 2
		cel 2
		priority 14
		signal 16400
		cycleSpeed 1
	)
)

