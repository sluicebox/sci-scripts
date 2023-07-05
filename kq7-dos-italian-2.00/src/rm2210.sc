;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2210)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm2210 0
)

(instance rm2210 of KQRoom
	(properties
		picture 2201
	)

	(method (init)
		(gGame handsOff:)
		(SetFlag 21)
		(super init: &rest)
		(Load rsMESSAGE 2200)
		((ScriptID 7001 4) client: ed view: 2235 loop: 22) ; edgerTalker
		((ScriptID 13 0) client: ros view: 2235 loop: 21) ; aEgoTalker
		(if (!= (gKqMusic1 number:) 2282)
			(gKqMusic1
				stop:
				number: 2282
				setLoop: -1
				play:
				setVol: 0
				fade: 65 25 10 0
			)
		)
		(self setScript: sheWantsIt)
	)
)

(instance sheWantsIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thePair init:)
				(= cycles 2)
			)
			(1
				(thePair setCycle: End self)
			)
			(2
				(thePair loop: 1 cel: 0 posn: 155 139 setCycle: End self)
			)
			(3
				(ros init:)
				(ed init:)
				(gMessager sayRange: 0 0 10 10 11 self 2200) ; "(DEEPLY ASHAMED)Rosella...it was I who lured you into this world. I--kidnapped you. I know you can never forgive me, but please let me assure you that I was not in my right mind. I would never..."
			)
			(4
				(gGame handsOn:)
				(gCurRoom newRoom: 34)
				(self dispose:)
			)
		)
	)
)

(instance thePair of Prop
	(properties
		x 141
		y 143
		view 2235
	)
)

(instance ros of Prop
	(properties
		x 155
		y 139
		view 2235
		loop 21
	)
)

(instance ed of Prop
	(properties
		x 155
		y 139
		view 2235
		loop 22
	)
)

