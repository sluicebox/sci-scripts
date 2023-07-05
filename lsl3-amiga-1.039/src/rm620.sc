;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use Interface)
(use Follow)
(use Motion)
(use Game)
(use Actor)

(public
	rm620 0
)

(instance rm620 of Rm
	(properties
		picture 620
		east 630
	)

	(method (init)
		(super init:)
		(gAddToPics
			add: atpKQsign
			add: atpNumbers
			add: atpSalesman1
			add: atpSalesman2
			add: atpSalesman3
			add: atpSalesman4
			add: atpTarget1
			add: atpTarget2
			add: atpTarget3
			add: atpTarget4
			add: atpTaxi
			add: atpTombstone
			add: atpCauldron
			add: atpClothes
			add: atpMonolithBurger
			doit:
		)
		(NormalEgo)
		(gEgo posn: 12 188 init:)
		(NormalActor aLarry 0)
		(aLarry
			view: 720
			posn: 12 184
			setMotion: Follow gEgo 28
			setCycle: Walk
			init:
			loop: 0
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gMusic fade:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'get/flat')
				(Print 620 0) ; "Patti! Why would you want to get flat?"
			)
			((Said 'get')
				(Print 620 1) ; "This stuff is not why you're here. Keep moving."
			)
			((Said 'look>')
				(cond
					((Said '/prop')
						(Print 620 2) ; "This room is filled with leftover props from all the Sierra adventure games."
					)
					((Said '/flat')
						(Print 620 3) ; "Those flats must be title screens from old Sierra adventures."
					)
					((Said '/couple,man')
						(Print 620 4) ; "Those must be the insurance salesmen from "Space Quest II: Vohaul's Revenge.""
					)
					((Said '/cauldron')
						(Print 620 5) ; "That old tub dates from a very early Al Lowe game!"
					)
					((Said '/number')
						(Print 620 6) ; "You wonder how many numbers are in that box!"
					)
					((Said '/cloth')
						(Print 620 7) ; "Those were worn by the Murrys in those famous "Manhunter" games."
					)
					((Said '/gravestone')
						(Print 620 8 #mode 1 #at 10 -1 #width 290) ; "Here lies the remains of the King's Quest IV programming staff. 1987-1988"
					)
					((Said '/awning,column')
						(Print 620 9) ; "That big M doesn't stand for Marriage, Patti!"
					)
					((Said '/cab,auto')
						(Print 620 10) ; "So that's how they did that taxi cab scene in "Leisure Suit Larry in the Land of the Lounge Lizards!""
						(Print 620 11 #at -1 144) ; "(Pick up a copy today, at a software store near you!)"
					)
					((Said '[/drop,backstage,area]')
						(Print 620 12) ; "This must be Sierra's prop storage room. Look at all the old flats and backdrops in that rack."
					)
				)
			)
		)
	)
)

(instance atpKQsign of PV
	(properties
		y 107
		x 122
		view 620
		priority 7
		signal 16384
	)
)

(instance atpNumbers of PV
	(properties
		y 164
		x 177
		view 620
		cel 1
		priority 12
	)
)

(instance atpSalesman1 of PV
	(properties
		y 134
		x 7
		view 620
		cel 2
		priority 9
	)
)

(instance atpSalesman2 of PV
	(properties
		y 142
		x 16
		view 620
		cel 2
		priority 10
	)
)

(instance atpSalesman3 of PV
	(properties
		y 151
		x 10
		view 620
		cel 2
		priority 11
	)
)

(instance atpSalesman4 of PV
	(properties
		y 156
		x 26
		view 620
		cel 2
		priority 11
	)
)

(instance atpTarget1 of PV
	(properties
		y 158
		x 238
		view 620
		loop 1
		priority 11
	)
)

(instance atpTarget2 of PV
	(properties
		y 161
		x 241
		view 620
		loop 1
		priority 12
	)
)

(instance atpTarget3 of PV
	(properties
		y 164
		x 245
		view 620
		loop 1
		priority 12
	)
)

(instance atpTarget4 of PV
	(properties
		y 116
		x 278
		view 620
		loop 1
		priority 8
	)
)

(instance atpTaxi of PV
	(properties
		y 189
		x 106
		view 620
		loop 1
		cel 1
		priority 14
	)
)

(instance atpTombstone of PV
	(properties
		y 97
		x 23
		view 620
		loop 1
		cel 2
		priority 6
	)
)

(instance atpCauldron of PV
	(properties
		y 128
		x 58
		view 620
		loop 1
		cel 3
		priority 9
	)
)

(instance atpClothes of PV
	(properties
		y 137
		x 185
		view 620
		loop 1
		cel 4
		priority 9
	)
)

(instance atpMonolithBurger of PV
	(properties
		y 156
		x 297
		view 620
		loop 2
		priority 11
	)
)

(instance aLarry of Act
	(properties)
)

