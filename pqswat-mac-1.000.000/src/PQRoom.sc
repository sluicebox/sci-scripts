;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use ExitButton)
(use Button)
(use HotSpot)
(use Plane)
(use Sound)
(use Game)
(use Actor)
(use System)

(local
	local0
	local1
)

(class PQRoom of Room
	(properties
		style 0
		planeLeft 0
		planeTop 0
		planeRight 640
		planeBottom 358
		infoRoomSignal 0
	)

	(method (init)
		(= global137 0)
		(if
			(and
				(== planeBottom 358)
				(OneOf gCurRoomNum 8 10 15 25 30 20 100 13 21 40 72) ; sierraLogo, titleScreen, mainMenu, prevCareerId, prevCareerCallups, newCareer, openToon, funeralRoom
			)
			(= planeBottom 480)
		)
		(super init: &rest)
		(FrameOut)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if
			(and
				(== exitStyle -1)
				(or
					(OneOf gCurRoomNum 300 200 130 185 190 8) ; profiles, sierraLogo
					(OneOf newRoomNumber 300 200 130 185 190 8) ; profiles, sierraLogo
					(OneOf newRoomNumber 8 10 15 25 30 20 100 13 21 40 72) ; sierraLogo, titleScreen, mainMenu, prevCareerId, prevCareerCallups, newCareer, openToon, funeralRoom
					(OneOf gCurRoomNum 8 10 15 25 30 20 100 13 21 40 72) ; sierraLogo, titleScreen, mainMenu, prevCareerId, prevCareerCallups, newCareer, openToon, funeralRoom
				)
			)
			(Palette 2 0 254 0) ; PalIntensity
			(FrameOut)
		else
			(Palette 2 42 254 0) ; PalIntensity
			(FrameOut)
		)
		(if (and (IsFlag 109) (gCast contains: (ScriptID 16 1))) ; descView
			((ScriptID 16 1) dispose:) ; descView
		)
		(FrameOut)
		(if (gTheHotspotList size:)
			(if global129
				(= temp0 global129)
				(= global129 0)
				(temp0 setCursor: 0)
			)
			(gTheHotspotList eachElementDo: #perform HotspotRemoveCheck)
		)
		(= global129 0)
		(gGame handsOff:)
		(= global124 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (drawPic param1)
		(super drawPic: param1 &rest)
		(self overlay:)
	)

	(method (overlay)
		(gThePlane setRect: planeLeft planeTop planeRight planeBottom priority: 4)
		(UpdatePlane gThePlane)
	)

	(method (travelState)
		(return 1)
	)

	(method (displayTravel &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
		(= temp0 (= temp1 (= temp2 (= local0 0))))
		(= temp7 (= temp8 (= temp10 0)))
		(= temp5 (CelWide (backView view:) (backView loop:) (backView cel:)))
		(= temp6 (CelHigh (backView view:) (backView loop:) (backView cel:)))
		(= temp0 gCast)
		((= temp1 (Plane new:))
			setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
			back: 0
			picture: -2
			priority: 500
			init:
			addCast: (= gCast (Cast new:))
		)
		(= temp3 (Set new:))
		(temp3 add: backView)
		(if (& infoRoomSignal $0004)
			(temp3
				add: (tacticsButn active: (gCurRoom travelState: 4) yourself:)
			)
		)
		(if (& infoRoomSignal $0002)
			(temp3
				add: (profilesButn active: (gCurRoom travelState: 2) yourself:)
			)
		)
		(if (& infoRoomSignal $0010)
			(temp3
				add: (academyButn active: (gCurRoom travelState: 16) yourself:)
			)
		)
		(if (& infoRoomSignal $0020)
			(temp3
				add: (angelesButn active: (gCurRoom travelState: 32) yourself:)
			)
		)
		(if (& infoRoomSignal $0400)
			(temp3
				add: (combatButn active: (gCurRoom travelState: 1024) yourself:)
			)
		)
		(if (& infoRoomSignal $0040)
			(temp3
				add:
					(sniperBriefButn
						active: (gCurRoom travelState: 64)
						yourself:
					)
			)
		)
		(if (& infoRoomSignal $0080)
			(temp3
				add:
					(assaulterBriefButn
						active: (gCurRoom travelState: 128)
						yourself:
					)
			)
		)
		(if (& infoRoomSignal $0200)
			(temp3
				add:
					(prevCareerButn
						active: (gCurRoom travelState: 512)
						yourself:
					)
			)
		)
		(if (& infoRoomSignal $0001)
			(temp3 add: (metroButn active: (gCurRoom travelState: 1) yourself:))
		)
		(if (& infoRoomSignal $0008)
			(temp3 add: (travelButn active: (gCurRoom travelState: 8) yourself:))
		)
		(if (& infoRoomSignal $0100)
			(temp3
				add:
					(controlPanelButn
						active: (gCurRoom travelState: 256)
						yourself:
					)
			)
		)
		(temp3 add: mainMenuButn cancelButn quitButn)
		(for ((= temp11 1)) (< temp11 (temp3 size:)) ((++ temp11))
			(= temp13 (temp3 at: temp11))
			(+= temp8 (CelHigh (temp13 view:) (temp13 loop:) (temp13 cel:)))
		)
		(= temp13 0)
		(= temp12 (/ (- (- temp6 28) temp8) (temp3 size:)))
		(= temp10 19)
		(backView init:)
		(for ((= temp11 1)) (< temp11 (temp3 size:)) ((++ temp11))
			(= temp13 (temp3 at: temp11))
			(temp13
				posn: (+ (backView x:) 24) (+ (backView y:) temp10 temp12)
				init: gCast gFtrInitializer
			)
			(UpdateScreenItem temp13)
			(+=
				temp10
				(+ temp12 (CelHigh (temp13 view:) (temp13 loop:) (temp13 cel:)))
			)
		)
		(temp3 release: dispose:)
		(FrameOut)
		(= temp2 (gGame setCursor:))
		(gNormalCursor view: 999 loop: 0)
		(gGame setCursor: gNormalCursor 1)
		(while ((= temp14 (Event new:)) type:)
			(temp14 dispose:)
		)
		(temp14 dispose:)
		(= local1 0)
		(while (not local0)
			(if ((= temp14 (Event new: evMOUSE)) type:)
				(gCast eachElementDo: #handleEvent temp14)
			)
			(temp14 dispose:)
		)
		(Palette 1 999) ; PalLoad
		(gCast dispose:)
		(= gCast temp0)
		(temp1 dispose:)
		(if (== gNewRoomNum gCurRoomNum)
			(gSwatInterface setCursor:)
		)
		(if (gCast contains: (ScriptID 50 0)) ; PactTimer
			((ScriptID 50 0) pause: 0) ; PactTimer
		)
		(if local1
			(switch local1
				(1
					(if (not (OneOf gCurRoomNum 8 10 15 25 30 20)) ; sierraLogo, titleScreen, mainMenu, prevCareerId, prevCareerCallups, newCareer
						(switch (proc4_9)
							(1
								(gGame panelObj: gGame panelSelector: 82)
								(= global123 1)
							)
							(else
								(gGame restart:)
							)
						)
					else
						(gGame restart:)
					)
				)
			)
		)
	)

	(method (getInvItem))

	(method (doVerb theVerb &tmp temp0)
		(if (and (== modNum -1) (== (= modNum (gCurRoom modNum:)) -1))
			(= modNum gCurRoomNum)
		)
		(if (and (ResCheck rsMESSAGE modNum) (Message msgGET modNum noun theVerb case 1))
			(gMessager say: noun theVerb case 0 0 modNum)
		else
			(gGame pragmaFail:)
		)
	)

	(method (lashNotify param1)
		(if (and argc (not param1) (IsFlag 65))
			(lashSound number: 5 loop: 1 play:)
		)
		(return -1)
	)

	(method (criticalAlert))

	(method (setScript param1)
		(if script
			(script dispose:)
		)
		(if (and argc param1)
			(if gLashInterface
				(gLashInterface
					dispScript: (param1 start: -1 init: self &rest yourself:)
				)
			else
				(param1 init: self &rest)
			)
		)
	)
)

(instance backView of View
	(properties
		view 301
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance metroButn of Button
	(properties
		view 301
		loop 1
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(if (OneOf gCurRoomNum 130 180 185 190) ; profiles, tacticsMenu
			(gCurRoom newRoom: 6000)
		else
			(gCurRoom newRoom: 35) ; metroExt
		)
	)
)

(instance cancelButn of Button
	(properties
		view 301
		loop 4
	)

	(method (doVerb)
		(= local0 1)
	)
)

(instance quitButn of Button
	(properties
		view 301
		loop 3
	)

	(method (doVerb)
		(= local0 1)
		(= gQuit 2)
	)
)

(instance mainMenuButn of Button
	(properties
		view 301
		loop 2
	)

	(method (doVerb)
		(= local0 1)
		(= local1 1)
	)
)

(instance tacticsButn of Button
	(properties
		view 301
		loop 7
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(gCurRoom newRoom: 180) ; tacticsMenu
	)
)

(instance profilesButn of Button
	(properties
		view 301
		loop 6
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(gCurRoom newRoom: 130) ; profiles
	)
)

(instance travelButn of Button
	(properties
		view 301
		loop 12
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(gCurRoom newRoom: 100)
	)
)

(instance academyButn of Button
	(properties
		view 301
		loop 8
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(gCurRoom newRoom: 205)
	)
)

(instance angelesButn of Button
	(properties
		view 301
		loop 11
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(if (and (== gCurRoomNum 300) (IsFlag 106))
			(gCurRoom newRoom: 320)
		else
			(gCurRoom newRoom: 310)
		)
	)
)

(instance combatButn of Button
	(properties
		view 301
		loop 15
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(gCurRoom newRoom: 195)
	)
)

(instance sniperBriefButn of Button
	(properties
		view 301
		loop 10
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(gCurRoom newRoom: 300)
	)
)

(instance assaulterBriefButn of Button
	(properties
		view 301
		loop 9
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(gCurRoom newRoom: 200)
	)
)

(instance controlPanelButn of Button
	(properties
		view 301
		loop 14
	)

	(method (doVerb)
		(= local0 1)
		(gGame panelObj: gGame panelSelector: 863)
	)
)

(instance prevCareerButn of Button
	(properties
		view 301
		loop 5
	)

	(method (doVerb)
		(= local0 1)
		(plane priority: 1)
		(FrameOut)
		(UpdatePlane plane)
		(gCurRoom newRoom: 25) ; prevCareerId
	)
)

(instance HotspotRemoveCheck of Code
	(properties)

	(method (doit param1)
		(if (param1 isKindOf: HotSpot)
			(param1 dispose:)
		)
	)
)

(instance lashSound of Sound
	(properties)
)

