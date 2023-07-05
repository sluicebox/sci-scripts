;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm200 0
)

(local
	seenMsg
	[string 444]
)

(procedure (PrintPlot &tmp t)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		10
		5
		#width
		290
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 3 (LangSwitch t t (+ t t) (+ t t))))
)

(instance rm200 of Rm
	(properties
		picture 200
		east 210
		south 210
	)

	(method (init)
		(Load rsVIEW 200)
		(super init:)
		(self setScript: RoomScript)
		(if (and (TestFlag 17) (not (TestFlag 24)))
			(Load rsVIEW (LangSwitch 201 902))
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(gAddToPics add: atpBinocular1 add: atpBinocular2 doit:)
		(if (and (!= gPrevRoomNum 203) (!= gPrevRoomNum 206))
			(gEgo posn: 315 167 loop: 1)
		)
		(NormalEgo)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(and
				(not (super handleEvent: event))
				gModelessDialog
				(== (event message:) KEY_RETURN)
				(== (event type:) evKEYBOARD)
			)
			(event claimed: 1)
			(cls)
			(self cue:)
		)
		(cond
			((Said '/binocular,binocular>')
				(cond
					((Said 'get,get')
						(Print 200 0) ; "The binoculars are here for the enjoyment of all. Please respect the wishes of "Natives, Inc." and allow them to remain."
					)
					((Said 'use,(look,look<through,in)')
						(cond
							(gEgoIsPatti
								(Print 200 1) ; "You won't find Larry by using these binoculars."
							)
							(
								(and
									(not (& (gEgo onControl:) $0004))
									(not (& (gEgo onControl:) $0008))
								)
								(NotClose) ; "You're not close enough."
							)
							((& (gEgo onControl:) $0008)
								(Print 200 2) ; "These binoculars are broken."
							)
							((TestFlag 16)
								(Print 200 3) ; "One look at that is all your heart can take!"
							)
							(else
								(Ok) ; "O.K."
								(gCurRoom newRoom: 206)
							)
						)
					)
					((Said 'look,look')
						(Print 200 4) ; "Two pairs of free binoculars are mounted on posts near the fence."
					)
				)
			)
			((Said 'get,get/awning')
				(Print 200 5) ; "The plaque is securely screwed."
				(Print 200 6 #at -1 144) ; "(And so are you if you want to take it!)"
			)
			((or (Said 'look,look/air') (Said 'up<look,look'))
				(Print 200 7) ; "From high up here on Vista Point, you are almost above the smell of the city."
			)
			((Said 'look,look>')
				(cond
					((Said '/air,up')
						(Print 200 8) ; "From high up here on Vista Point, you are almost above the smell of the city."
					)
					((Said '/cliff,land,cliff')
						(Print 200 9) ; "From here, you can see Kalalau's extensive land holdings high in that mountain valley across the island."
					)
					((Said '/fence,rail')
						(Print 200 10) ; "The fence is there to prevent clumsy people from falling over the edge and ruining the barbecues of the villagers below."
					)
					((Said '/cliff,edge')
						(Print 200 11) ; "This mesa has extremely steep cliffs on three sides."
					)
					((Said '/bay,beach,point,bay,bay')
						(Print 200 12) ; "The polluted lagoon stretches off into the distance like a bag of cold fast-food fries."
					)
					((Said '/camp,down,building,casino,hotel,trap')
						(Print 200 13) ; "The city below you stretches from the edge of the lagoon almost up to your current vantage point. The large resort hotels stretch before you like billboards on the highway of the damned."
						(if (<= gFilthLevel 1)
							(Print 200 14) ; "(Oops, sorry. That should have been "highway of the darned!" You're playing "clean mode," aren't you?)"
						)
					)
					((Said '/blade,carpet,carpet')
						(Print 200 15) ; "Vista Point has a well-manicured, bluegrass lawn with a bronze plaque."
					)
					((Said '/bird')
						(Print 200 16) ; "Where?"
					)
					((Said '/awning')
						(if (& (gEgo onControl:) $0002)
							(if (not (TestFlag 18))
								(SetFlag 18)
								(gGame changeScore: 2)
							)
							(Ok) ; "O.K."
							(gCurRoom newRoom: 203)
						else
							(NotClose) ; "You're not close enough."
						)
					)
					((Said '[/display,display,area]')
						(Print 200 17) ; "From here, on the lovely Vista Point, high up the slopes of Nontoonyt Volcano, the City lies spread below your feet like the floor of a movie theatre after a Saturday matinee!"
						(Print 200 18) ; "A lovely lawn with a bronze plaque lies near two pair of binoculars."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (TestFlag 17))
					(= seconds 5)
				)
			)
			(1
				(Format @string 200 19) ; "My, how this island has changed! You remember when you parachuted down here there was nothing but a sleepy little native village inhabited by a tribe of illiterate islanders. Now look at it: it's overgrown with hotels, resorts, casinos, and cheap tourist traps."
				(= seconds (PrintPlot))
			)
			(2
				(SetFlag 17)
				(if (not (TestFlag 20))
					(Format @string 200 20) ; "Such is the cost of progress. At least your job as Vice-President of Marketing for "Natives, Inc." has enabled you to provide a lovely home for you and your beloved wife, Kalalau."
					(= seconds (PrintPlot))
				)
			)
			(3
				(= seconds 0)
			)
		)
	)
)

(instance atpBinocular1 of PicView
	(properties
		x 137
		y 82
		view 200
		signal 16384
	)
)

(instance atpBinocular2 of PicView
	(properties
		x 205
		y 79
		view 200
		cel 1
		signal 16384
	)
)

(instance aCredit1 of Prop
	(properties
		x 288
		y 131
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 201 902))
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		x 288
		y 154
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 201 902))
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(aCredit1 setCycle: End)
				(= cycles 16)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 22)
			)
			(3
				(SetFlag 24)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)

