;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm30 0
)

(instance rm30 of SQRoom
	(properties
		lookStr {This is one end of what appears to be a large cavern. The only way to go is to the left.}
		picture 30
		west 31
	)

	(method (init)
		(= global166 2)
		(elevdoor init:)
		(shaftDoor init:)
		(blueRocks init:)
		(greenRocks init:)
		(gravel init:)
		(brokenRock init:)
		(LoadMany rsVIEW 130 46 63 45 130)
		(LoadMany rsSOUND 438 421)
		(if (== gPrevRoomNum 31)
			(gEgo init:)
			(self setScript: fromGrateRoom)
			(= style 12)
		else
			(gEgo init: normal: 0)
			(self setScript: fromElevator)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 311 187 302 173 275 166 211 159 192 156 181 149 189 127 188 118 143 123 139 105 131 101 90 102 70 121 0 111 0 0 319 0 319 189 0 189 0 186 48 182 64 182 107 177 162 187
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 86 117 109 109 136 118 134 126 111 127 84 123
					yourself:
				)
		)
		(super init: &rest)
		(if (not (IsFlag 22))
			(Load rsSOUND 441)
			(stalagmite init:)
		)
		(if (IsFlag 71)
			(stickyPlant init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 30 0) ; "Nothing to do there."
			)
			(5 ; Talk
				(Print 30 1) ; "Your words echo about the cavern, apparently not destined to fall on the ears of others."
			)
			(12 ; Smell
				(Print 30 2) ; "It smells like a musty old cave. They need Cave-B-Nu(tm)."
			)
			(11 ; Taste
				(Print 30 3) ; "Nothing worth tasting there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stickyPlant of Prop
	(properties
		x 117
		y 89
		description {chunk of sticky stuff}
		sightAngle 45
		view 130
		loop 3
		priority 9
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (gEgo has: 16) ; Plant
					(Print 30 4) ; "Having an adequate personal collection of natural Keronian adhesive, you choose to leave this sticky gunk where it is."
				else
					(gEgo setScript: takeThePlant)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance takeThePlant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 133 131 self)
			)
			(1
				(gEgo view: 46 setLoop: 2 cel: 0 setCycle: CT 4 1 self)
			)
			(2
				(stickyPlant dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo get: 16) ; Plant
				(ClearFlag 71)
				(NormalEgo 1 1 61)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stalagmite of Prop
	(properties
		x 118
		y 89
		description {stalagmite chunk}
		sightAngle 45
		view 130
		priority 9
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: self)
					(Print 30 5) ; "This stalagmite has obviously been broken loose previously and set back in place."
					(Print 30 6) ; "The being responsible - most likely your Keronian counterpart - tried to fool everyone else by using some sticky gunk to hold it together. (Like that would actually fool anyone!.)"
				else
					(Print 30 7) ; "You've already taken the stalagmite."
				)
			)
			(3 ; Do
				(if (gCast contains: self)
					(gEgo setScript: takeTheRock)
				else
					(Print 30 7) ; "You've already taken the stalagmite."
				)
			)
			(12 ; Smell
				(Print
					{The stalagmite itself has no smell. However, something adhering to the stalagmite does seem to generate a maggot-gagging aroma.}
				)
			)
			(11 ; Taste
				(if (IsFlag 22)
					(Print
						{Hhhaaaachhhh!!! Now why did you have to go and lick the end of that thing! That was terrible! Didn't you get a clue from the nose message?}
					)
				else
					(Print
						{Skillfully maneuvering your tongue along the stalagmite removes the surface-coating of grit and, in turn, transforms your tastebuds into the organic equivalent of double-aught sandpaper.}
					)
					(Print 30 8) ; "You almost wish you had a table or breadboard to sand."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance takeTheRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 134 129 self)
			)
			(1
				(Face gEgo stalagmite)
				(= cycles 2)
			)
			(2
				(gEgo view: 46 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(gEgo moveSpeed: 5 cycleSpeed: 5 cel: 3)
				(= cycles 2)
			)
			(4
				(gSoundEffects number: 447 loop: 1 play:)
				(stalagmite dispose:)
				(gEgo setCycle: End self)
				(gEgo get: 7) ; Rock
				(SetFlag 22)
			)
			(5
				(Print 30 9 #at 10 20) ; "You flex those incredible muscles you wish you had, but you're barely able to snap loose the previously fractured stalagmite tip."
				(HandsOn)
				(stickyPlant init:)
				(NormalEgo 1 1 61)
				(self dispose:)
				(SetFlag 71)
			)
		)
	)
)

(instance fromGrateRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 15 133 setMotion: MoveTo 45 133 self)
			)
			(1
				(NormalEgo 0 1 61)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fromElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					show:
					setPri: 2
					view: 63
					setLoop: 1
					setCel: 0
					yStep: 10
					ignoreControl: -32768
					setCycle: 0
					x: 231
					y: 20
					setMotion: MoveTo 231 30 self
				)
			)
			(1
				(gEgo setCel: 1 setMotion: MoveTo 231 40 self)
			)
			(2
				(gEgo setCel: 2 setMotion: MoveTo 231 52 self)
				(gSoundEffects number: 433 loop: 1 play:)
				(elevdoor setCycle: Beg elevdoor)
			)
			(3
				(gEgo hide:)
				(= cycles 6)
			)
			(4
				(gEgo
					show:
					view: 45
					setLoop: 2
					cel: 0
					x: 178
					y: 175
					setPri: 11
					yStep: 2
					cycleSpeed: 8
					moveSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(5
				(gLongSong number: 403 loop: 1 play:)
				(= cycles 12)
			)
			(6
				(gEgo setCycle: End self)
				(gSoundEffects number: 433 loop: 1 play:)
				(elevdoor setCycle: End elevdoor)
			)
			(7
				(gLongSong number: 421 loop: -1 play:)
				(if (IsFlag 22)
					(Print 30 10 #at 40 10) ; "I'll bet you're getting to truly hate this elevator."
				else
					(Print 30 11 #at 40 10) ; "Hey! What's the deal here?! That elevator doesn't lower - it sucks!"
				)
				(HandsOn)
				(NormalEgo 1 1 61)
				(gEgo setPri: -1)
				(= cycles 15)
			)
			(8
				(elevdoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance brokenRock of Feature
	(properties
		description {shattered rock formation}
		sightAngle 45
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(stalagmite doVerb: theVerb &rest)
	)
)

(instance elevdoor of Prop
	(properties
		x 204
		y 151
		sightAngle 45
		lookStr {It looks like your standard, run-of-the-mill pneumatic transport. This particular model only goes down, however. And it's not a pleasant ride.}
		view 130
		loop 1
		cel 4
		priority 11
		signal 16400
		cycleSpeed 4
	)

	(method (cue)
		(gSoundEffects stop:)
	)

	(method (doVerb theVerb)
		(shaftDoor doVerb: theVerb &rest)
	)
)

(instance shaftDoor of Feature
	(properties
		x 222
		y 76
		description {pneumatic transport}
		sightAngle 45
		onMeCheck 32
		lookStr {It looks like your standard run-of-the-mill pneumatic transport. This particular model only descends, however. And it's not a pleasant ride.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 30 12) ; "Although you imagine yourself a buff individual, you could effect no change in the tube door."
			)
			(11 ; Taste
				(Print 30 13) ; "With professional pride, you observe that the door polish these guys use tastes different than your favorite brand."
			)
			(12 ; Smell
				(Print 30 14) ; "The scent of Berzzleweeze Berry rises to be sampled olfactorally. Must be their polish."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blueRocks of Feature
	(properties
		description {some stalagmites}
		sightAngle 45
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 30 15) ; "These are stalagmites. They stand silently, just as they have done for so many centuries."
			)
			(3 ; Do
				(Print 30 16) ; "They are as solid as rocks and resistant to any manipulation."
			)
			(5 ; Talk
				(Print 30 17) ; "It said to tell you that it's in a meeting and won't be out all day. Please check again in another version or two."
			)
			(12 ; Smell
				(Print 30 18) ; "The stalagmite has no smell."
			)
			(11 ; Taste
				(Print 30 19) ; "It didn't have a taste but its texture gave your tongue that nice rough-out leather look."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance greenRocks of Feature
	(properties
		description {Stalactites}
		sightAngle 45
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 30 20) ; "These are stalactites. They just hang there politely minding their own business."
			)
			(3 ; Do
				(Print 30 21) ; "You can't. Not without the ladder. (See nose message.)"
			)
			(12 ; Smell
				(Print 30 22) ; "You can't. Not without the ladder. (See tongue message.)"
			)
			(11 ; Taste
				(Print 30 23) ; "You can't reach any of them without the ladder."
				(Print 30 24) ; "What do you mean, you don't have the ladder?"
				(Print 30 25) ; "Oh, sorry! We don't let you have one of those until Space Quest III."
				(Print 30 26) ; "Did I mention that Space Quest III was the Software Publisher's Association Award-winning Best Adventure Game for 1989?"
				(Print 30 27) ; "You don't care? Sorry. Never mind."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gravel of Feature
	(properties
		description {loose gravel}
		sightAngle 45
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 30 28) ; "It's an unconsolidated mixture of rock fragments and pebbles."
			)
			(3 ; Do
				(Print 30 29) ; "Unless you get into the masonry field or concrete business they will be of no use."
			)
			(12 ; Smell
				(Print 30 30) ; "YAaachooo!!! Quit sniffing gravel! It makes me sneeze."
			)
			(11 ; Taste
				(Print 30 31) ; "Oh, that's disgusting. Keep running your tongue along the floor like that and you're bound to catch something you don't want."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

