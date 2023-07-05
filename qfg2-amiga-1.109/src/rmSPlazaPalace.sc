;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Plaza)
(use KattaMerchant)
(use Polygon)
(use LoadMany)
(use Avoid)
(use Motion)
(use Actor)
(use System)

(public
	rmSPlazaPalace 0
)

(local
	sashMsg1
	sashMsg2
	talkFlg
	givenPin
	bargainingForPin
	[tiramSpecList 6] = [36 '//carpet,merchandise' 37 '//carpet<magic' 0 0]
	[sashananSpecList 10] = [-2 '//gem,gem,necklace,bracelet,gold,silver,merchandise' -1 '//pin,sapphire' 42 '//cost' 43 '//gift' 0 0]
	[entranceSpeeches 25] = [8 53 335 0 335 1 2 51 335 2 335 3 4 52 335 4 335 5 6 54 335 6 335 7 -1]
)

(instance sayEntranceSpeeches of Script
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(for ((= i 0)) (!= [entranceSpeeches i] -1) ((+= i 6))
					(if
						(and
							(== gElementalState [entranceSpeeches i])
							(not (IsFlag [entranceSpeeches (+ i 1)]))
						)
						(= talkFlg [entranceSpeeches (+ i 1)])
						(Say
							tiram
							self
							[entranceSpeeches (+ i 2)]
							[entranceSpeeches (+ i 3)]
						)
						(= sashMsg1 [entranceSpeeches (+ i 4)])
						(= sashMsg2 [entranceSpeeches (+ i 5)])
						(break)
					)
				)
				(if (== [entranceSpeeches i] -1)
					(self dispose:)
				)
			)
			(1
				(Say sashanan self sashMsg1 sashMsg2)
			)
			(2
				(if (== talkFlg 53)
					(self setScript: givePin self)
				else
					(self cue:)
				)
			)
			(3
				(SetFlag talkFlg)
				(self dispose:)
			)
		)
	)
)

(instance givePin of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say sashanan self 335 8) ; "We Katta tried to think of some way to say how much we were grateful. Please accept this gift of a sapphire pin.  May it do you good."
			)
			(1
				(gEgo setAvoider: Avoid setMotion: MoveTo 212 123 self)
			)
			(2
				(Face gEgo sashanan 1)
				(= seconds 2)
			)
			(3
				(SolvePuzzle 627 5)
				(gEgo setAvoider: 0 get: 27) ; SapphPin
				(SetFlag 148)
				(HighPrint 335 9) ; "You take the sapphire pin and place it through your lapel."
				(if [gEgoStats 9] ; pick locks
					(HighPrint 335 10) ; "The shape of the pin stirs an old memory. You recall how you used to practice with such simple pins when first learning how to pick locks. You decide not to mention this to the honest merchant."
				)
				(= givenPin 1)
				(self dispose:)
			)
		)
	)
)

(instance rmSPlazaPalace of Plaza
	(properties
		north 704
		east 704
		south 240
		west 704
		topExit 4
		bottomExit 2
		rightExit 1
		leftExit 3
	)

	(method (init)
		(LoadMany rsVIEW 335 310 350 300 301)
		(self
			addObstacle:
				(poly1
					init: 0 161 0 0 319 0 319 161 305 161 277 132 234 132 221 132 183 101 171 101 172 10 148 10 147 57 147 101 114 112 77 142 32 158
					yourself:
				)
		)
		(super init:)
		(InitAddToPics westSign rightWindow leftWindow mosaic)
		(cond
			((and (<= 0 gTimeODay 4) (not (IsElementalInRoom)))
				(sashanan init:)
				(tiram init:)
				(= entranceScript sayEntranceSpeeches)
			)
			((== gElementalState 3)
				((ScriptID 241 0) init:) ; airElemental
			)
		)
	)
)

(instance sashanan of KattaMerchant
	(properties
		x 232
		y 108
		description {Sashanan, the jewelry merchant}
		lookStr {It is Sashanan, the jewelry merchant.}
		myName '//sashanan,catperson,(merchant[<gem,gem,necklace,bracelet])'
		title {Sashanan:}
		isSeated 0
		isOnLeft 0
		clothesColor 4
	)

	(method (init)
		(super init:)
		(InitAddToPics jewelryStand jewelry)
	)

	(method (atIndividualSpec which)
		(return [sashananSpecList which])
	)

	(method (handleEvent event &tmp wasBargaining)
		(if (== (event type:) evSAID)
			(= wasBargaining bargainingForPin)
			(= bargainingForPin 0)
		else
			(= wasBargaining 0)
		)
		(cond
			((Said 'ask//carpet')
				(Say self 335 11) ; "For that you must talk to Tiram, across the Plaza."
			)
			((Said 'ask//tiram')
				(Say self 335 12) ; "Tiram is across the plaza."
			)
			(wasBargaining
				(if (or (Said 'yes') (Said 'bargain/pin') (Said 'bargain//pin'))
					(HighPrint 335 13) ; "After trying to make a deal for some twenty minutes, you realize that you really don't need the pin anyway, and certainly can't afford it."
				)
				(Say self 335 14) ; "Such a shame that we could not make a deal. The pin was truly perfect for you."
				(event claimed: 1)
			)
			((and givenPin (not (IsFlag 148)) (Said 'thank'))
				(SetFlag 148)
				(gCurRoom setScript: thanksForPin)
			)
			((Said 'buy,bargain/gem,gem,necklace,bracelet')
				(self showText: -2)
			)
			((or (Said 'buy,bargain/pin') (Said 'bargain//pin'))
				(if (IsFlag 148)
					(Say self 335 15) ; "I have no other suitable pins, Effendi."
				else
					(Say self 335 16) ; "It has a value of 500 dinars. Would you care to bargain?"
					(= bargainingForPin 1)
				)
			)
			((Said 'get,get,look,look/pin')
				(if (IsFlag 148)
					(HighPrint 335 17) ; "No other pin is as fine as the one you already obtained from Sashanan."
				else
					(HighPrint 335 18) ; "There is a beautiful sapphire pin in Sashanan's display case."
				)
			)
			((super handleEvent: event) 0)
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(HighPrint 335 19) ; "The Plaza of the Palace bustles with the activities of the local merchants."
			)
		)
		(event claimed:)
	)

	(method (showText what)
		(switch what
			(-2
				(if (gEgo has: 27) ; SapphPin
					(super showText: 38)
				else
					(super showMany: 38 39)
				)
			)
			(-1
				(if (gEgo has: 27) ; SapphPin
					(super showText: 41)
				else
					(super showText: 40)
				)
			)
			(else
				(super showText: what)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (not (& (gEgo illegalBits:) $1000))
			(gEgo illegalBits: (| (gEgo illegalBits:) $1000))
		)
		(if (gCurRoom script:)
			(return)
		)
		(if (and (not (IsFlag 50)) (< (gEgo distanceTo: sashanan) 50))
			(Say self 335 20) ; "Jewelry of the finest gems inlaid in rings of gold and silver, necklaces of beautiful stones, things of beauty which will last forever--all of which I sell."
			(SetFlag 50)
		)
	)

	(method (showSelf)
		(Say self 335 21) ; "I am called Sashanan, the "Diamond of the Desert.""
	)
)

(instance jewelryStand of PicView
	(properties
		x 242
		y 123
		noun '/stand[<gem,gem,necklace,bracelet]'
		description {the jewelry stand of Sashanan}
		lookStr {It is Sashanan's jewelry stand.}
		view 335
		loop 1
		signal 16384
	)
)

(instance jewelry of PicView
	(properties
		x 228
		y 105
		noun '/gem,gem,necklace,bracelet'
		description {jewelry}
		lookStr {It is very lovely jewelry, indeed.}
		view 335
		loop 1
		cel 1
		priority 7
		signal 16400
	)
)

(instance tiram of KattaMerchant
	(properties
		x 81
		y 120
		description {Tiram, the carpet merchant}
		lookStr {It is Tiram, the carpet merchant.}
		myName '//tiram,catperson,(merchant[<carpet])'
		title {Tiram:}
		clothesColor 3
	)

	(method (init)
		(super init:)
		(InitAddToPics rugStand pole cart)
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//family')
				(self showSelf:)
			)
			((Said 'ask//gem,gem,necklace,bracelet,gold,silver')
				(Say self 335 22) ; "For that you must talk to Sashanan, across the Plaza."
			)
			((Said 'ask//sashanan')
				(Say self 335 23) ; "Sashanan is across the plaza."
			)
			((or (Said 'buy,bargain/carpet') (Said 'buy,bargain//carpet'))
				(Say self 335 24) ; "Forgive me, but Shema would be most displeased if I sold you something which you could not easily carry and for which you have no real use."
			)
			((super handleEvent: event) 0)
		)
	)

	(method (doit)
		(super doit:)
		(if (not (& (gEgo illegalBits:) $2000))
			(gEgo illegalBits: (| (gEgo illegalBits:) $2000))
		)
		(if (gCurRoom script:)
			(return)
		)
		(if (and (not (IsFlag 49)) (< (gEgo distanceTo: tiram) 60))
			(Say self 335 25) ; "The finest of carpets in all of the land I have for your perusal, Hero of the North."
			(SetFlag 49)
		)
	)

	(method (atIndividualSpec which)
		(return [tiramSpecList which])
	)

	(method (showSelf)
		(Say self 335 26) ; "I am Tiram, and all my family makes the carpets."
	)
)

(instance thanksForPin of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SkillUsed 13 40) ; communication
				(SkillUsed 14 50) ; honor
				(SayThanks sashanan self 335 27)
			)
			(1
				(Say tiram self 335 28) ; "It is a symbol by which all Katta who look upon it will know you are a true hero."
			)
			(2
				(Say sashanan self 335 29) ; "Only a friend can see it upon you."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance rugStand of PicView
	(properties
		x 65
		y 129
		noun '/carpet,stand[<carpet]'
		description {the carpet stand of Tiram}
		lookStr {Tiram's carpet stand displays fine rugs of Shapeir.}
		view 335
		signal 16384
	)
)

(instance pole of PicView
	(properties
		x 94
		y 113
		shiftClick 0
		view 335
		cel 2
		priority 8
		signal 16400
	)
)

(instance cart of PicView
	(properties
		x 110
		y 101
		noun '/cart,barrow'
		description {the carpet merchant's cart}
		lookStr {It is Tiram's cart, filled with carpets.}
		view 335
		cel 1
		signal 16384
	)
)

(instance westSign of PicView
	(properties
		x 160
		y 46
		shiftClick 0
		view 310
		loop 2
		cel 2
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance rightWindow of PicView
	(properties
		x 252
		y 51
		noun '/window'
		description {a window}
		lookStr {There is an exceptional view of the Plaza from the window.}
		view 300
		loop 2
		cel 2
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance leftWindow of PicView
	(properties
		x 69
		y 51
		noun '/window'
		description {a window}
		lookStr {This window has exceptional southern exposure, depending on which way it's facing.}
		view 300
		loop 1
		cel 2
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance mosaic of PicView
	(properties
		x 159
		y 189
		noun '/mosaic,tile'
		description {the tile mosaic}
		lookStr {The mosaic tile work is exceptionally well-crafted.}
		view 301
		loop 8
		cel 1
		priority 0
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

