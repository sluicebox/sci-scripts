;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10102)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm10102 0
)

(local
	local0
	local1
	local2
)

(instance rm10102 of ExitRoom ; "Alt\99tting: Chapel"
	(properties
		modNum 1010
		noun 17
		picture 10102
	)

	(method (init)
		(self setRegions: 1030) ; dressRegion
		(if (IsFlag 724)
			(= picture 10103)
		)
		(Load rsVIEW 21798 21804 30800)
		(SetFlag 715)
		(= local1 0)
		(= local2 860)
		(if (IsFlag 713)
			(gEgo
				setCycle: 0
				setScript: 0
				BAD_SELECTOR: 6
				posn: 425 325
				setLoop: 8
				setCel: 7
				heading: 315
			)
		else
			(gEgo
				setCycle: 0
				setScript: 0
				BAD_SELECTOR: 6
				posn: 150 322
				setLoop: 8
				cel: 0
				heading: 90
			)
		)
		(gEgo
			setScaler: Scaler 95 95 333 315
			origStep: 2307
			setStep: 9 3
			setSpeed: 5
			init:
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 64 318 64 333 710 333 710 318
					yourself:
				)
		)
		(super init: &rest)
		(if (and (== gPrevRoomNum 1020) (IsFlag 713)) ; priestOfficeRm
			(ClearFlag 713)
			(SetFlag 714)
			(PlayScene 798)
			(gSoundManager play: 0 1011 1012 1013)
		)
		(gUser controls: 1)
		(cond
			((OneOf gPrevRoomNum 1010 24 6) ; altChapelRm, whereTo
				(gThePlane setRect: 0 15 860 349)
			)
			((== gPrevRoomNum 1020) ; priestOfficeRm
				(gThePlane setRect: -36 15 824 349)
				(= local1 -36)
				(= local2 824)
				(= local0 (gEgo x:))
			)
			(else
				(gThePlane setRect: global130 15 global131 349)
				(gEgo posn: global132 global133 cel: global134)
				(= local1 global130)
				(= local2 global131)
				(= local0 global132)
			)
		)
		(UpdatePlane gThePlane)
		(if (IsFlag 730)
			(ClearFlag 730)
			(PlayScene 800)
			(ClearFlag 726)
			(gEgo
				setCycle: 0
				setScript: 0
				posn: 688 330
				setLoop: 8
				setCel: 1
				heading: 270
			)
		)
		(cond
			((and (IsFlag 724) (IsFlag 726))
				(urnNiche init:)
				(everywhere init:)
				(gEgo hide:)
				(vChair
					view: 20804
					loop: 0
					cel: 0
					posn: 521 291
					init:
					setScript: (FidgetScript new:)
				)
				((gUser BAD_SELECTOR:) delete: vChair)
			)
			((IsFlag 724)
				(urnNiche init:)
				(gEgo show:)
				(vChair view: 30800 loop: 1 posn: 560 213 init:)
				(door init:)
				(windDoor init:)
			)
			(else
				(vChair init:)
			)
		)
		(if (IsFlag 724)
			(gEgo
				view: 21804
				loop: 0
				cel: 0
				posn: 720 330
				setScript: (FidgetScript new:)
			)
			(gUser canControl: 0)
			((gUser BAD_SELECTOR:) delete: vPriest)
			(vGiftBox view: 30800 init:)
			(vPriest view: 21798 init:)
		else
			(vPriest init:)
			(archway init:)
			(madonnaCloseup init:)
			(vGiftBox init:)
			(altar init:)
			(door init:)
			(windDoor init:)
			(urnNiche init:)
		)
	)

	(method (notify)
		(gGame handsOff:)
		(if (IsFlag 726)
			(PlayScene 800)
			(everywhere dispose:)
			((gUser BAD_SELECTOR:) add: vChair)
			(door init:)
			(windDoor init:)
		else
			(PlayScene 1800)
		)
		(gEgo
			setCycle: 0
			setScript: 0
			BAD_SELECTOR: 6
			posn: 688 330
			setLoop: 8
			setCel: 1
			setSpeed: 5
			origStep: 2307
			setStep: 9 3
			heading: 270
		)
		(vChair
			setCycle: 0
			setScript: 0
			view: 30780
			loop: 1
			posn: 568 218
			init:
		)
		(= picture 10102)
		(self drawPic: picture)
		(ClearFlag 730)
		(ClearFlag 726)
		(ClearFlag 724)
		(ClearFlag 721)
		(gGk2Sound fade: 0 10 10 1)
		(Lock 140 10102 0) ; WAVE
		(gSoundManager play: 0 1011 1012 1013)
		(archway init:)
		(madonnaCloseup init:)
		(altar init:)
		((gUser BAD_SELECTOR:) add: vPriest)
		(vPriest view: 20798)
		((gUser BAD_SELECTOR:) add: vGiftBox)
		(vGiftBox view: 30780)
		(gGame handsOn: 1)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (!= (gEgo x:) local0)
			(= local0 (gEgo x:))
			(= temp1 (gThePlane left:))
			(= temp2 (gThePlane right:))
			(if
				(and
					(= temp0
						(cond
							((< local0 (- 250 temp1))
								(gEgo xStep:)
							)
							((> local0 (- (- gScreenWidth temp1) 250))
								(- 0 (gEgo xStep:))
							)
							(else 0)
						)
					)
					(or
						(> (- gScreenWidth (+ local1 temp0)) 860)
						(> (+ local1 temp0) 0)
					)
				)
				0
			else
				(+= local1 temp0)
				(+= local2 temp0)
				(gThePlane setRect: local1 15 local2 349)
				(UpdatePlane gThePlane)
			)
			(= temp0 (Abs local1))
			(archway nsLeft: temp0 nsRight: (+ temp0 50))
			(+= temp0 gScreenWidth)
			(windDoor nsLeft: (- temp0 50) nsRight: temp0)
		)
		(super doit: &rest)
	)

	(method (newRoom)
		(= global130 (gThePlane left:))
		(= global131 (gThePlane right:))
		(= global132 (gEgo x:))
		(= global133 (gEgo y:))
		(= global134 (gEgo cel:))
		(super newRoom: &rest)
	)
)

(instance vPriest of Prop
	(properties
		modNum 1010
		sightAngle 360
		x 305
		y 291
		view 20798
	)

	(method (init)
		(super init: &rest)
		(self setScript: (FidgetScript new:))
	)

	(method (onMe)
		(if (IsFlag 724)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 4 62 0 0 0 1010) ; "(LOOK AT PRIEST)He's praying for me. Good. I need all the help I can get."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vChair of Prop
	(properties
		modNum 1010
		sightAngle 360
		x 568
		y 218
		view 30780
		loop 1
	)

	(method (onMe)
		(if (and (IsFlag 724) (IsFlag 726))
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 724)
					(SetFlag 726)
					(PlayScene 805)
					(door dispose:)
					(windDoor dispose:)
					(everywhere init:)
					((gUser BAD_SELECTOR:) delete: self)
					(gEgo setCycle: 0 setScript: 0 hide:)
					(gUser canControl: 0)
					(vChair
						view: 20804
						loop: 0
						cel: 0
						posn: 521 291
						setScript: (FidgetScript new:)
					)
				else
					(gMessager say: 13 62 0 0 0 1010) ; "(LOOK AT CHAIR UNDER URNS)If I could get away with moving that chair, I could reach the urns."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vGiftBox of View
	(properties
		modNum 1010
		sightAngle 360
		x 448
		y 199
		view 30780
	)

	(method (onMe)
		(if (IsFlag 724)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 722)
					(gMessager say: 9 62 0 0 0 1010) ; "(WORRIEDLY)I don't have another gift. Maybe I should just pray."
				else
					(gMessager say: 8 62 0 0 0 1010) ; "(LOOK AT BOX ON ALTAR)I think the box is for penitent offerings."
				)
			)
			(101 ; invSilverHeart
				(SetFlag 722)
				(gSoundManager fade: 0 10 10 1)
				(PlayScene 803)
				(gEgo put: 63) ; invSilverHeart
				(gEgo put: 63 posn: 531 318 setLoop: 8 cel: 0 heading: 90) ; invSilverHeart
				(SetFlag 721)
				(gSoundManager stop:)
				(Lock 140 10102 1) ; WAVE
				(gGk2Sound number: 10102 setLoop: -1 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance archway of ExitFeature
	(properties
		modNum 1010
		nsRight 113
		nsBottom 333
		sightAngle 360
		x 47
		y 167
		BAD_SELECTOR 6
	)

	(method (doVerb)
		(gEgo setMotion: PolyPath 40 (gEgo y:) westObj)
	)
)

(instance westObj of CueObj
	(properties)

	(method (cue)
		(gCurRoom newRoom: 1010) ; altChapelRm
	)
)

(instance madonnaCloseup of GKFeature
	(properties
		modNum 1010
		sightAngle 360
		x 321
		y 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 302 156 302 101 341 101 341 156
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10142)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance altar of GKFeature
	(properties
		modNum 1010
		sightAngle 360
		x 324
		y 191
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 267 171 384 171 384 198 530 193 530 263 114 297 114 209 267 201
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 722)
						(gSoundManager fade: 0 10 10 1)
						(PlayScene 802)
						(gEgo posn: 531 318 setLoop: 8 cel: 0 heading: 90)
						(SetFlag 721)
						(gSoundManager stop:)
						(Lock 140 10102 1) ; WAVE
						(gGk2Sound number: 10102 setLoop: -1 play:)
					)
					((IsFlag 723)
						(gMessager say: 6 62 0 0 0 1010) ; "(CLICK ON ALTAR BEFORE GIVING MADONNA A GIFT)I feel guilty about being here to get in Ludwig's urn. I hope she knows that I mean no disrespect."
					)
					(else
						(SetFlag 723)
						(PlayScene 801)
						(gEgo posn: 531 318 setLoop: 8 cel: 0 heading: 90)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance urnNiche of GKFeature
	(properties
		modNum 1010
		sightAngle 360
		x 570
		y 102
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 527 184 527 0 660 0 660 177
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 726)
					(gCurRoom newRoom: 10141)
				else
					(gCurRoom newRoom: 10115)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of GKFeature
	(properties
		noun 10
		modNum 1010
		nsLeft 700
		nsRight 860
		nsBottom 333
		sightAngle 360
		x 760
		y 166
	)

	(method (doVerb)
		(if (and (IsFlag 721) (not (IsFlag 724)))
			(gEgo setMotion: PolyPath 691 326 eastObj1)
		else
			(eastObj doVerb: 62)
		)
	)
)

(instance windDoor of ExitFeature
	(properties
		modNum 1010
		nsBottom 333
		sightAngle 360
		x 760
		y 166
		BAD_SELECTOR 2
	)

	(method (doVerb)
		(gEgo setMotion: PolyPath 691 326)
	)
)

(instance eastObj1 of CueObj
	(properties)

	(method (cue)
		(eastObj doVerb: 62)
	)
)

(instance eastObj of Feature
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 724)
						(gMessager say: 11 62 0 0 0 1010) ; "(CLICK ON OPEN DOOR, LIGHTS OUT)Someone else will shut it!"
					)
					((IsFlag 721)
						(if (not (IsFlag 725))
							(SetFlag 725)
							(Load rsPIC 10103)
							(gMessager say: 12 62 0 0 doorCue 1010) ; "(NERVOUS, ABOUT TO OPEN CHAPEL DOOR AND LET IN WIND)I hope this works."
						else
							(doorCue cue:)
						)
					)
					(else
						(gMessager say: 10 62 0 0 0 1010) ; "(LOOK AT DOOR IN INNER SHRINE, THOUGHTFUL)I think that door leads outside."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorCue of CueObj
	(properties)

	(method (cue)
		((gUser BAD_SELECTOR:) delete: vPriest)
		(vPriest view: 21798)
		((gUser BAD_SELECTOR:) delete: vGiftBox)
		(vGiftBox view: 30800)
		(vChair view: 30800 loop: 1 posn: 560 213)
		(archway dispose:)
		(madonnaCloseup dispose:)
		(altar dispose:)
		(SetFlag 724)
		(gEgo
			view: 21804
			loop: 0
			cel: 0
			posn: 720 330
			setScript: (FidgetScript new:)
		)
		(gCurRoom drawPic: 10103 -1 1)
		(gGk2Sound fade: 0 10 10 1)
		(Lock 140 10102 0) ; WAVE
		(PlayScene 804)
		(Lock 140 10103 1) ; WAVE
		(gGk2Sound number: 10103 setLoop: -1 play: 0 0 fade: 63 10 10 0)
		(gUser canControl: 0)
		((ScriptID 1030 1) setReal: (ScriptID 1030 1) 20) ; engelTimer, engelTimer
	)
)

(instance everywhere of GKFeature
	(properties
		modNum 1010
		sightAngle 360
		x 535
		y 166
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 216 0 854 0 855 332 216 332
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(ClearFlag 726)
				(PlayScene 1805)
				((gUser BAD_SELECTOR:) add: vChair)
				(vChair
					setCycle: 0
					setScript: 0
					view: 30800
					loop: 1
					posn: 560 213
				)
				(door init:)
				(windDoor init:)
				(gEgo
					view: 21804
					loop: 0
					cel: 0
					posn: 720 330
					setScript: (FidgetScript new:)
				)
				(gUser canControl: 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

