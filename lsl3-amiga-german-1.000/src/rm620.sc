;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
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
		(atpKQsign init:)
		(atpNumbers init:)
		(atpSalesman1 init:)
		(atpSalesman2 init:)
		(atpSalesman3 init:)
		(atpSalesman4 init:)
		(atpTarget1 init:)
		(atpTarget2 init:)
		(atpTarget3 init:)
		(atpTarget4 init:)
		(atpTaxi init:)
		(atpTombstone init:)
		(atpCauldron init:)
		(atpClothes init:)
		(atpMonolithBurger init:)
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
			((Said 'get,get/flat')
				(Print 620 0) ; "Patti! Why would you want to get flat?"
			)
			((Said 'get,get')
				(Print 620 1) ; "This stuff is not why you're here. Keep moving."
			)
			((Said 'look,look>')
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
					((Said '[/drop,drop,backstage,area]')
						(Print 620 12) ; "This must be Sierra's prop storage room. Look at all the old flats and backdrops in that rack."
					)
				)
			)
		)
	)
)

(instance atpKQsign of PicView
	(properties
		x 122
		y 107
		priority 7
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpNumbers of PicView
	(properties
		x 177
		y 164
		cel 1
		priority 12
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpSalesman1 of PicView
	(properties
		x 7
		y 134
		cel 2
		priority 9
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpSalesman2 of PicView
	(properties
		x 16
		y 142
		cel 2
		priority 10
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpSalesman3 of PicView
	(properties
		x 10
		y 151
		cel 2
		priority 11
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpSalesman4 of PicView
	(properties
		x 26
		y 156
		cel 2
		priority 11
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpTarget1 of PicView
	(properties
		x 238
		y 158
		loop 1
		priority 11
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpTarget2 of PicView
	(properties
		x 241
		y 161
		loop 1
		priority 12
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpTarget3 of PicView
	(properties
		x 245
		y 164
		loop 1
		priority 12
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpTarget4 of PicView
	(properties
		x 278
		y 116
		loop 1
		priority 8
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpTaxi of PicView
	(properties
		x 106
		y 189
		loop 1
		cel 1
		priority 14
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpTombstone of PicView
	(properties
		x 23
		y 97
		loop 1
		cel 2
		priority 6
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpCauldron of PicView
	(properties
		x 58
		y 128
		loop 1
		cel 3
		priority 9
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpClothes of PicView
	(properties
		x 185
		y 137
		loop 1
		cel 4
		priority 9
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance atpMonolithBurger of PicView
	(properties
		x 297
		y 156
		loop 2
		priority 11
	)

	(method (init)
		(= view (LangSwitch 620 913))
		(super init:)
	)
)

(instance aLarry of Actor
	(properties)
)

