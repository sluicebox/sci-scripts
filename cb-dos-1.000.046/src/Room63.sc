;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Game)
(use Actor)

(public
	Room63 0
)

(synonyms
	(blackboard board)
	(doll bear toy)
)

(instance Room63 of Rm
	(properties
		picture 63
	)

	(method (init)
		(super init:)
		(if (>= gAct 6)
			(gAddToPics add: Chalk)
		)
		(if
			(and
				(not (== gAct 2))
				(not (== gAct 6))
				(not (& gMustDos $0002))
			)
			(gAddToPics add: chair2)
		)
		(gAddToPics
			add: table chair1 BigDoll SmallDoll MedDoll Bear Poster
			eachElementDo: #init
			doit:
		)
		(self setFeatures: BigDoll chair2 chair1 table)
		(gEgo view: 0 loop: 1 posn: 200 153 illegalBits: -32768 init:)
		(switch gAct
			(2
				(self setRegions: 257) ; lillRead
			)
			(6
				(if (not (& gMustDos $0002))
					(self setRegions: 282) ; lillRead
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 63 0) ; "You are inside a leaky, old playhouse."
		)
		(if (& (gEgo onControl: 0) $0002)
			(gCurRoom newRoom: 14)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(DisposeScript 990)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return)
				)
			)
			(cond
				((Said 'look>')
					(cond
						(
							(or
								(Said '[<around,at][/room,dock]')
								(Said '/cabin<little')
								(Said '/playhouse')
								(Said '/cabin<play')
							)
							(Print 63 1) ; "You are inside a leaky old playhouse."
						)
						((Said '/door')
							(Print 63 2) ; "The little door leads outside."
						)
						((Said '/window')
							(Print 63 3) ; "Little round windows adorn the playhouse walls."
						)
						((Said '/wall')
							(if (>= gAct 5)
								(Print 63 4) ; "You notice a chalkboard with seven tally marks on it."
							else
								(event claimed: 0)
							)
						)
					)
				)
				((Said 'write,draw,erase/blackboard')
					(if (>= gAct 5)
						(Print 63 5) ; "You don't need to fool around with the chalkboard."
					else
						(event claimed: 0)
					)
				)
				((Said 'open/window')
					(Print 63 6) ; "There is no reason to open them."
				)
			)
		)
	)
)

(instance table of RPicView
	(properties
		y 133
		x 170
		view 163
		priority 2
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/nightstand'))
			(Print 63 7) ; "A small, child-sized table sits in one corner of the playhouse."
			(event claimed: 1)
		)
	)
)

(instance chair1 of RPicView
	(properties
		y 141
		x 205
		view 163
		cel 2
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/chair'))
			(Print 63 8) ; "Two little chairs accompany the small table."
			(event claimed: 1)
		)
	)
)

(instance chair2 of RPicView
	(properties
		y 141
		x 187
		view 163
		cel 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(Print 63 9) ; "Two little chairs accompamy the small table."
			(event claimed: 1)
		)
	)
)

(instance BigDoll of RPicView
	(properties
		y 144
		x 113
		view 163
		loop 1
	)

	(method (handleEvent event)
		(cond
			((Said 'play[/doll]')
				(Print 63 10) ; "You have better things to do, Laura!"
				(event claimed: 1)
			)
			((Said 'look/doll')
				(if (== gAct 2)
					(event claimed: 1)
				else
					(Print 63 11) ; "The dolls look like they've been hanging around here for a long time! You wonder who they used to belong to."
				)
			)
			((Said 'get/doll')
				(Print 63 12) ; "The dolls don't belong to you!"
			)
		)
	)
)

(instance SmallDoll of PV
	(properties
		y 141
		x 204
		z 10
		view 163
		loop 1
		cel 1
		priority 10
	)
)

(instance MedDoll of PV
	(properties
		y 138
		x 134
		view 163
		loop 1
		cel 2
	)
)

(instance Bear of PV
	(properties
		y 137
		x 150
		view 163
		loop 1
		cel 4
	)
)

(instance Poster of PV
	(properties
		y 139
		x 208
		view 163
		loop 2
		priority 2
	)
)

(instance Chalk of PV
	(properties
		y 139
		x 235
		view 163
		loop 2
		cel 1
	)
)

