;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use n001)
(use Merchant)
(use Timer)
(use Motion)

(local
	[merchantGenList 32] = [1 2 3 0 4 5 6 7 8 0 9 10 11 0 12 0 13 0 14 0 15 16 17 18 19 20 0 21 22 23 24 0]
	[merchantSpecList 10] = [25 '//shameen' 26 '//shema' 27 '//cousin' 28 '//bazaar' 0 0]
)

(class KattaMerchant of Merchant
	(properties
		view 350
		signal 16384
		color 15
		back 6
		msgFile 350
		isSeated 1
		isOnLeft 1
		clothesColor 0
	)

	(method (init)
		(super init:)
		(= loop (+ (* 2 (not isSeated)) (not isOnLeft)))
		(= tLoop (+ 2 (not isOnLeft)))
		(= timer (SitDownTimer new:))
		(= palette (ChooseFromCycle (+ clothesColor gDay) 1 6))
	)

	(method (atSpecAnswer &tmp what)
		(if (== (= what (super atSpecAnswer:)) 32767)
			(return (self scanSaidSpecs: 668))
		else
			(return what)
		)
	)

	(method (atIndividualSpec)
		(return 0)
	)

	(method (atGen whatElement)
		(return [merchantGenList whatElement])
	)

	(method (atSpec whatElement)
		(return [merchantSpecList whatElement])
	)

	(method (messages)
		(timer seconds: -1)
		(if (and isSeated (not cel))
			(self state: -1 setCycle: End self)
		)
		(super messages: &rest)
	)

	(method (endTalk)
		(super endTalk:)
		(if cel
			(timer setReal: self 5)
		)
		(if isSeated
			(self startUpd:)
		)
	)

	(method (saidMe event &tmp rc)
		(if (not (= rc (super saidMe: event)))
			(= rc (Said '[/catperson]>'))
		)
		(return rc)
	)
)

(class SitDownTimer of Timer
	(properties
		caller 0
	)

	(method (init aClient)
		(super init: aClient &rest)
		(= client self)
		(= caller aClient)
	)

	(method (cue)
		(caller setCycle: Beg)
	)
)

