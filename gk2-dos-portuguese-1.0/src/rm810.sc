;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm810 0
)

(local
	local0
)

(instance rm810 of ExitRoom ; "Herrenchiemsee Museum: Entry Room"
	(properties
		noun 25
		picture 8101
		south 800 ; bavMapRm
	)

	(method (init)
		(= local0 0)
		(gEgo
			posn: 103 305
			heading: 45
			sel_737:
			setScaler: Scaler 77 35 325 208
			init:
		)
		(super init: &rest)
		(if
			(or
				(not (gGk2Music handle:))
				(not (OneOf (gGk2Music number:) 810 811 812))
			)
			(gSoundManager play: 0 810 811 812)
		)
		(frauMiller init: setScript: sFidget)
		(if (and (== gPrevRoomNum 8110) (not (IsFlag 8))) ; topic810
			(gMessager say: 32 62 0 1) ; "(CLICK ON FRAU MILLER - NO DIALOGUE CURRENTLY AVAILABLE)I don't have anything to say to her at the moment."
		)
		(exitToDisplayRooms init:)
		(elizabethPainting init:)
		(ludwigPainting init:)
		(glassCase1 init:)
	)

	(method (cue)
		(gSoundManager stop:)
		(self newRoom: local0)
	)

	(method (newRoom newRoomNumber)
		(if (and (not local0) (OneOf newRoomNumber 8110 800)) ; topic810, bavMapRm
			(= local0 newRoomNumber)
			(gSoundManager fade: 0 10 10 1 self)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance sEnterMap of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 354 295 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitToDisplayRooms of ExitFeature
	(properties
		nsLeft 250
		nsTop 93
		nsRight 340
		nsBottom 204
		approachX 320
		BAD_SELECTOR 1
	)

	(method (doVerb)
		(if (gEgo has: 74) ; invCastleTicket
			(gCurRoom newRoom: 8122)
		else
			(gEgo heading: 45)
			(PlayScene 489)
		)
	)
)

(instance elizabethPainting of GKFeature
	(properties
		nsLeft 212
		nsTop 105
		nsRight 244
		nsBottom 148
		x 116
		y 50
		BAD_SELECTOR 8140
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (gEgo has: 74))) ; invCastleTicket
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (gEgo has: 74) ; invCastleTicket
				(gCurRoom newRoom: BAD_SELECTOR)
			else
				(gMessager say: 15 62 0 1) ; "(TRY TO GET PAST FRAU MILLER WITHOUT PAYING)I can't see the displays until I've gotten past the counter."
			)
		else
			(return 0)
		)
	)
)

(instance ludwigPainting of GKFeature
	(properties
		nsLeft 472
		nsTop 76
		nsRight 556
		nsBottom 177
		approachX 320
		approachY 264
		BAD_SELECTOR 8147
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (gEgo has: 74))) ; invCastleTicket
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (gEgo has: 74) ; invCastleTicket
				(gCurRoom newRoom: BAD_SELECTOR)
			else
				(gMessager say: 15 62 0 1) ; "(TRY TO GET PAST FRAU MILLER WITHOUT PAYING)I can't see the displays until I've gotten past the counter."
			)
		else
			(return 0)
		)
	)
)

(instance glassCase1 of GKFeature
	(properties
		nsLeft 6
		nsTop 84
		nsRight 172
		nsBottom 235
		approachX 130
		approachY 288
		x 100
		y 240
		BAD_SELECTOR 8141
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (gEgo has: 74))) ; invCastleTicket
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (gEgo has: 74) ; invCastleTicket
				(gCurRoom newRoom: BAD_SELECTOR)
			else
				(gMessager say: 15 62 0 1) ; "(TRY TO GET PAST FRAU MILLER WITHOUT PAYING)I can't see the displays until I've gotten past the counter."
			)
		else
			(return 0)
		)
	)
)

(instance frauMiller of Prop
	(properties
		approachX 354
		approachY 280
		x 414
		y 221
		view 20488
		signal 30601
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (proc11_15 8110)))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 8110) ; topic810
			)
			(10 ; invGraceWallet
				(if (IsFlag 276)
					(super doVerb: theVerb)
				else
					(PlayScene 490)
					(PlayScene 491)
					(SetFlag 276)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= ticks (Random 10 600))
			)
			(2
				(= state -1)
				(client setCycle: Beg self)
			)
		)
	)
)

