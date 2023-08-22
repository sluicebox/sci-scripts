;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 850)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm850 0
)

(local
	seenMsg
)

(instance rm850 of LLRoom
	(properties
		picture 850
		east 840
	)

	(method (init)
		(LoadMany rsVIEW 850 851 842)
		(LoadMany rsSOUND 851 852 853 800 801 802)
		(HandsOn)
		(gEgo init: normalize: (if (IsFlag 27) 842 else 570))
		(if (IsFlag 27)
			(gEgo actions: ActionsKRAP)
		)
		(gEgo posn: 270 140 setHeading: 270 edgeHit: EDGE_NONE)
		(super init:)
		(officeDoor init:)
		(sDoor init: approachVerbs: 3 ignoreActors: stopUpd:) ; Do
		(shower init: approachVerbs: 3 ignoreActors: stopUpd:) ; Do
		(showerSide init: approachVerbs: 3 ignoreActors: stopUpd:) ; Do
		(toilet init: approachVerbs: 3 10 2 4) ; Do, Zipper, Look, Inventory
		(myWindow init:)
		(curtain1 init:)
		(curtain2 init:)
		(sink1 init:)
		(sink2 init:)
		(skylight init:)
		(rightStatue init:)
		(leftStatue init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 123 278 129 272 138 247 111 240 111 240 128 83 128 77 112 63 112 52 121 59 128 59 138 51 145 32 152 6 146 4 186 54 186 61 177 89 177 112 165 145 165 139 177 173 177 172 165 207 165 217 177 249 178 256 187 317 187 314 162 283 136 318 131 319 189 0 189
					yourself:
				)
		)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 850 0) ; "John Krapper's bathroom lives up to expectations. Gold fixtures are scattered everywhere. There are even a pair of gold statuettes on either side of the "crapper.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(ActionsKRAP dispose:)
		(super dispose:)
	)

	(method (cue)
		(if (== (officeDoor state:) 0)
			(officeDoor ignoreActors: setPri: 9)
		)
	)
)

(instance shower of Actor
	(properties
		x 25
		y 144
		description {the shower}
		sightAngle 40
		approachX 73
		approachY 139
		lookStr {What appears to be a lovely glass shower rests against the wall.}
		view 850
		priority 8
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 27)
					(gEgo setScript: TakeAShowerScript)
				else
					(TPrint 850 1) ; "You don't need a shower right now, Patti. You're not dirty."
					(TPrint 850 2 67 -1 185) ; "(That is, you're not soiled!)"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance showerSide of Actor
	(properties
		x 26
		y 144
		description {the shower}
		sightAngle 40
		approachX 73
		approachY 139
		lookStr {Why, look! A lovely glass shower stands against the wall.}
		view 850
		cel 1
	)

	(method (doVerb theVerb invItem)
		(shower doVerb: theVerb invItem &rest)
	)
)

(instance officeDoor of Door
	(properties
		x 298
		y 136
		description {the office door}
		approachX 264
		approachY 136
		lookStr {This door leads back to John Krapper's office.}
		view 850
		loop 1
		priority 10
		signal 16
		entranceTo 840
		moveToX 306
		moveToY 127
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gEgo ignoreControl: 2)
				(super doVerb: theVerb invItem &rest)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (close)
		(gEgo observeControl: 2)
		(self caller: rm850)
		(super close:)
	)

	(method (open)
		(self setPri: 10)
		(super open:)
	)
)

(instance sDoor of Actor
	(properties
		x 26
		y 144
		description {the shower}
		approachX 73
		approachY 139
		view 850
		loop 2
	)

	(method (doVerb theVerb invItem)
		(shower doVerb: theVerb invItem &rest)
	)
)

(instance toilet of Feature
	(properties
		x 155
		y 183
		nsTop 178
		nsLeft 134
		nsBottom 189
		nsRight 177
		description {Krapper's crapper}
		sightAngle 40
		approachX 161
		approachY 180
		lookStr {Made of hand-carved, gold-flecked marble with a gold-plated handle and ermine-covered seat, it's obvious to you this guy really knows his "K-RAP!"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 850 3) ; "You reach over and give the handle a solid push."
				(flushSound play:)
			)
			(10 ; Zipper
				(TPrint 850 3) ; "You reach over and give the handle a solid push."
				(flushSound play:)
			)
			(2 ; Look
				(super doVerb: theVerb invItem &rest)
			)
			(4 ; Inventory
				(switch invItem
					(11 ; DayTrotter
						(TPrint 850 4) ; "Wouldn't flushing the photocopies be defeating the whole purpose of your mission?"
					)
					(else
						(TPrint 850 5) ; "Hey! You might need that!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance myWindow of Feature
	(properties
		x 148
		y 80
		nsTop 46
		nsLeft 78
		nsBottom 114
		nsRight 219
		description {the window}
		sightAngle 40
		lookStr {A giant plate-glass window looks out over the lovely glow of downtown Philadelphia at night.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance curtain1 of Feature
	(properties
		x 68
		y 79
		nsTop 48
		nsLeft 59
		nsBottom 111
		nsRight 78
		description {the curtains}
		sightAngle 40
		lookStr {These curtains are only for show; they do not close.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance curtain2 of Feature
	(properties
		x 231
		y 77
		nsTop 43
		nsLeft 221
		nsBottom 112
		nsRight 242
		description {the curtains}
		sightAngle 40
		lookStr {These curtains are only for show; they do not close.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sink1 of Feature
	(properties
		x 117
		y 110
		nsTop 96
		nsLeft 91
		nsBottom 125
		nsRight 143
		description {the left sink}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 850 6) ; "Made of hand-carved, gold-flecked marble with gold-plated faucets, you bet this sink alone is worth more than your grand piano!"
			)
			(3 ; Do
				(if (IsFlag 27)
					(TPrint 850 7) ; "What you really need is a shower."
				else
					(TPrint 850 8) ; "Your hands aren't dirty."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sink2 of Feature
	(properties
		x 204
		y 110
		nsTop 96
		nsLeft 176
		nsBottom 124
		nsRight 233
		description {the right sink}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(sink1 doVerb: theVerb invItem &rest)
			)
			(3 ; Do
				(sink1 doVerb: theVerb invItem &rest)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance skylight of Feature
	(properties
		x 155
		y 14
		nsTop 4
		nsLeft 91
		nsBottom 25
		nsRight 219
		description {the skylight}
		sightAngle 40
		lookStr {The ceiling of John Krapper's bathroom is crowned by a lovely skylight.}
	)
)

(instance rightStatue of Feature
	(properties
		x 118
		y 145
		nsTop 127
		nsLeft 107
		nsBottom 163
		nsRight 129
		description {the statuette}
		lookStr {This statuette was presented to K-RAP Radio for excellence in broadcasting!}
	)
)

(instance leftStatue of Feature
	(properties
		x 197
		y 148
		nsTop 130
		nsLeft 187
		nsBottom 167
		nsRight 207
		description {the statuette}
		lookStr {This statuette was presented to K-RAP Radio for excellence in broadcasting!}
	)
)

(instance clothes of View
	(properties
		x 40
		y 141
		view 850
		cel 2
	)
)

(instance flushSound of Sound
	(properties
		number 851
		priority 11
	)
)

(instance runWaterSound of Sound ; UNUSED
	(properties
		number 852
		priority 11
	)
)

(instance TakeAShowerScript of Script
	(properties)

	(method (changeState newState &tmp i invItem)
		(switch (= state newState)
			(0
				(HandsOff)
				(Points 7)
				(TPrint 850 9) ; "Now, that's a good idea, Patti. Use Krapper's shower to wash that toner from your hands and face."
				(sDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 29 139 self)
				(shower startUpd:)
				(showerSide startUpd:)
			)
			(2
				(gEgo cycleSpeed: 12 view: 851 loop: 2 setCycle: End self)
			)
			(3
				(sDoor cel: 0)
				(gEgo setLoop: 3 setCycle: End self)
				(clothes init:)
			)
			(4
				(TPrint 850 10) ; "As you turn what appears to be a gold-plated faucet, you feel the "shower" begin to move!"
				(gTheMusic2 number: 853 play: hold: 10)
				(sDoor setPri: 1 setMotion: MoveTo 26 226 self)
				(gEgo setPri: 0 setMotion: MoveTo 29 226 self moveSpeed: 6)
				(shower setPri: 1 setMotion: MoveTo 25 226 self)
				(showerSide setPri: 1 setMotion: MoveTo 26 226 self)
			)
			(5
				(for ((= i 0)) (< i (Inv size:)) ((++ i))
					(= invItem (Inv at: i))
					(if (invItem ownedBy: 24)
						(invItem owner: 1000)
					)
				)
				(TPrint 850 11) ; "Where will you end up on this naked adventure?"
				(TPrint 850 12) ; "And without your inventory, too!"
				(gCurRoom newRoom: 860)
			)
		)
	)
)

(instance ActionsKRAP of Actions
	(properties)

	(method (doit)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== (gEgo view:) 842)
					(Say gEgo 850 13) ; "Oh no," you think. "How will I ever get this stuff off me?"
					(return 1)
				else
					(TPrint 850 14) ; "You look yourself over. You like what you see. "Although I could stand to lose a few pounds," you think."
					(return 1)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

