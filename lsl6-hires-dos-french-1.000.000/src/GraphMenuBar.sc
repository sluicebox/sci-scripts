;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 913)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	GraphMenuBar 0
)

(local
	local0
)

(class GraphMenuBar of Set
	(properties
		view -1
		loop 0
		cel 0
		x 0
		y 0
		curTitle 0
		state 0
		nextTitle 0
		plane 0
	)

	(method (init)
		(= gGraphMenuBar self)
		(if (not plane)
			(= plane (gSystemPlane new:))
		)
		(plane picture: -2 back: 0 priority: -1 init: addCast: menuBarCast)
		(= state 4)
		(super init: &rest)
		(self eachElementDo: #init)
	)

	(method (dispose)
		(if (not (& state $0004))
			(self hide:)
		)
		(super dispose: &rest)
		(if plane
			(plane dispose:)
			(= plane 0)
		)
	)

	(method (show)
		(&= state $fffb)
		(self eachElementDo: #show)
		(plane priority: (+ (GetHighPlanePri) 1) setSize:)
		(UpdatePlane
			(plane
				setRect:
					x
					y
					(+ x (- (plane right:) (plane left:)))
					(+ y (- (plane bottom:) (plane top:)))
				yourself:
			)
		)
	)

	(method (hide)
		(= state 4)
		(self eachElementDo: #hide)
		(UpdatePlane (plane priority: -1 setRect: 0 0 1 1 yourself:))
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (& state $0004)
			(return)
		)
		(cond
			((& state $0020)
				(if
					(and
						(= nextTitle (self firstTrue: #handleEvent event))
						(!= nextTitle curTitle)
					)
					(nextTitle select:)
					(FrameOut)
				)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (event modifiers:))
					(= temp0 (self firstTrue: #handleEvent event))
				)
				(|= state $0020)
				(temp0 select:)
				(self doit: event)
				(= temp1 (curTitle curItem:))
				(if curTitle
					(curTitle hide: 0)
				)
				(&= state $ffdf)
				(event claimed: 1)
				(if temp1
					(temp1 cel: 0 select:)
				)
			)
			(else
				(event localize: (menuBarCast plane:))
				(cond
					((= temp2 (self firstTrue: #onMe event))
						(if (or (not local0) (!= gTheCursor gNormalCursor))
							(gGame setCursor: gNormalCursor)
							(= local0 1)
						)
					)
					(local0
						(if (== gTheCursor gNormalCursor)
							(gGame setCursor: (gTheIconBar getCursor:))
						)
						(= local0 0)
					)
				)
			)
		)
	)

	(method (doit param1 &tmp temp0)
		(for
			((= temp0 param1))
			(!= (temp0 type:) 2)
			((= temp0 ((gUser curEvent:) new:)))
			
			(self handleEvent: temp0)
		)
	)
)

(instance menuBarCast of Cast
	(properties)
)

(instance menuTitleCast of Cast
	(properties)
)

(class MenuTitle of Set
	(properties
		mainView -1
		mainLoop 0
		mainCel 0
		x 0
		y 0
		message 0
		curItem 0
		winX 0
		winY 0
		winView 0
		winLoop 0
		winCel 0
		titleView 0
		windowView 0
	)

	(method (init)
		(super init:)
		(self eachElementDo: #client self)
	)

	(method (dispose)
		(if windowView
			(self hide: 0)
		else
			(self release:)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(event localize: (menuBarCast plane:))
		(cond
			((self onMe: event)
				(return self)
			)
			((== (gGraphMenuBar curTitle:) self)
				(event localize: (menuTitleCast plane:))
				(self eachElementDo: #handleEvent event)
			)
		)
		(return 0)
	)

	(method (show param1 &tmp temp0)
		(if (or (not argc) param1)
			(if (not titleView)
				((= titleView (View new:))
					view: mainView
					loop: mainLoop
					cel: mainCel
					posn: x y
					init: menuBarCast
				)
			)
		else
			(self curItem: 0)
			(if (not (menuTitleCast plane:))
				((= temp0 (gSystemPlane new:)) init: addCast: menuTitleCast)
			else
				(= temp0 (menuTitleCast plane:))
			)
			(self eachElementDo: #init menuTitleCast)
			((= windowView (View new:))
				view: winView
				loop: winLoop
				cel: winCel
				init: menuTitleCast
			)
			(temp0 priority: (+ (GetHighPlanePri) 1) setSize:)
			(UpdatePlane
				(temp0
					setRect:
						winX
						winY
						(+ winX (- (temp0 right:) (temp0 left:)))
						(+ winY (- (temp0 bottom:) (temp0 top:)))
					yourself:
				)
			)
		)
	)

	(method (hide param1)
		(if (or (not argc) param1)
			(if titleView
				(titleView dispose:)
				(= titleView 0)
			)
		else
			(gGraphMenuBar curTitle: 0)
			(UpdateScreenItem (titleView cel: 0 yourself:))
			(self eachElementDo: #dispose)
			(windowView dispose:)
			(= windowView 0)
			(UpdatePlane
				((menuTitleCast plane:) priority: -1 setRect: 0 0 1 1 yourself:)
			)
		)
	)

	(method (onMe param1)
		(return (and titleView (titleView onMe: param1)))
	)

	(method (select)
		(if (gGraphMenuBar curTitle:)
			(UpdateScreenItem
				(((gGraphMenuBar curTitle:) titleView:) cel: 0 yourself:)
			)
			((gGraphMenuBar curTitle:) hide: 0)
		)
		(gGraphMenuBar curTitle: self)
		(UpdateScreenItem (titleView cel: 1))
		(self show: 0)
		(FrameOut)
	)
)

(class MenuItem of View
	(properties
		client 0
	)

	(method (select &tmp temp0)
		(return 0)
	)

	(method (handleEvent event)
		(cond
			((self onMe: event)
				(if (!= (client curItem:) self)
					(client curItem: self)
					(= cel 1)
					(UpdateScreenItem self)
					(FrameOut)
				)
			)
			((== cel 1)
				(if (== (client curItem:) self)
					(client curItem: 0)
				)
				(= cel 0)
				(UpdateScreenItem self)
				(FrameOut)
			)
		)
	)
)

