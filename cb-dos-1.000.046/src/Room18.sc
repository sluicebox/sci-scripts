;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room18 0
)

(synonyms
	(garden bush)
)

(instance Room18 of Rm
	(properties
		picture 18
	)

	(method (init)
		(= east 8)
		(= north 6)
		(= horizon 135)
		(super init:)
		(Thunder number: 17 loop: 0)
		(self setFeatures: House Gate)
		(if gDetailLevel
			(light1 init: setScript: showers)
			(light2 init:)
			(light3 init:)
		)
		(if (and (== gAct 3) (== gJeevesChoresState 0))
			(self setRegions: 203) ; clarwand
		)
		(switch gPrevRoomNum
			(17
				(gEgo posn: 1 174)
			)
			(12
				(gEgo posn: 1 155)
			)
			(6
				(gEgo posn: 63 137)
			)
			(24
				(gEgo posn: 152 187)
			)
			(23
				(gEgo posn: 74 188)
			)
			(8
				(gEgo posn: 315 180 loop: 1)
			)
			(65
				(gEgo posn: 158 168)
			)
		)
		(gEgo view: 0 illegalBits: -32768 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 18 0) ; "This is an odd-looking place! It seems to be a private little garden completely surrounded by a large hedge. You wonder why."
		)
		(if (& (gEgo onControl: 0) $0004)
			(gCurRoom newRoom: 65)
		)
		(if (== (gEgo edgeHit:) EDGE_LEFT)
			(if (< (gEgo y:) 170)
				(gCurRoom newRoom: 12)
			else
				(gCurRoom newRoom: 17)
			)
		)
		(if (== (gEgo edgeHit:) EDGE_BOTTOM)
			(if (< (gEgo x:) 120)
				(gCurRoom newRoom: 23)
			else
				(gCurRoom newRoom: 24)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 51)
			((ScriptID 208) keep: 0) ; outsideReg
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return)
				)
			)
			(if (Said 'look>')
				(cond
					((Said '[<around,at][/room]')
						(Print 18 0) ; "This is an odd-looking place! It seems to be a private little garden completely surrounded by a large hedge. You wonder why."
					)
					((Said '<(in,through)/garden,archway')
						(Print 18 1) ; "It's rather dark in there. Why don't you just go into the hedge garden?"
					)
					((Said '/garden')
						(Print 18 2) ; "The hedge seems to enclose a small garden area."
					)
					((Said '/path,(boulder<stepping)')
						(Print 18 3) ; "A stone path leads to the entrance of the hedge garden."
					)
				)
			)
		)
	)
)

(instance showers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(light1 setCycle: Fwd)
				(light2 setCycle: Fwd)
				(light3 setCycle: Fwd)
				(= cycles 7)
			)
			(1
				(light1 setCycle: End)
				(light2 setCycle: End)
				(light3 setCycle: End self)
			)
			(2
				(Thunder loop: 1 play: self)
			)
			(3
				(if (< (Random 1 100) 25)
					(= state -1)
				)
				(= cycles 7)
			)
			(4
				(= state 2)
				(= seconds 5)
			)
		)
	)
)

(instance light1 of Prop
	(properties
		y 84
		x 285
		view 118
		cel 1
	)
)

(instance light2 of Prop
	(properties
		y 78
		x 206
		view 118
		loop 1
		cel 1
	)
)

(instance light3 of Prop
	(properties
		y 88
		x 181
		view 118
		loop 2
		cel 1
	)
)

(instance Thunder of Sound
	(properties)
)

(instance House of RFeature
	(properties
		nsTop 77
		nsLeft 14
		nsBottom 111
		nsRight 82
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/cabin'))
			(event claimed: 1)
			(Print 18 4) ; "You see a little shack in the distance to the north."
		)
	)
)

(instance Gate of RFeature
	(properties
		nsTop 107
		nsLeft 170
		nsBottom 162
		nsRight 201
	)

	(method (handleEvent event)
		(cond
			((Said 'close/archway')
				(Print 18 5) ; "There is no need to do that."
			)
			((Said 'open/archway')
				(Print 18 6) ; "The gate is already open."
			)
			((or (MousedOn self event 3) (Said 'look/archway'))
				(event claimed: 1)
				(Print 18 7) ; "A large, arched opening leads into the hedge garden."
			)
		)
	)
)

