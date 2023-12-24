;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 112)
(include sci.sh)
(use Main)
(use n001)
(use Dance)
(use LoadMany)
(use QSnd)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm112 0
)

(local
	musicianInCast
	musicianPausedSignal
	[danceSteps 217] = [2 0 0 0 2 1 0 15 2 2 0 17 2 3 0 20 4 4 2 3 4 4 4 7 4 4 2 3 5 -19 0 0 2 5 0 0 4 6 2 5 4 6 2 1 2 7 0 0 4 8 2 3 4 8 4 7 4 8 2 3 3 7 0 0 4 6 1 5 4 6 1 1 3 5 0 0 5 16 0 0 4 4 1 7 4 4 2 3 4 4 1 7 0 113 0 0 2 0 0 0 2 2 4 0 5 -27 0 0 2 1 0 0 2 3 4 0 0 112 0 0 2 5 0 0 0 113 0 0 4 4 0 3 2 4 0 3 4 4 0 3 2 4 0 3 4 4 0 3 2 4 0 3 4 4 0 3 2 4 0 3 4 4 0 3 2 4 0 3 4 4 0 3 2 4 0 3 4 4 0 3 2 4 0 3 4 4 0 3 2 4 0 3 6 200 107 0 2 5 0 0 1 6 0 10 2 7 0 0 0 112 0 0 3 0 0 20 8]
)

(instance rm112 of Rm
	(properties
		picture 110
		style 6
	)

	(method (init)
		(LoadMany rsVIEW 112 113 111 110)
		(Load rsSOUND 112)
		(LoadMany rsSCRIPT 969)
		(super init:)
		(gEgo posn: 1000 1000 init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(shema init:)
		(egoSilhouette init:)
		(nearLamp init:)
		(farLamp init:)
		(nearFlame init:)
		(farFlame init:)
		(= musicianInCast 1)
		(musician init:)
		(if (< gHowFast 2)
			(musician addToPic:)
			(= musicianInCast 0)
		)
		(MenuBar state: 0)
		(SL disable:)
		(gAddToPics doit:)
		(self setScript: rmScript)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_RETURN)
			(dance dispose:)
		else
			(event claimed: 1)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(MenuBar state: 1)
		(SL enable:)
		(super dispose:)
	)
)

(instance shema of Actor
	(properties
		x 200
		y 107
		yStep 1
		view 112
		cycleSpeed 1
		xStep 1
		moveSpeed 1
	)
)

(instance musician of Prop
	(properties
		x 110
		y 88
		view 111
		loop 1
		signal 16
		cycleSpeed 6
	)
)

(instance farLamp of PicView
	(properties
		x 88
		y 115
		view 110
		loop 1
	)
)

(instance nearLamp of PicView
	(properties
		x 226
		y 156
		view 110
		loop 1
		cel 1
	)
)

(instance egoSilhouette of PicView
	(properties
		x 249
		y 167
		view 110
		loop 2
	)
)

(instance farFlame of PicView
	(properties
		x 88
		y 97
		view 110
		loop 3
	)
)

(instance nearFlame of PicView
	(properties
		x 226
		y 136
		view 110
		loop 3
	)
)

(instance bellySound of QSnd
	(properties
		number 112
		priority 10
	)
)

(instance dance of DQSnd
	(properties)

	(method (at n)
		(return [danceSteps n])
	)

	(method (cue &tmp aSignal)
		(super cue: &rest)
		(if musicianInCast
			(cond
				((> (= aSignal (theMusic prevSignal:)) musicianPausedSignal)
					(musician setCycle: Fwd)
					(= musicianPausedSignal 32767)
				)
				((OneOf (theMusic prevSignal:) 140 147 156 456)
					(musician setCel: 2 setCycle: 0)
					(= musicianPausedSignal aSignal)
				)
			)
		)
	)

	(method (dispose)
		(SetFlag 161) ; fSeenShow
		(HighPrint 112 0) ; "You applaud loudly and long for your friend Shema's dancing prowess."
		(gCurRoom newRoom: 100)
		(super dispose:)
	)
)

(instance rmScript of Script
	(properties
		cycles 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(SetCursor gTheCursor 0)
				(= seconds 2)
			)
			(2
				(shema setScript: dance bellySound)
				(self dispose:)
			)
		)
	)
)

