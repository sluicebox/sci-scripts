;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Polygon)
(use Feature)
(use Cursor)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	marienRm 0
)

(local
	local0
	local1
	local2
	local3 = 1920
	local4 = 200
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 100)) (> temp0 0) ((-= temp0 1))
		(Palette 2 16 256 temp0) ; PalIntensity
		(gCast eachElementDo: #doit)
		(FrameOut)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 100) ((+= temp0 1))
		(Palette 2 16 256 temp0) ; PalIntensity
		(gCast eachElementDo: #doit)
		(FrameOut)
	)
)

(instance marienRm of GK2Room ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4003
	)

	(method (init &tmp temp0)
		(= local1 0)
		(= local2 local3)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 39 306 39 308 1866 308 1866 306
					yourself:
				)
		)
		(efLeftExit init:)
		(efRightExit init:)
		(efUbahn init: approachVerbs: 62) ; Do
		(fGlockenspiel init:)
		(fCornerStatue init:)
		(fPlaque init:)
		(fEyeGlassShop init:)
		(fBookStore init:)
		(fClockShop init:)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 4002 4004 4020 200) ; MunichMapRm
			(Lock 140 402 0) ; WAVE
			(Lock 140 400 0) ; WAVE
			(Lock 140 401 1) ; WAVE
			(gGk2Music setLoop: -1 number: 401 play: setVol: 38)
		)
		(gEgo
			BAD_SELECTOR: 8
			setScale: 0
			cel:
				(switch gPrevRoomNum
					(4002 1)
					(4004 0)
					(4012 3)
					(200 1) ; MunichMapRm
					(else 2)
				)
			x:
				(switch gPrevRoomNum
					(4002 1865)
					(4004 40)
					(4012 970)
					(4013 536)
					(4020 536)
					(4045 1104)
					(4046 60)
					(4047 720)
					(4048 1400)
					(200 66) ; MunichMapRm
					(else 40)
				)
			y: 307
			init:
		)
		(User controls: 1)
		(= local1 (Min 0 (- (/ gScreenWidth 2) (gEgo x:))))
		(= local2 (- local3 local1))
		(if (> (- gScreenWidth local1) local3)
			(= local1 (- gScreenWidth local3))
			(= local2 (- gScreenWidth local1))
		)
		(gThePlane setRect: local1 15 local2 349)
		(UpdatePlane gThePlane)
		(= temp0 (Abs local1))
		(westEdgeExit nsLeft: temp0 nsRight: (+ temp0 50) init:)
		(westAllExit nsLeft: temp0 nsRight: (+ temp0 50) init:)
		(+= temp0 gScreenWidth)
		(eastEdgeExit nsRight: temp0 nsLeft: (- temp0 50) init:)
		(eastAllExit nsRight: temp0 nsLeft: (- temp0 50) init:)
		(if (> (gGame detailLevel:) 5)
			(self setScript: sExtrasScript)
		)
		(if (and (== gChapter 1) (not (IsFlag 438)))
			(SetFlag 438)
			(PlayScene 1059)
		)
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
							((< local0 (- local4 temp1))
								(gEgo xStep:)
							)
							((> local0 (- (- gScreenWidth temp1) local4))
								(- 0 (gEgo xStep:))
							)
							(else 0)
						)
					)
					(or
						(> (- gScreenWidth (+ local1 temp0)) local3)
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
			(westEdgeExit nsLeft: temp0 nsRight: (+ temp0 50))
			(westAllExit nsLeft: temp0 nsRight: (+ temp0 50))
			(+= temp0 gScreenWidth)
			(eastEdgeExit nsRight: temp0 nsLeft: (- temp0 50))
			(eastAllExit nsRight: temp0 nsLeft: (- temp0 50))
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 200) ; MunichMapRm
			(gGk2Music stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sExtrasScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 20))
			)
			(1
				(aBozo init:)
				(= seconds (Random 20 40))
			)
			(2
				(aFatGuy init:)
				(= seconds (Random 30 50))
			)
			(3
				(aBabe init:)
				(= seconds (Random 40 60))
			)
		)
	)
)

(instance sFatScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aFatGuy cel: 0 loop: 0 posn: 8 292 setCycle: End self)
			)
			(1
				(aFatGuy
					setLoop: 1 1
					cel: 1
					posn: 42 307
					setCycle: Walk
					setMotion: MoveTo 2040 307 self
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sBabeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aBabe cel: 0 loop: 0 posn: 50 288 setCycle: End self)
			)
			(1
				(aBabe
					setLoop: 1 1
					cel: 1
					posn: 60 302
					setCycle: Walk
					setMotion: MoveTo 2040 302 self
				)
			)
			(2
				(aBabe setLoop: 2 1 setMotion: MoveTo 64736 302 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sBozoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aBozo cel: 0 loop: 0 posn: 46 292 setCycle: End self)
			)
			(1
				(aBozo
					setLoop: 1 1
					cel: 1
					posn: 60 304
					setCycle: Walk
					setMotion: MoveTo 2020 304 self
				)
			)
			(2
				(aBozo setLoop: 2 1 setMotion: MoveTo -200 304 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance aFatGuy of Actor
	(properties
		modNum 400
		view 82
		signal 30753
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setScript: sFatScript)
	)

	(method (doVerb theVerb)
		(aBozo doVerb: theVerb)
	)
)

(instance aBabe of Actor
	(properties
		modNum 400
		view 83
		signal 30753
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setScript: sBabeScript)
	)

	(method (doVerb theVerb)
		(aBozo doVerb: theVerb)
	)
)

(instance aBozo of Actor
	(properties
		modNum 400
		view 84
		signal 30753
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setScript: sBozoScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 26 62 0 3 0 400) ; "(TRY TO TALK TO PEDESTRIANS)Germans. Always in a hurry."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fCornerStatue of Feature
	(properties
		nsLeft 54
		nsTop 120
		nsRight 96
		nsBottom 204
		approachX 60
		approachY 304
		x 60
		y 120
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62 4) ; Do, ???
	)

	(method (doVerb)
		(gCurRoom newRoom: 4046)
	)
)

(instance fClockShop of Feature
	(properties
		nsLeft 500
		nsTop 201
		nsRight 604
		nsBottom 264
		approachX 532
		approachY 304
		x 540
		y 252
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)

	(method (doVerb)
		(gCurRoom newRoom: 4013)
	)
)

(instance fEyeGlassShop of Feature
	(properties
		nsLeft 680
		nsTop 177
		nsRight 788
		nsBottom 297
		approachX 688
		approachY 304
		x 788
		y 252
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)

	(method (doVerb)
		(gCurRoom newRoom: 4047)
	)
)

(instance fBookStore of Feature
	(properties
		nsLeft 1344
		nsTop 204
		nsRight 1450
		nsBottom 297
		approachX 1420
		approachY 304
		x 1400
		y 264
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)

	(method (doVerb)
		(gCurRoom newRoom: 4048)
	)
)

(instance fPlaque of Feature
	(properties
		nsLeft 1084
		nsTop 201
		nsRight 1124
		nsBottom 225
		approachX 1104
		approachY 304
		x 1104
		y 216
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)

	(method (doVerb)
		(gCurRoom newRoom: 4045)
	)
)

(instance fGlockenspiel of ExitFeature
	(properties
		nsLeft 920
		nsTop 19
		nsRight 1036
		nsBottom 288
		approachX 972
		approachY 318
		x 972
		y 252
		BAD_SELECTOR 4012
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)

	(method (doVerb)
		(gGame handsOff:)
		(PlayScene 63 0 4012) ; rm4012
	)
)

(instance efLeftExit of ExitFeature
	(properties
		nsTop 132
		nsRight 60
		nsBottom 295
		approachX 40
		approachY 304
		x 40
		y 252
		BAD_SELECTOR 4004
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)
)

(instance efRightExit of ExitFeature
	(properties
		nsLeft 1840
		nsTop 283
		nsRight 1920
		nsBottom 326
		approachX 1900
		approachY 304
		x 1920
		y 304
		BAD_SELECTOR 4002
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62) ; Do
	)
)

(instance efUbahn of ExitFeature
	(properties
		approachX 66
		approachY 315
		BAD_SELECTOR 4
	)

	(method (init)
		(self createPoly: 82 266 175 263 177 319 80 320)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 1062 0 200) ; MunichMapRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eastEdgeExit of ExitFeature
	(properties
		nsTop 170
		nsBottom 349
		sightAngle 0
		approachX 1865
		approachY 307
		x 2000
		y 307
		BAD_SELECTOR 4002
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62 44) ; Do, invAddressedPackage
	)
)

(instance westEdgeExit of ExitFeature
	(properties
		nsTop 170
		nsBottom 349
		sightAngle 0
		approachX 40
		approachY 307
		y 307
		BAD_SELECTOR 4004
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 62 44) ; Do, invAddressedPackage
	)
)

(instance eastAllExit of ExitFeature
	(properties
		nsBottom 100
		x 2000
		y 307
	)

	(method (onMe)
		(if (== local1 64258)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (setCursor param1 &tmp temp0 temp1)
		(= temp1 (param1 loop:))
		(= temp0 (param1 view:))
		(param1 view: 998)
		(if (> gMouseY 200)
			(param1 loop: 0)
			(param1 cel: BAD_SELECTOR)
		else
			(param1 loop: 2)
			(param1 cel: 1)
		)
		(if (or (!= temp0 998) (!= temp1 (param1 loop:)))
			(param1 init:)
		)
		(return 1)
	)

	(method (doVerb)
		(GKHotCursor BAD_SELECTOR:)
		(gGame handsOff:)
		(localproc_0)
		(gEgo setMotion: 0 posn: 1865 307 loop: 0 show:)
		(= local1 64258)
		(= local2 1842)
		(gThePlane setRect: 64258 15 1842 349)
		(UpdatePlane gThePlane)
		(localproc_1)
		(FrameOut)
		(gGame handsOn:)
	)
)

(instance westAllExit of ExitFeature
	(properties
		nsBottom 100
		y 307
	)

	(method (onMe)
		(if (== local1 0)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (setCursor param1 &tmp temp0 temp1)
		(= temp1 (param1 loop:))
		(= temp0 (param1 view:))
		(param1 view: 998)
		(if (> gMouseY 200)
			(param1 loop: 0)
			(param1 cel: BAD_SELECTOR)
		else
			(param1 loop: 2)
			(param1 cel: 0)
		)
		(if (or (!= temp0 998) (!= temp1 (param1 loop:)))
			(param1 init:)
		)
		(return 1)
	)

	(method (doVerb)
		(GKHotCursor BAD_SELECTOR:)
		(gGame handsOff:)
		(localproc_0)
		(gEgo setMotion: 0 posn: 40 307 loop: 1 show:)
		(= local1 0)
		(= local2 1920)
		(gThePlane setRect: 0 15 1920 349)
		(UpdatePlane gThePlane)
		(localproc_1)
		(FrameOut)
		(gGame handsOn:)
	)
)

