;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	wearCrown 0
)

(local
	local0
)

(instance wearCrown of Script
	(properties)

	(method (init)
		(= global204 1)
		(Load rsVIEW 370)
		(Load rsVIEW 687)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global189 1)
					(Print 301 0) ; "That wouldn't be a good idea right now."
					(gEgo script: global164)
					(DisposeScript 301)
					(return)
				else
					(HandsOff)
					(self changeState: 1)
				)
			)
			(1
				(= local0 (gEgo viewer:))
				(gSounds eachElementDo: #dispose)
				((Sound new:) number: 59 play:)
				(User canControl: 0 canInput: 0)
				(= global181 (gEgo view:))
				(= gProp (Prop new:))
				(gProp
					x: (gEgo x:)
					y: (gEgo y:)
					view: 687
					loop: 0
					ignoreActors:
					setPri: (+ (gEgo priority:) 1)
					cel: 0
					setCycle: CT 3 1 self
					init:
				)
			)
			(2
				(gProp setCycle: End self)
				(gEgo viewer: 0 view: 370 cycleSpeed: 2 setCycle: Fwd)
			)
			(3
				(Timer setReal: self 5)
				(gProp hide:)
				(Print 301 1) ; "POOF!! You're a little froggy!"
			)
			(4
				(Print 301 2) ; "You don't like the clammy feeling of being a frog. You look around, decide there's no reason to be one right now, and remove the little gold crown."
				((Sound new:) number: 59 play:)
				(gProp
					x: (gEgo x:)
					y: (gEgo y:)
					show:
					cel: 10
					setCycle: CT 3 -1 self
				)
			)
			(5
				(gEgo view: global181 cycleSpeed: 0 setCycle: Walk)
				(gProp setCycle: Beg self)
			)
			(6
				(self changeState: 7)
			)
			(7
				(gProp dispose:)
				(gEgo viewer: local0 script: global164)
				(HandsOn)
				(DisposeScript 301)
			)
		)
	)
)

