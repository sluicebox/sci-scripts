;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 144)
(include sci.sh)
(use Main)
(use TalkObj)
(use System)

(public
	sErasmus 0
	sFenrus 1
	sGame 2
	sBrigs 3
	sWarlock 4
	sMirror 5
)

(instance sErasmus of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 144)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 83 1) caller: self) ; hermitTalk
				(HandsOff)
				(Say (ScriptID 83 1) 144 0) ; "E's me friend, 'e and Fenrus. Powerful wizard 'e is.", hermitTalk
			)
			(1
				(Say (ScriptID 83 1) 144 1) ; "I 'ere 'is 'ouse is sumthin' to see up north.", hermitTalk
			)
			(2
				(Say (ScriptID 83 1) 144 2) ; "I don't make it out much, and 'e's pretty busy, sos I don't see 'em too often. But when we do all get together, you can be sure we'll 'ave fun.", hermitTalk
			)
			(3
				(Say (ScriptID 83 1) 144 3) ; "'E loves to play 'is games, 'e do.", hermitTalk
			)
			(4
				(client setScript: (ScriptID 83 2)) ; dummy
				(HandsOn)
			)
		)
	)
)

(instance sFenrus of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 144)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 83 1) caller: self) ; hermitTalk
				(HandsOff)
				(Say (ScriptID 83 1) 144 4) ; "Fenrus is Erasmus' familiar or is that the other way around?", hermitTalk
			)
			(1
				(client setScript: (ScriptID 83 2)) ; dummy
				(HandsOn)
			)
		)
	)
)

(instance sGame of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 144)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 83 1) caller: self) ; hermitTalk
				(HandsOff)
				(Say (ScriptID 83 1) 144 5) ; "Erasmus' favorite game is the Mage's Maze. 'Ave to be a magic user to play it, though. Erasmus is awful good at it.", hermitTalk
			)
			(1
				(client setScript: (ScriptID 83 2)) ; dummy
				(HandsOn)
			)
		)
	)
)

(instance sBrigs of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 144)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 83 1) caller: self) ; hermitTalk
				(HandsOff)
				(Say (ScriptID 83 1) 144 6) ; "Nasty sorts, they is. I sees them sneaking arund the woods all the times. Uther then the Warlock, I 'as nothing to do with them", hermitTalk
			)
			(1
				(client setScript: (ScriptID 83 2)) ; dummy
				(HandsOn)
			)
		)
	)
)

(instance sWarlock of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 144)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 83 1) caller: self) ; hermitTalk
				(HandsOff)
				(Say (ScriptID 83 1) 144 7) ; "E's not so bad. Got a good sense o' 'umor, 'e 'as. I get the giggles just to think of 'im. He heh he heh he.", hermitTalk
			)
			(1
				(Say (ScriptID 83 1) 144 8) ; "'E's come by at times to chat. Borrowed the mirror wot I borrowed from Erasmus 'e did.", hermitTalk
			)
			(2
				(client setScript: (ScriptID 83 2)) ; dummy
				(HandsOn)
			)
		)
	)
)

(instance sMirror of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 144)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 83 1) caller: self) ; hermitTalk
				(HandsOff)
				(Say (ScriptID 83 1) 144 9) ; "A magic mirror of reflection, it was. If you use it, when a nasty spell was cast at you, it was wot sent it back at the one wot cast it. Do un to others, I sez. Heh, he, he.", hermitTalk
			)
			(1
				(client setScript: (ScriptID 83 2)) ; dummy
				(HandsOn)
			)
		)
	)
)

