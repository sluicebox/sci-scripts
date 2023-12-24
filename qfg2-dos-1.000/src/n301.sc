;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Guard)
(use Interface)
(use LoadMany)
(use Follow)
(use Window)
(use Motion)
(use Actor)

(public
	SaurusEncounterInit 0
)

(procedure (SaurusEncounterInit)
	(LoadMany rsVIEW 11 297)
	(gCurRoom entranceScript: saurusEncounter)
	(guard init: 0)
	(saurus cel: 3 ignoreActors: 1 posn: 109 117 init: 0)
)

(instance saurusEncounter of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(Print ; "Gronk!!"
					301
					0
					#at
					-1
					120
					#time
					3
					#dispose
					self
					#title
					{Saurus:}
					#window
					saurusWin
				)
			)
			(2
				(saurus setCycle: Walk setMotion: MoveTo 193 117 self)
			)
			(3
				(gEgo hide:)
				(saurus
					view: 297
					loop: 0
					cel: 0
					posn: 200 115
					cycleSpeed: 1
					setCycle: CT 5 1 self
				)
			)
			(4
				(gSpareSound number: 292 loop: 1 play: self)
				(saurus setCycle: End)
			)
			(5
				(= cycles 10)
			)
			(6
				(Say guard self 301 1) ; "Will you please take this Saurus back to the stables?  I have been unable to move it back there.  It seems to have been waiting for you."
			)
			(7
				(saurus
					view: 11
					posn: 193 117
					cel: 0
					cycleSpeed: 0
					illegalBits: 0
					setCycle: Walk
				)
				(gEgo show: setMotion: MoveTo 158 180 self)
				(= cycles 20)
			)
			(8
				(HighPrint 301 2) ; "The Saurus is perfectly willing to follow you back to the stables."
				(saurus setMotion: Follow gEgo 20)
			)
			(9
				(gEgo setMotion: MoveTo 158 260 self)
			)
			(10
				(SetFlag 149) ; fReturningSaurus
				(SetFlag 150) ; fReturnedSaurus300
				(gCurRoom newRoom: 290)
			)
		)
	)
)

(instance saurus of Actor
	(properties
		noun '/saurii'
		description {your saurus}
		yStep 3
		view 11
		xStep 5
	)
)

(instance guard of Guard
	(properties
		x 141
		y 98
	)

	(method (init)
		(super init: &rest)
		(= tWindow BotWindow)
	)
)

(instance saurusWin of Window
	(properties
		color 15
		back 2
	)
)

