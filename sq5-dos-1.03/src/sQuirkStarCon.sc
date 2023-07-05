;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use rm201)
(use Osc)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	sQuirkStarCon 0
	sDistressCall 1
	sQuirkClorox 2
	sQuirkPuked 3
)

(instance sDistressCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 33)
				(= seconds 2)
			)
			(1
				(proc201_6 self)
			)
			(2
				(gMessager say: 9 0 0 1 self 202) ; "I'm picking up a weak signal on an emergency frequency, Captain. I'm putting it on screen."
			)
			(3
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(4
				(self setScript: (ScriptID 209 0) self 210) ; sStartViewPort
			)
			(5
				(gMessager say: 9 0 0 2 self 202) ; "...Mayday, Mayday this is the SCS Goliath. Any confederation ships in range, please respond..."
				(gSq5Music1 number: 28 loop: -1 play:)
			)
			(6
				(quirkScaredMouth init: setCycle: ForwardCounter 5 self)
			)
			(7
				(gMessager say: 9 0 0 3 self 202) ; "...SCS Goliath, repeat we're under attack. They came through... shuttle bay..."
			)
			(8
				(quirkPuke init: setCycle: Osc 4 self)
			)
			(9
				(quirkPuke dispose:)
				(quirkScaredMouth dispose:)
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(10
				(= seconds 1)
			)
			(11
				(proc201_6 self)
			)
			(12
				(gMessager say: 9 0 0 4 self 202) ; "I'm sorry sir, I've lost the transmission."
			)
			(13
				(gMessager say: 9 0 0 5 self 202) ; "The message was too brief to pin down the exact source. But I've narrowed it down to the region of the Thrakus system."
			)
			(14
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
				(gSq5Music1 fade:)
			)
			(15
				(gMessager say: 16 0 0 1 self 202) ; "Meanwhile--On the SCS Goliath..."
			)
			(16
				(gCurRoom newRoom: 215)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 211)
	)
)

(instance sQuirkPuked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc201_21)
				(= seconds 2)
			)
			(1
				(proc201_6 self)
			)
			(2
				(gMessager say: 17 0 16 1 self 202) ; "We're being hailed by the Goliath, Captain. Putting it on screen."
			)
			(3
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(4
				(self setScript: (ScriptID 209 0) self 204) ; sStartViewPort
			)
			(5
				(gMessager say: 17 0 0 1 self 202) ; "Hello again Wilco, you insignificant little pimple on the behind of humanity."
			)
			(6
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(7
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 211)
	)
)

(instance sQuirkStarCon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: (ScriptID 209 0) self 209) ; sStartViewPort
			)
			(1
				(gMessager say: 21 0 35 0 self) ; "This is the SCS Goliath. Who's using this frequency?! Oh, I might have known--it's you Wilco."
				(SetFlag 34)
			)
			(2
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 211)
	)
)

(instance sQuirkClorox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 92)
				(SetScore 179 10)
				(proc201_21)
				(= cycles 1)
			)
			(1
				(self setScript: (ScriptID 209 0) self 209) ; sStartViewPort
			)
			(2
				(gMessager say: 7 0 0 0 self 202) ; "This better be important, Wilco!"
			)
			(3
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(4
				(if (IsFlag 97)
					(gGame handsOn:)
					(self dispose:)
				else
					(proc201_7 self)
				)
			)
			(5
				(gMessager say: 7 0 6 1 self 202) ; "I see Quirk is his usual charming self. It's nice to see he hasn't lost his flair for diplomacy."
			)
			(6
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 211)
	)
)

(instance quirkScaredMouth of Prop
	(properties
		x 148
		y 88
		view 210
		loop 2
		priority 7
		signal 16400
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance quirkPuke of Prop
	(properties
		x 131
		y 79
		view 210
		loop 4
		priority 8
		signal 16400
	)
)

