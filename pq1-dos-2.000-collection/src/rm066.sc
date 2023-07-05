;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm066 0
	Oliver 1
)

(local
	local0
	local1
	local2 = 1
)

(instance rm066 of PQRoom
	(properties
		noun 1
		picture 66
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 60 150 124 182 212 182 267 131 173 95
					yourself:
				)
		)
		(super init:)
		(if (and (>= global211 55) (< global211 58))
			(= local2 0)
		)
		(door init:)
		(theFloor init:)
		(panels init:)
		(seal init:)
		(windoe init:)
		(wThing init:)
		(if (== gPrevRoomNum 67)
			(gLongSong number: 0 stop:)
			(self setScript: escape)
		else
			(self setScript: comeIn)
			(if (and (>= global211 55) (< global211 58))
				(gLongSong number: 154 loop: -1 flags: -1 play:)
				(clerk approachVerbs: 2 init:) ; Talk
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((>= (gEgo y:) 163)
				(self setScript: leav)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager
					say:
						noun
						theVerb
						(switch (++ local0)
							(2 5)
							(3 6)
							(else 4)
						)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 124
		y 111
		noun 3
		approachX 118
		approachY 126
		view 571
		signal 20737
		cycleSpeed 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== global211 57)
					(gCurRoom setScript: goIn)
				else
					(gMessager say: noun theVerb 0) ; "You'd better not enter the court until invited. You certainly don't want to incure the wrath of Judge Richard Palmer. He's one tough judge."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clerk of Actor
	(properties
		x 217
		y 84
		noun 8
		approachX 199
		approachY 107
		view 572
		priority 4
		signal 16657
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(if (== global211 55)
					(= global211 56)
				)
				(if
					(==
						(= temp0
							(if (IsFlag 23)
								11
							else
								(switch (++ local1)
									(1 7)
									(2 8)
									(3 9)
									(else 10)
								)
							)
						)
						9
					)
					(gCurRoom setScript: getClearance)
				else
					(gMessager say: noun theVerb temp0)
					(if (== temp0 11)
						(= local2 1)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Oliver of Narrator
	(properties
		x 150
		y 110
		talkWidth 150
		showTitle 1
		back 28
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 158 170 init:)
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 158 147 self)
			)
			(2
				(self dispose:)
				(NormalEgo)
				(HandsOn)
			)
		)
	)
)

(instance escape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door signal: 20480 cel: 5)
				(gEgo posn: 91 109 init: setPri: 7)
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 119 126 self)
			)
			(2
				(door setCycle: Beg self)
			)
			(3
				(sfx number: 914 play:)
				(door signal: (| (door signal:) $0100) stopUpd:)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leav of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
				(if (gLongSong handle:)
					(gLongSong fade:)
				)
			)
			(1
				(gCurRoom newRoom: 65)
			)
		)
	)
)

(instance goIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 118 126 self)
			)
			(1
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(2
				(door
					signal: (& (door signal:) $feff)
					startUpd:
					setCycle: End self
				)
			)
			(3
				(gEgo setMotion: MoveTo 91 109 self)
				(if (gLongSong handle:)
					(gLongSong fade: 0 10 10 1 self)
				else
					(= cycles 2)
				)
			)
			(4)
			(5
				(gCurRoom newRoom: 67)
			)
		)
	)
)

(instance getClearance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global211 57)
				(SetFlag 172)
				(gMessager say: 8 2 9 0 self) ; "Please, sir, we have reason to believe that Hoffman is extremely dangerous. Lives may be on the line here."
			)
			(1
				(clerk
					signal: (& (clerk signal:) $feff)
					startUpd:
					view: 570
					posn: 220 106
					setCycle: Walk
					setMotion: MoveTo 150 50 self
				)
			)
			(2
				(clerk setMotion: MoveTo 220 106 self)
			)
			(3
				(clerk
					posn: 217 84
					view: 572
					signal: (| (clerk signal:) $0100)
					stopUpd:
				)
				(= cycles 2)
			)
			(4
				(gMessager say: 8 2 10 0 self) ; "Go on in. The judge will see you now."
			)
			(5
				(self dispose:)
				(= local2 1)
				(HandsOn)
			)
		)
	)
)

(instance theFloor of Feature
	(properties
		noun 4
		onMeCheck 2
	)
)

(instance panels of Feature
	(properties
		noun 5
		onMeCheck 4
	)
)

(instance seal of Feature
	(properties
		noun 6
		onMeCheck 16
	)
)

(instance windoe of Feature
	(properties
		noun 2
		onMeCheck 32
	)
)

(instance wThing of Feature
	(properties
		noun 7
		onMeCheck 128
	)
)

(instance sfx of Sound
	(properties)
)

