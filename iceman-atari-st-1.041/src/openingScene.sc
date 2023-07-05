;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	openingScene 0
)

(local
	local0
)

(procedure (localproc_0 param1 &tmp [temp0 4] [temp4 100])
	(proc0_3)
	(Format @temp4 &rest)
	(TextSize @[temp0 0] @temp4 gUserFont 0)
	(Print
		@temp4
		#at
		-1
		12
		#width
		(if (> [temp0 2] 24) 300 else 0)
		#mode
		1
		#dispose
		#time
		param1
	)
)

(instance openingScene of Rm
	(properties
		picture 1
	)

	(method (init)
		(HandsOff)
		(super init:)
		(self
			setScript: (if (== gPrevRoomNum 2) dinghyScript else openingScript) ; thatchedHut
			setRegions: 300 301 ; tahiti, Water
		)
		(miniActor1 init:)
		(miniActor2 init:)
		(miniActor3 init:)
	)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)
)

(instance openingScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceKeyDownHandler add: self)
		(gIceMouseDownHandler add: self)
	)

	(method (dispose)
		(proc0_3)
		(gIceKeyDownHandler delete: self)
		(gIceMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		else
			(self cue:)
		)
		(event claimed: 1)
	)

	(method (cue)
		(= cycles (= seconds 0))
		(super cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gAddToPics add: littleEgo doit:)
				(= seconds 10)
			)
			(1
				(localproc_0 8 1 0) ; "Welcome to the beautiful island of Tahiti, where warm South Pacific breezes caress the emerald clear waters of a sun-filled paradise."
				(= seconds 8)
			)
			(2
				(localproc_0 8 1 1) ; "A place of fun and relaxation. A place where love and romance can be found. A wonderland where anyone can get lost in its magic."
				(= seconds 8)
			)
			(3
				(localproc_0 8 1 2) ; "We find our man, Commander John B. Westland of the United States Navy, enjoying a well-deserved leave from his recent assignment."
				(= seconds 8)
			)
			(4
				(localproc_0 8 1 3) ; "Our story opens with Commander Westland on the beach soaking up the sun."
				(= seconds 8)
			)
			(5
				(gCurRoom newRoom: 2) ; thatchedHut
			)
		)
	)
)

(instance littleDinghy of Act
	(properties
		yStep 1
		view 1
		xStep 1
	)

	(method (init)
		(super init:)
		(boatSound number: (proc0_5 26) loop: -1 play:)
		(self setPri: 3)
	)
)

(instance dinghyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo put: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
				(littleDinghy
					posn: 205 143
					init:
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 100 152 self
				)
			)
			(1
				(littleDinghy setMotion: MoveTo -10 143 self)
			)
			(2
				(= seconds 5)
			)
			(3
				(littleDinghy
					posn: -10 92
					setLoop: 1
					setMotion: MoveTo 65 80 self
				)
			)
			(4
				(littleDinghy setMotion: MoveTo 120 72 self)
			)
			(5
				(HandsOn)
				(gCurRoom newRoom: 44) ; inPlane
			)
		)
	)
)

(instance littleEgo of PV
	(properties
		y 134
		x 211
		view 1
		loop 2
	)
)

(instance miniActor1 of Act
	(properties
		y 134
		x 171
		yStep 1
		view 1
		xStep 1
		moveSpeed 3
	)

	(method (init)
		(super init:)
		(self setLoop: 3 setMotion: MoveTo 229 138 self)
	)

	(method (cue)
		(super cue:)
		(if (== x 171)
			(self setMotion: MoveTo 229 138 self)
		else
			(self setMotion: MoveTo 171 134 self)
		)
	)
)

(instance miniActor2 of Act
	(properties
		y 135
		x 233
		yStep 1
		view 1
		loop 3
		xStep 1
		moveSpeed 3
	)

	(method (init)
		(super init:)
		(self setLoop: 3 setMotion: MoveTo 312 126 self)
	)

	(method (cue)
		(super cue:)
		(if (== x 233)
			(self setMotion: MoveTo 312 126 self)
		else
			(self setMotion: MoveTo 233 135 self)
		)
	)
)

(instance miniActor3 of Act
	(properties
		y 129
		x 204
		yStep 1
		view 1
		loop 3
		xStep 1
		moveSpeed 3
	)

	(method (init)
		(super init:)
		(self setLoop: 3 setMotion: MoveTo 203 141 self)
	)

	(method (cue)
		(super cue:)
		(if (== x 204)
			(self setMotion: MoveTo 203 141 self)
		else
			(self setMotion: MoveTo 204 129 self)
		)
	)
)

(instance boatSound of Sound
	(properties
		number 26
	)
)

