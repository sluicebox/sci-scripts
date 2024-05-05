;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 386)
(include sci.sh)
(use Main)
(use SQRoom)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use User)
(use Actor)
(use System)

(public
	rm386 0
)

(local
	local0
	[local1 22] = [268 99 246 130 86 129 61 105 61 90 110 61 118 32 127 16 162 5 206 27 214 66]
)

(instance rm386 of SQRoom
	(properties
		picture 386
		style 30
	)

	(method (init)
		(Load rsVIEW 386)
		(Load rsSOUND 4)
		(HandsOff)
		(mouth init:)
		(arm init:)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(thePig init:)
		(pigPoly points: @local1 size: 11)
		(theRoom init:)
		(self setScript: talkScript 0 0)
		(super init:)
		(self setRegions: 700) ; mall
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance theRoom of Feature
	(properties
		x 160
		y 100
		nsBottom 200
		nsRight 320
		description {*** Monolith Burger interior}
		lookStr {*** Monolith Burger interior description.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(0
				(gCurRoom newRoom: 385)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePig of Feature
	(properties
		x 160
		y 100
		description {*** pig}
		sightAngle 180
		lookStr {*** the manager.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: pigPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(if (not (gCurRoom script:))
					(HandsOff)
					(talkScript register: (+ (talkScript register:) 1))
					(gCurRoom setScript: talkScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pigPoly of Polygon
	(properties)
)

(instance arm of Prop
	(properties
		x 94
		y 134
		view 386
		loop 2
		cel 1
		priority 2
		signal 2064
	)
)

(instance mouth of Prop
	(properties
		x 158
		y 63
		view 386
		loop 1
		priority 1
		signal 2064
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: 0)
				(if register
					(= cycles 1)
				else
					(= seconds 1)
				)
			)
			(1
				(switch register
					(0
						(= cycles 1)
					)
					(1
						(= local0
							(proc0_12
								(if (== (gEgo view:) 373)
									{***I would like to buy a Mommy burger please.}
								else
									{***I want some food.}
								)
								67
								100
								150
								70
								200
							)
						)
						(= seconds 5)
					)
					(2
						(= local0
							(proc0_12
								(if (== (gEgo view:) 373)
									{***I can cook.}
								else
									{*** I want a job.}
								)
								67
								100
								150
								70
								200
							)
						)
						(= seconds 5)
					)
				)
			)
			(2
				(proc0_12 local0)
				(arm setCel: 0)
				(mouth setLoop: 0 posn: 155 39)
				(= cycles 5)
			)
			(3
				(switch register
					(0
						(= local0
							(proc0_12
								(if (== (gEgo view:) 373)
									{***What can I do for ya doll?}
								else
									{***What can I do for ya?}
								)
								67
								205
								13
								70
								115
							)
						)
					)
					(1
						(= local0
							(proc0_12
								{***I got no food cuz I got no employees.}
								67
								205
								13
								70
								115
							)
						)
					)
					(2
						(= local0
							(proc0_12
								(if (== (gEgo view:) 373)
									{*** No can do, what with you bein female and all.}
								else
									{*** So you want a job.__Well, okay.}
								)
								67
								205
								13
								70
								115
							)
						)
					)
				)
				(arm setCel: 2)
				(mouth init: setCycle: ForwardCounter 8 self)
			)
			(4
				(proc0_12 local0)
				(if (== register 2)
					(= local0
						(proc0_12
							(if (== (gEgo view:) 373)
								{***You male sexist pig!!}
							else
								{*** Gee, thanks.}
							)
							67
							100
							150
							70
							200
						)
					)
				)
				(arm setCel: 0)
				(mouth setLoop: 1 cel: 0 posn: 158 63)
				(= seconds 2)
			)
			(5
				(arm setCel: 1)
				(HandsOn)
				(User canControl: 0)
				(gIconBar disable: 0 1 3 4)
				(if (== register 2)
					(= seconds 3)
				else
					(self dispose:)
				)
			)
			(6
				(proc0_12 local0)
				(if (== (gEgo view:) 373)
					(gCurRoom newRoom: 385)
				else
					(gCurRoom newRoom: 387)
				)
			)
		)
	)
)

