;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use n001)
(use Talker)
(use StopWalk)
(use Motion)
(use Actor)

(local
	[guardList 33] = [1 2 3 0 4 5 6 7 8 9 10 11 12 0 13 14 15 0 16 17 18 19 20 21 22 23 24 25 26 27 28 0 29]
	[guardSpecList 4] = [42 '//bazaar' 0 0]
)

(class GuardCode
	(properties
		client 0
		mouth 0
		doesMove 0
	)

	(method (new)
		(Clone self)
	)

	(method (init theClient isMover &tmp theView)
		(= doesMove (if (>= argc 2) isMover else 0))
		(= client theClient)
		(client
			view: (if doesMove 294 else 295)
			loop: (if doesMove 2 else 7)
			tLoop: -1
			color: 0
			back: 15
			msgFile: 294
			myName: '//guard,man'
			title: {Guard:}
			description: {a local guard}
			lookStr: {He is one of the local guards.}
		)
		((= mouth (Prop new:))
			name: {guardMouth}
			view: 295
			stopUpd:
			init:
			hide:
		)
		(if doesMove
			(client setCycle: StopWalk 295)
		else
			(client stopUpd:)
		)
	)

	(method (atGen whatElement)
		(return [guardList whatElement])
	)

	(method (atSpec whatElement)
		(return [guardSpecList whatElement])
	)

	(method (respond event question)
		(if (== question 32)
			(client showSelf:)
			(return 1)
		else
			(return 0)
		)
	)

	(method (startTalking &tmp theLoop theX theZ)
		(if doesMove
			(client setMotion: 0 view: 295)
			(Face client gEgo)
		)
		(switch (client loop:)
			(3
				(return)
			)
			(0
				(= theLoop 5)
				(= theX 5)
				(= theZ 38)
			)
			(1
				(= theLoop 6)
				(= theX -2)
				(= theZ 38)
			)
			(else
				(= theLoop 4)
				(= theX -1)
				(= theZ 39)
			)
		)
		(mouth
			loop: theLoop
			x: (+ (client x:) theX)
			y: (client y:)
			z: theZ
			signal: 16384
			setCycle: Fwd
			show:
		)
	)

	(method (stopTalking)
		(mouth setCycle: 0 stopUpd: hide:)
	)

	(method (dispose)
		(mouth dispose:)
		(DisposeClone self)
	)
)

(class Guard of Talker
	(properties
		nameNum 0
		guardCode 0
	)

	(method (init isMover)
		((= guardCode (GuardCode new:)) init: self isMover)
		(super init:)
	)

	(method (dispose)
		(guardCode dispose:)
		(super dispose:)
	)

	(method (messages)
		(super messages: &rest)
		(guardCode startTalking:)
	)

	(method (endTalk)
		(super endTalk:)
		(guardCode stopTalking:)
	)

	(method (atGen whatElement)
		(guardCode atGen: whatElement)
	)

	(method (atSpec whatElement)
		(guardCode atSpec: whatElement)
	)

	(method (respond event question)
		(if (not (guardCode respond: event question))
			(super respond: event question &rest)
		)
	)
)

