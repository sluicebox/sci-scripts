;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use Follow)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	compoundHallwayRm 0
)

(instance compoundHallwayRm of Rm
	(properties
		picture 86
		north 87
		south 81
	)

	(method (init)
		(super init:)
		(self setRegions: 310) ; tunisia
		(HandsOff)
		(Load rsVIEW 86)
		(switch gPrevRoomNum
			(south
				(Load rsVIEW 85)
				(Load rsVIEW 787)
				(gIceGlobalSound number: 80 owner: gGame priority: 1 loop: -1 play:)
				(self setScript: withGuardScript)
			)
			(else
				(Load rsVIEW 684)
				(Load rsVIEW 787)
				(self setScript: withAmbScript)
			)
		)
		(gEgo init:)
	)
)

(instance withGuardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door init:)
				(gEgo
					view: 85
					posn: 161 157
					setLoop: 3
					init:
					setMotion: MoveTo 161 109 self
				)
				(guard
					setCycle: Walk
					setLoop: 3
					init:
					setMotion: MoveTo 148 110
				)
			)
			(1
				(door setCycle: End self)
				(guard setMotion: 0)
			)
			(2
				(gCurRoom newRoom: 87) ; inCompoundRm
			)
		)
	)
)

(instance withAmbScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 684 posn: 146 104 setLoop: 2 init: setPri: 4)
				(ambass
					setLoop: 2
					setCycle: Walk
					ignoreActors: 1
					init:
					illegalBits: 0
					setPri: 4
				)
				(door init: setPri: 5 setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 146 164 self)
				(ambass setMotion: Follow gEgo 20)
			)
			(2
				(gCurRoom newRoom: 81) ; outsideCompoundRm
			)
		)
	)
)

(instance guard of Act
	(properties
		y 168
		x 148
		view 787
	)
)

(instance ambass of Act
	(properties
		y 101
		x 159
		view 787
	)
)

(instance door of Prop
	(properties
		y 103
		x 137
		view 86
	)
)

