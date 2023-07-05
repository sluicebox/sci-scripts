;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1110)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	audRm 0
)

(instance audRm of ExitRoom ; "Wittelsbacher Theater: Auditorium"
	(properties
		noun 7
		picture 11102
	)

	(method (init &tmp temp0)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(switch gPrevRoomNum
			(11302
				(gEgo
					posn: 579 178
					BAD_SELECTOR: 225
					setScale:
					scaleX: 20
					scaleY: 20
					init:
				)
			)
			(11304
				(gEgo
					posn: 572 79
					BAD_SELECTOR: 225
					setScale:
					scaleX: 20
					scaleY: 20
					init:
				)
			)
			(else
				(gEgo
					posn: 38 313
					BAD_SELECTOR: 45
					setScaler: Scaler 88 22 381 223
					init:
				)
				(= south 11002)
			)
		)
		(super init: &rest)
		(if (not (IsFlag 755))
			(SetFlag 755)
			(PlayScene 831)
		)
		(switch gPrevRoomNum
			(11302
				(botEastExit init:)
				(seats init:)
			)
			(11304
				(topEastExit init:)
				(seats init:)
			)
			(else
				(= south 11002)
			)
		)
		(vGeorg init:)
		(vForeman init:)
		(stage init:)
	)
)

(instance vGeorg of Prop
	(properties
		modNum 1110
		x 259
		y 218
		view 20832
	)

	(method (init)
		(super init: &rest)
		(self setScript: FidgetScript)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(OneOf gPrevRoomNum 11302 11304)
					(and (not (IsFlag 742)) (IsFlag 756))
					(and (IsFlag 742) (IsFlag 748))
				)
			)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((OneOf gPrevRoomNum 11302 11304)
						(gMessager say: 1 62 0 0 0 1110) ; "(THEATER AUDITORIUM. CLICK ON SECOND LEVEL DOORS)There's no easy way to get there from inside the auditorium."
					)
					((and (not (IsFlag 742)) (not (IsFlag 756)))
						(SetFlag 756)
						(PlayScene 833)
					)
					((not (IsFlag 742))
						(gMessager say: 3 62 0 0 0 1110) ; "(CLICK ON GEORG--HAVEN'T SEEN TO DO LIST YET)I'm not sure what else to say to Georg."
					)
					((not (IsFlag 748))
						(SetFlag 748)
						(PlayScene 834)
					)
					(else
						(gMessager say: 4 0 0 0 0 1110) ; "(CLICK ON GEORG AFTER DISCUSSION 'DISTRACTION' WITH HIM)I've given Georg enough to worry about."
					)
				)
			)
			(131 ; invToDoList
				(cond
					((OneOf gPrevRoomNum 11302 11304)
						(gMessager say: 1 62 0 0 0 1110) ; "(THEATER AUDITORIUM. CLICK ON SECOND LEVEL DOORS)There's no easy way to get there from inside the auditorium."
					)
					((IsFlag 748)
						(gMessager say: 4 0 0 0 0 1110) ; "(CLICK ON GEORG AFTER DISCUSSION 'DISTRACTION' WITH HIM)I've given Georg enough to worry about."
					)
					(else
						(SetFlag 748)
						(PlayScene 834)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vForeman of Prop
	(properties
		modNum 1110
		x 43
		y 68
		view 22832
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(OneOf gPrevRoomNum 11302 11304)
					(and (not (IsFlag 742)) (IsFlag 757))
					(and (IsFlag 742) (IsFlag 749))
				)
			)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((OneOf gPrevRoomNum 11302 11304)
						(gMessager say: 1 62 0 0 0 1110) ; "(THEATER AUDITORIUM. CLICK ON SECOND LEVEL DOORS)There's no easy way to get there from inside the auditorium."
					)
					((and (not (IsFlag 742)) (not (IsFlag 757)))
						(SetFlag 757)
						(PlayScene 835)
					)
					((not (IsFlag 742))
						(gMessager say: 5 62 0 0 0 1110) ; "(DOUBTFUL)I'm not sure what else to say at the moment."
					)
					((not (IsFlag 749))
						(SetFlag 749)
						(PlayScene 836)
					)
					(else
						(gMessager say: 6 62 0 0 0 1110) ; "(VERY DISCOURAGED)There's nothing else I can say to him that will make any difference now."
					)
				)
			)
			(131 ; invToDoList
				(cond
					((OneOf gPrevRoomNum 11302 11304)
						(gMessager say: 1 62 0 0 0 1110) ; "(THEATER AUDITORIUM. CLICK ON SECOND LEVEL DOORS)There's no easy way to get there from inside the auditorium."
					)
					((IsFlag 749)
						(gMessager say: 6 62 0 0 0 1110) ; "(VERY DISCOURAGED)There's nothing else I can say to him that will make any difference now."
					)
					(else
						(SetFlag 749)
						(PlayScene 836)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stage of GKFeature
	(properties
		modNum 1110
		sightAngle 360
		x 248
		y 92
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 93 184 93 0 403 0 403 184
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 2 62 0 0 0 1110) ; "(TRY TO GET GRACE ON STAGE)I'm nervous enough. Thank God it's not ME on that stage tonight."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance seats of GKFeature
	(properties
		noun 1
		sightAngle 360
		x 358
		y 264
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 129 197 397 195 487 212 615 217 615 333 126 333 105 298 101 207
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance botEastExit of ExitFeature
	(properties
		x 552
		y 150
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 518 117 586 117 586 184 518 184
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance topEastExit of ExitFeature
	(properties
		x 550
		y 52
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 515 15 585 15 585 89 515 89
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

