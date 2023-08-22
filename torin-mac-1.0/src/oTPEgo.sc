;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64007)
(include sci.sh)
(use Main)
(use oInterface)
(use Feature)
(use StopWalk)
(use Grooper)
(use Ego)
(use Motion)
(use Actor)
(use System)

(public
	oTPEgo 0
	soEgoGetLow 1
	soEgoGetMed 2
	soEgoGetHigh 3
)

(local
	oCueTemp
)

(instance oWalkFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= nsTop (= nsLeft 0))
		(= nsRight (plane getWidth:))
		(= nsBottom (plane getHeight:))
		(self myPriority: -1)
	)

	(method (dispose)
		(super dispose: &rest)
		(= plane 0)
	)

	(method (handleEvent event)
		(if
			(and
				(== global101 1)
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				gEgo
				(gEgo plane:)
				(gEgo isNotHidden:)
				((gEgo plane:) isEnabled:)
			)
			(event localize: (gEgo plane:))
			(event type: $5000) ; evVERB | evMOVE
			(gEgo handleEvent: event)
			(event claimed: 0)
		)
		(return 0)
	)
)

(class TorinEgo of Ego
	(properties
		oMyVerbHandlers 0
		oCantBeHereHandler 0
	)

	(method (addVerbHandler oHandler)
		(if (not oMyVerbHandlers)
			(= oMyVerbHandlers (Set new:))
		)
		(oMyVerbHandlers addToFront: oHandler)
	)

	(method (deleteVerbHandler oHandler)
		(if oMyVerbHandlers
			(oMyVerbHandlers delete: oHandler)
		)
	)

	(method (cantBeHere)
		(if oCantBeHereHandler
			(oCantBeHereHandler doit:)
		else
			(super cantBeHere:)
		)
	)

	(method (dispose)
		(if oMyVerbHandlers
			(oMyVerbHandlers dispose:)
			(= oMyVerbHandlers 0)
		)
		(if oCantBeHereHandler
			(oCantBeHereHandler dispose:)
			(= oCantBeHereHandler 0)
		)
		(super dispose: &rest)
	)

	(method (checkVerbHandlers &tmp node oHandler)
		(if oMyVerbHandlers
			(for
				((= node (oMyVerbHandlers first:)))
				node
				((= node (oMyVerbHandlers next: node)))
				
				(if (and (= oHandler (KList 8 node)) (oHandler doVerb: &rest)) ; NodeValue
					(return 1)
				)
			)
		)
		(return 0)
	)
)

(class VerbHandler of Obj
	(properties)

	(method (doVerb))
)

(instance oTPEgo of TorinEgo
	(properties
		view 60100
	)

	(method (init)
		(super init: &rest)
		(oWalkFeature init: (ScriptID 0 1)) ; oBackgroundPlane
		(self addHotspotVerb: 13)
	)

	(method (dispose)
		(if (oWalkFeature plane:)
			(oWalkFeature dispose:)
		)
		(super dispose: &rest)
	)

	(method (get oItem)
		(if (== (oItem oMyHandler:) (ScriptID 64001 1)) ; oBoogleHandler
			(ActivateBoogleInventory)
		else
			(ActivateGameInventory)
		)
		(super get: oItem &rest)
	)

	(method (doVerb theVerb)
		(if (not (self checkVerbHandlers: theVerb))
			(switch theVerb
				(13 ; ioEressdy
					(gMessager say: 1 13 0 0 0 0) ; "There's no use to do that now...I'll save it for a phenocryst."
				)
				(33 ; ioClothespin
					(gMessager say: 1 33 0 0 0 0) ; "I could do that...but it doesn't smell THAT bad here."
				)
			)
		)
	)

	(method (normalize keepScale theView theLoop)
		(if (== argc 3)
			(self loop: theLoop)
		else
			(self loop: 2)
		)
		(= heading
			(switch loop
				(0 90)
				(1 270)
				(2 180)
				(3 0)
				(4 135)
				(5 225)
				(6 45)
				(7 315)
			)
		)
		(if (not (and argc keepScale))
			(self
				oldScaleX: 128
				scaleX: 128
				scaleY: 128
				setScale: 0
				setScaler: 0
				setStep: 12 5
			)
		)
		(self
			view: (if (> argc 1) theView else 60100)
			z: 0
			setMotion: 0
			setLooper: Grooper
			setLoop: -1
			setPri: -1
			illegalBits: 0
			setCycle: StopWalk -1
			setSpeed: (gGame nGameSpeed:)
			state: (|= state $0002)
			edgeHit: EDGE_NONE
			ignoreActors: 1
		)
	)
)

(class SoEgoGet of Script
	(properties
		poMyEgo 0
		poMyEgoView 60101
	)

	(method (dispose)
		(gEgo show:)
		(if poMyEgo
			(poMyEgo dispose:)
			(= poMyEgo 0)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp nLoop nCels)
		(switch (= state newState)
			(0
				(gEgo stopwalk:)
				(= nLoop (gEgo cel:))
				(= poMyEgo (Prop new:))
				(switch poMyEgoView
					(60101
						(poMyEgo view: (+ 60700 nLoop))
					)
					(60102
						(poMyEgo view: (+ 60800 nLoop))
					)
					(60103
						(poMyEgo view: (+ 60900 nLoop))
					)
					(else
						(poMyEgo view: (poMyEgo view:))
						(PrintDebug
							{Encountered unknown view in generic get script}
						)
					)
				)
				(poMyEgo
					loop: 0
					cel: 0
					posn: (gEgo x:) (gEgo y:)
					setPri: (gEgo priority:)
					yourself:
				)
				(if (& (gEgo scaleSignal:) $0001)
					(poMyEgo
						setScale:
						scaleX: (gEgo scaleX:)
						scaleY: (gEgo scaleY:)
					)
				)
				(= nCels (- (/ (+ (poMyEgo lastCel:) 1) 2) 1))
				(gEgo hide:)
				(poMyEgo init: setCycle: CT nCels 1 self)
			)
			(1
				(poMyEgo setCycle: End self)
				(if register
					(register cue:)
					(= register 0)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soEgoGetHigh of SoEgoGet
	(properties)
)

(instance soEgoGetMed of SoEgoGet
	(properties
		poMyEgoView 60102
	)
)

(instance soEgoGetLow of SoEgoGet
	(properties
		poMyEgoView 60103
	)
)

