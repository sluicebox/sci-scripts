;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm6 0
)

(synonyms
	(cop detective)
)

(local
	local0
	local1
)

(instance James of Feature
	(properties)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			(
				(not
					(or
						(gEgo inRect: 124 128 192 165)
						(and
							(gEgo inRect: 193 145 240 154)
							(== (gEgo loop:) 1)
						)
					)
				)
				(if (not (Said '/james'))
					(return)
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((Said 'look/desk')
				(Print 6 0) ; "This is the desk where detective James Simpson does his creative report writing."
			)
			((Said 'look/james,simpson,man,cop')
				(Print 6 1) ; "James is one cool dude."
			)
			((or (Said 'talk/james,simpson,man,cop') (Said 'hello'))
				(if (== global172 1)
					(Print 6 2) ; ""What can I do for you ?" says Detective Simpson."
				else
					(switch (Random 0 2)
						(0
							(Print 6 3) ; "Detective James Simpson says, "What a rat race burglary division is becoming. Someday, maybe, I'll be working homicide.""
						)
						(1
							(Print 6 4) ; "Bonds," says Simpson, "this ain't the homicide office."
						)
						(2
							(Print 6 5) ; "Chuckling, Detective Simpson says to you, "Hey Bonds, you should have been with us on the big caper last night.""
							(Print 6 6) ; "Simpson continues, "We made a pinch on this squirrelly pecker wood who was raiding clothes lines over at the college dorm. He had in his possession, 15 jockstraps, 23 pair of panties and one paper bag over his head !""
						)
					)
				)
			)
			((Said 'talk,ask>')
				(cond
					((not global172)
						(event claimed: 1)
						(Print 6 7) ; "I don't know what you are talking about. Go ask somebody else."
					)
					(
						(or
							(Said '/browning,burglary')
							(Said '//browning,burglary')
						)
						(Print 6 8) ; "Oh yes," says Detective Simpson, "we just worked a recent pawn shop burglary."
						(Print 6 9) ; "Simpson continues, "Taken in that burglary were two shotguns, a 32 automatic with silencer, and ammunition.""
						(SetScore 2 92)
						(++ local0)
					)
					(
						(or
							(Said '/print,finger,fingerprint,thumb')
							(Said '//print,finger,fingerprint,thumb')
						)
						(Print 6 10) ; "Affirmative on the prints," says Jim, "we dusted everything. Bains' prints were all over that shotgun."
						(SetScore 2 93)
						(++ local0)
					)
					((or (Said '/number<serial') (Said '//number<serial'))
						(Print 6 11) ; "Checking his notes he says, "The number of the 32 auto is BHG5556947. The numbers on the two shotguns are BSG12P3170 and WSGA122372.""
					)
					((Said '/*')
						(if (>= local0 6)
							(Print 6 12) ; "James says, "I have a lot of work to do Bonds.""
						else
							(Print 6 2) ; ""What can I do for you ?" says Detective Simpson."
						)
					)
				)
			)
		)
	)
)

(instance William of Feature
	(properties)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			(
				(not
					(or
						(gEgo inRect: 190 128 239 146)
						(and
							(gEgo inRect: 193 145 240 154)
							(== (gEgo loop:) 3)
						)
					)
				)
				(cond
					((not (Said '/cole,willie,jerome'))
						(return)
					)
					((== local1 0)
						(Print 6 13) ; "Detective Jerome is not here right now."
					)
					(else
						(proc0_7) ; "You're not close enough."
					)
				)
			)
			((Said 'look/desk')
				(Print 6 14) ; "This is the desk of detective William Jerome."
			)
			((Said 'ask')
				(if (== local1 0)
					(Print 6 13) ; "Detective Jerome is not here right now."
				else
					(Print 6 15) ; "I'm sorry Sonny, but I can't help you with that."
				)
			)
			((or (Said '/cole,willie,jerome,man,cop>') (Said 'hello>'))
				(cond
					((== local1 0)
						(event claimed: 1)
						(Print 6 13) ; "Detective Jerome is not here right now."
					)
					((Said 'look')
						(Print 6 16) ; "Willie is working industriously."
					)
					((or (Said 'talk') (Said 'hello'))
						(switch (Random 0 4)
							(0
								(Print 6 17) ; ""Sonny my man," says Detective William 'Willie' Jerome."
							)
							(1
								(Print 6 18) ; ""Ain't no murder suspects in here!" says Willie."
							)
							(2
								(Print 6 19) ; "Detective Jerome says, "What are you looking for?""
							)
							(3
								(Print 6 20) ; ""Homicide's down the hall son !" Jerome says."
							)
							(4
								(Print 6 21) ; "Well!" says Willie, "if it ain't the #1 homicide dick of Lytton."
							)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance Robert of Feature
	(properties)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((not (gEgo inRect: 56 120 120 146))
				(cond
					((not (Said '/lieutenant,bob,adams'))
						(return)
					)
					((<= local1 1)
						(Print 6 22) ; "Lieutenant Adams is not here right now."
					)
					(else
						(proc0_7) ; "You're not close enough."
					)
				)
			)
			((Said 'look/desk')
				(Print 6 23) ; "This is the desk where Lieutenant Adams counts down to his retirement."
			)
			((Said 'ask')
				(if (<= local1 1)
					(Print 6 22) ; "Lieutenant Adams is not here right now."
				else
					(Print 6 24) ; "I haven't been working any burglaries that have involved homicides, Sonny."
				)
			)
			((or (Said '/lieutenant,bob,adams,man,cop>') (Said 'hello>'))
				(cond
					((<= local1 1)
						(event claimed: 1)
						(Print 6 22) ; "Lieutenant Adams is not here right now."
					)
					((Said 'look')
						(Print 6 25) ; "Lieutenant Adams seems to be pondering what he will do when he retires."
					)
					((or (Said 'talk') (Said 'hello'))
						(switch (Random 0 2)
							(0
								(Print 6 26) ; "Lieutenant Adams tells you, "I could care less about this joint. I'm just sitting here biding my time, and waiting for my pension.""
							)
							(1
								(Print 6 27) ; "I don't know what I'm doing here," says the Lieutenant, "I'd rather sell motor homes in Siberia !"
							)
							(2
								(Print 6 28) ; "The Lieutenant says to you, "Hey Sonny, I'll trade you these lieutenant bars for a one way ticket to Mexico""
							)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said '/yes')
				(Print 6 29) ; "Just kidding, I like Chinese food."
			)
		)
	)
)

(instance Laura of Feature
	(properties)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			(
				(not
					(or
						(gEgo inRect: 137 116 300 129)
						(and
							(gEgo inRect: 137 116 300 135)
							(== (gEgo loop:) 3)
						)
					)
				)
				(cond
					((not (Said '/holt,woman'))
						(return)
					)
					((> local1 2)
						(Print 6 30) ; "Detective Gomez is not here right now."
					)
					(else
						(proc0_7) ; "You're not close enough."
					)
				)
			)
			((Said 'look/desk')
				(Print 6 31) ; "When she's here, Burglary Detective Laura Gomez claims this desk."
			)
			((Said 'kiss')
				(Print 6 32) ; "No thanks, my husband may not like it."
			)
			((Said 'ask')
				(if (> local1 2)
					(Print 6 30) ; "Detective Gomez is not here right now."
				else
					(Print 6 33) ; "I'm sorry, but I can't help you with that."
				)
			)
			((or (Said '/holt,woman,cop>') (Said 'hello>'))
				(cond
					((> local1 2)
						(event claimed: 1)
						(Print 6 30) ; "Detective Gomez is not here right now."
					)
					((Said 'look')
						(Print 6 34) ; "Laura works eagerly away on her current case."
					)
					((or (Said 'talk') (Said 'hello'))
						(switch (Random 0 2)
							(0
								(Print 6 35) ; "Hi, Sonny," says Laura, "long time no see."
							)
							(1
								(Print 6 36) ; "Detective Laura Gomez comments, "Sure is nice to be out of Traffic Division and into Burglary for a change.""
							)
							(2
								(Print 6 37) ; "Laura says, "Have you seen Marie lately? What a sweet girl she turned out to be.""
							)
						)
					)
					((Said 'kiss,pinch,fuck')
						(switch (Random 0 1)
							(0
								(Print 6 38) ; "In an angry tone of voice, Laura says, "Why, you crap house RAT! I oughta slap your eye balls out!""
							)
							(1
								(Print 6 39) ; "Detective Gomez verbally assaults you, "Listen gutter mouth!" she says, "the only reason I don't drop kick-you over this desk right now is because, no doubt, the obvious lack of oxygen to your brain has apparently rendered you a mental defect!""
							)
						)
					)
				)
			)
		)
	)
)

(instance Computer of Feature
	(properties)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((not (gEgo inRect: 193 145 240 154))
				(if (Said '/computer')
					(proc0_7) ; "You're not close enough."
				else
					(return)
				)
			)
			((Said 'look/desk')
				(Print 6 40) ; "On this desk rests a workable computer."
			)
			((Said 'turn<on/computer')
				(Print 6 41) ; "Look at it first."
			)
			((Said 'look,use/computer')
				(gCurRoom newRoom: 8)
			)
		)
	)
)

(instance rm6 of Rm
	(properties
		picture 6
		style 5
	)

	(method (dispose)
		(gFeatures eachElementDo: #dispose 84)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 1)
		(Load rsVIEW 68)
		(super init:)
		(self setFeatures: Laura James William Robert Computer)
		(self setLocales: 153 156)
		(HandsOn)
		(= local0 0)
		(= local1 (Random 0 4))
		(= global212 3)
		(if (!= gPrevRoomNum 8)
			(User prevDir: 1)
			(gEgo posn: 87 158 setMotion: MoveTo 87 10)
		)
		(gEgo view: 1 setCycle: Walk illegalBits: $8000 init:)
		(if (<= local1 2)
			((View new:) view: 68 posn: 185 125 loop: 0 cel: 0 init: addToPic:)
		)
		(if (!= local1 0)
			((View new:) view: 68 posn: 206 142 loop: 0 cel: 1 init: addToPic:)
		)
		((View new:) view: 68 posn: 182 148 loop: 0 cel: 3 init: addToPic:)
		(if (> local1 1)
			((View new:) view: 68 posn: 92 112 loop: 0 cel: 2 init: addToPic:)
		)
		(self setScript: rm6Script)
	)
)

(instance rm6Script of Script
	(properties)

	(method (doit)
		(if (> (gEgo y:) 160)
			(gCurRoom newRoom: 2)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '/flyer,painting')
								(Print 6 42) ; "Looking at the peaceful, relaxing poster of the South Sea Isles almost throws your brain into neutral."
							)
							((Said '/wastebasket,garbage')
								(Print 6 43) ; "The wastebasket is over-flowing with discarded paper."
							)
							((Said '[<at,around][/(!*,chamber,office)]')
								(Print 6 44) ; "The Burglary Office is furnished with the regular stuff, bulletin boards, desks, a wall map, bookcase and computer."
							)
						)
					)
					((Said 'empty,clean[/newspaper,garbage,basket]')
						(Print 6 45) ; "The people in Burglary will do that...someday."
					)
				)
			)
		)
	)
)

